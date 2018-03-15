package com.scg.persistent;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.ConsultantTime;
import com.scg.domain.Invoice;
import com.scg.domain.InvoiceLineItem;
import com.scg.domain.NonBillableAccount;
import com.scg.domain.Skill;
import com.scg.domain.TimeCard;
import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * Provides a programmatic interface to store and access objects in the database.
 * @author Brian Stamm
 */
public class DbServer {
	//Block with strings to query database
	/** String SQL statement to insert into clients table */
	private final static String ADD_CLIENT_ACCOUNT_SQL_STATEMENT = "INSERT INTO clients (name, street, city, state, postal_code, contact_last_name, contact_first_name, contact_middle_name) VALUES (?,?,?,?,?,?,?,?)";
	
	/** String SQL statement to query all entries in clients table */
	private final static String QUERY_ALL_CLIENT_ACCOUNT_SQL_STATEMENT = "SELECT name, street, city, state, postal_code, contact_last_name, contact_first_name, contact_middle_name FROM clients";
	
	/** String SQL statement to insert in consultants table */
	private final static String ADD_CONSULTANT_SQL_STATEMENT = "INSERT INTO consultants (last_name, first_name, middle_name)VALUES (?, ?, ?)";
	
	/** String SQL statement to insert in consultants table */
	private final static String QUERY_ALL_CONSULTANT_SQL_STATEMENT = "SELECT last_name, first_name, middle_name FROM consultants";
	
	/** String SQL statement to query a specific consultant in the consultants table */
	private final static String QUERY_SPECIFIC_CONSULTANT_SQL_STATEMENT = "SELECT id FROM consultants WHERE last_name = ? AND first_name = ? AND middle_name = ?";
	
	/** String SQL statement to insert in timecards table */
	private final static String ADD_TIME_CARD_SQL_STATEMENT = "INSERT INTO timecards (consultant_id, start_date) VALUES(?,?)";
	
	/** String SQL statement to insert in billable_hours table */
	private final static String ADD_BILLABLE_SQL_STATMENT = "INSERT INTO billable_hours (client_id, timecard_id, date, skill, hours) VALUES (?,?,?,?,?)";
	
	/** String SQL statement to insert in non_billable_hours table */
	private final static String ADD_NON_BILLABLE_SQL_STATEMENT = "INSERT INTO non_billable_hours (account_name, timecard_id, date, hours) VALUES (?,?,?,?)";
	
	/** String SQL statement to query all needed tables so an invoice can be created */
	private final static String INVOICE_SEARCH = "SELECT b.date, c.last_name, c.first_name, c.middle_name, b.skill, s.rate, b.hours FROM billable_hours b, consultants c, skills s, timecards t WHERE b.client_id = (SELECT DISTINCT id FROM clients WHERE name = ?) AND b.skill = s.name AND b.timecard_id = t.id AND c.id = t.consultant_id AND b.date >= ? AND b.date <= ?";
	
	//Block of variables for this class
	/** String to hold url to database */
    private String dbUrl;
    
    /** String to hold user name to database */
    private String username;
    
    /** String to hold password to database */
    private String password;
	
	/**
	 * Constructor.
	 * @param dbUrl - the database URL
	 * @param username - the database username
	 * @param password - the database password
	 */
	public DbServer(String dbUrl, String username, String password) {
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Add a client to the database, inserts one row in the clients table.
	 * @param client - the client to add
	 * @throws SQLException - if any database operations fail
	 * @throws ClassNotFoundException 
	 */
	public void addClient(ClientAccount client) throws SQLException, ClassNotFoundException {
		
		Address clientAddress = client.getAddress();
		PersonalName clientName = client.getContact();
		
		try(Connection connect = DriverManager.getConnection( dbUrl, username, password );
				PreparedStatement ps = connect.prepareStatement(ADD_CLIENT_ACCOUNT_SQL_STATEMENT);){
			
			ps.setString(1,client.getName());
			ps.setString(2,clientAddress.getStreetNumber());
			ps.setString(3,clientAddress.getCity());
			ps.setString(4,clientAddress.getState().toString());
			ps.setString(5,clientAddress.getPostalCode());
			ps.setString(6,clientName.getLastName());
			ps.setString(7, clientName.getFirstName());
			ps.setString(8, clientName.getMiddleName());
			ps.executeUpdate();
		}
	}
	
	/**
	 * Get all of the clients in the database, selects all rows from the clients table.
	 * @return a list of all of the clients
	 * @throws SQLException - if any database operations fail
	 */
	public List<ClientAccount> getClients() throws SQLException, ClassNotFoundException{
		
		List<ClientAccount> listOfClientAccounts = new ArrayList<>();
		
		try(Connection connect = DriverManager.getConnection( dbUrl, username, password );
				Statement stmnt = connect.createStatement();){
			
			ResultSet rs = stmnt.executeQuery(QUERY_ALL_CLIENT_ACCOUNT_SQL_STATEMENT);
			while(rs.next()) {
				String clientName = rs.getString("name");
				String street = rs.getString("street");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String postal_code = rs.getString("postal_code");
				String contactLast = rs.getString("contact_last_name");
				String contactFirst = rs.getString("contact_first_name");
				String contactMiddle = rs.getString("contact_middle_name");
				
				Address address = new Address(street,city,StateCode.valueOf(state),postal_code);
				PersonalName name = new PersonalName(contactLast,contactFirst,contactMiddle);
				ClientAccount client = new ClientAccount(clientName,name,address);
				
				listOfClientAccounts.add(client);
			}
		}
		return listOfClientAccounts;
	}
	
	/**
	 * Add a consultant to the database, inserts one row in the consultants table.
	 * @param consultant - the consultant to add
	 * @throws SQLException - if any database operations fail
	 */
	public void addConsultant(Consultant consultant) throws SQLException{
		try(Connection connect = DriverManager.getConnection( dbUrl, username, password );
				Statement stmnt = connect.createStatement();
				PreparedStatement ps = connect.prepareStatement(ADD_CONSULTANT_SQL_STATEMENT);){
			ps.setString(1,consultant.getName().getLastName());
	        ps.setString(2,consultant.getName().getFirstName());
	        ps.setString(3,consultant.getName().getMiddleName());
	        ps.executeUpdate();
		}
	}

	/**
	 * Get all of the consultant in the database, selects all rows from the consultants table.
	 * @return a list of all of the consultants
	 * @throws SQLException - if any database operations fail
	 */
	public List<Consultant> getConsultants() throws SQLException {
		List<Consultant> listOfConsultants = new ArrayList<>();
		
		//try with resource block
		try(Connection connect = DriverManager.getConnection( dbUrl, username, password );
				Statement stmnt = connect.createStatement();
				ResultSet rs = stmnt.executeQuery(QUERY_ALL_CONSULTANT_SQL_STATEMENT);){
			
			//add consultants while there are results
			while(rs.next()) {
				String last = rs.getString("last_name");
				String first = rs.getString("first_name");
				String middle = rs.getString("middle_name");
				PersonalName name = new PersonalName(last,first,middle);
				Consultant consultant = new Consultant(name);
				listOfConsultants.add(consultant);
				}
		}
		return listOfConsultants;
	}
	
	/**
	 * Add a timecard to the database, inserts one row in the timecards table as well as zero or more rows in the billable_hours and non_billable_hours tables. The process is as follows:
	 *     1.  obtain the consultant id of the consultant the time card is for from the consultants table
	 *     2.  insert a new record in the timecards table, and capture the generated key for this record
	 *     3.  for each time entry on the time card insert a record into the billable_hours or non_billable_hours as appropriate
	 *             -including the timecard_id of the newly created timecards record
	 * @param timeCard - the timecard to add
	 * @throws SQLException - if any database operations fail
	 */
	public void addTimeCard(TimeCard timeCard) throws SQLException {
		//Attempt to connect, setting the query variables for getting a consultant
		try(Connection connect = DriverManager.getConnection( dbUrl, username, password );
				PreparedStatement ps_specificConsultant = connect.prepareStatement(QUERY_SPECIFIC_CONSULTANT_SQL_STATEMENT);){
			ps_specificConsultant.setString(1, timeCard.getConsultant().getName().getLastName());
			ps_specificConsultant.setString(2, timeCard.getConsultant().getName().getFirstName());
			ps_specificConsultant.setString(3, timeCard.getConsultant().getName().getMiddleName());
			
			//Attempt to get results, entering a timeCard in table
			try(ResultSet rs_specificConsultant = ps_specificConsultant.executeQuery();){
				if(rs_specificConsultant.next()) {
					int consultantId = rs_specificConsultant.getInt(1);
					
					PreparedStatement ps_addTimeCard = connect.prepareStatement(ADD_TIME_CARD_SQL_STATEMENT,Statement.RETURN_GENERATED_KEYS);
					ps_addTimeCard.setInt(1, consultantId);
					ps_addTimeCard.setDate(2,Date.valueOf(timeCard.getWeekStartingDay()));
					ps_addTimeCard.executeUpdate();
					
					//Get ID of timeCard, and add entries in either billable or nonBillable tables
					ResultSet rs_addTimeCard = ps_addTimeCard.getGeneratedKeys();
					rs_addTimeCard.next();  
					int timeCardId = rs_addTimeCard.getInt(1);
					List<ConsultantTime> timeCardHours = timeCard.getConsultingHours();
					
					for(ConsultantTime ct : timeCardHours) {
						if(ct.isBillable()) {
							PreparedStatement ps_addBillable = connect.prepareStatement(ADD_BILLABLE_SQL_STATMENT);
							ps_addBillable.setInt(1, consultantId);
							ps_addBillable.setInt(2, timeCardId);
							ps_addBillable.setDate(3, Date.valueOf(timeCard.getWeekStartingDay()));
							ps_addBillable.setString(4,ct.getSkill().name());
							ps_addBillable.setInt(5, ct.getHours());
							ps_addBillable.executeUpdate();
							}
						else {
							PreparedStatement ps_addNonBillable = connect.prepareStatement(ADD_NON_BILLABLE_SQL_STATEMENT);
							NonBillableAccount nonBill = (NonBillableAccount) ct.getAccount();
							ps_addNonBillable.setString(1, nonBill.name());
							ps_addNonBillable.setInt(2, timeCardId);
							ps_addNonBillable.setDate(3, Date.valueOf(timeCard.getWeekStartingDay()));
							ps_addNonBillable.setInt(4, ct.getHours());
							ps_addNonBillable.executeUpdate();
		            			}
						}
					}
				}
		}
	}
	
	/**
	 * Get clients monthly invoice. Select all of the data from the database needed to construct the invoice 
	 * (billable_hours, consultants, skills, timecards), create the invoice and return it.
	 * @param client - the client to obtain the invoice line items for
	 * @param month - the month of the invoice
	 * @param year - the year of the invoice
	 * @return the clients invoice for the month
	 * @throws SQLException - if any database operations fail
	 */
	public Invoice getInvoice(ClientAccount client,java.time.Month month, int year) throws SQLException {
		//Create invoice
		Invoice invo = new Invoice(client, month, year);
		
		//Get info to fill invoice, if no values, will return an empty invoice
		try(Connection connect = DriverManager.getConnection( dbUrl, username, password );
				PreparedStatement ps = connect.prepareStatement(INVOICE_SEARCH);){
			
			LocalDate startDate = invo.getStartDate();
			LocalDate endDate = startDate.plusMonths(1);
			
			ps.setString(1, client.getName());
			ps.setDate(2, Date.valueOf(startDate));
			ps.setDate(3, Date.valueOf(endDate));
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Date date = rs.getDate(1);
					String lastName = rs.getString(2);
					String firstName = rs.getString(3);
					String middleName = rs.getString(4);
					Skill skill = Skill.valueOf(rs.getString(5));
					int hours = rs.getInt(7);
					
					LocalDate lineDate = date.toLocalDate();
					Consultant consultant = new Consultant(new PersonalName(lastName,firstName,middleName));
					InvoiceLineItem line = new InvoiceLineItem(lineDate,consultant,skill,hours);
					
					invo.addLineItem(line);
				}
			}
		}
		return invo;
	}

}
