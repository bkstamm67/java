package com.scg.persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.ConsultantTime;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * Provides a programmatic interface to store and access objects in the database.
 * @author Brian Stamm
 */
public class DbServer {
	
	Connection connect;
    String dbUrl;
    String driverClassName;
    String username;
    String password;
    
    Statement stmnt;
    PreparedStatement ps;
    ResultSet rs;
	
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
		this.driverClassName = "org.apache.derby.jdbc.ClientDriver";
		this.connect = null;
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
		
		Class.forName( driverClassName );
		connect = DriverManager.getConnection( dbUrl, username, password );
		stmnt = connect.createStatement();
         
         ps = connect.prepareStatement("INSERT INTO clients (name, street, city, state, postal_code,contact_last_name, contact_first_name, contact_middle_name)"
        		 + "VALUES (?,?,?,?,?,?,?,?);\n" +
        		 "",Statement.RETURN_GENERATED_KEYS);
         ps.setString(1,client.getName());
         ps.setString(2,clientAddress.getStreetNumber());
         ps.setString(3,clientAddress.getCity());
         ps.setString(4,clientAddress.getState().toString());
         ps.setString(5,clientAddress.getPostalCode());
         ps.setString(6,clientName.getLastName());
         ps.setString(7, clientName.getFirstName());
         ps.setString(8, clientName.getMiddleName());
         ps.executeUpdate();
         
         stmnt.close();
         ps.close();
         connect.close();
	
	}
	
	/**
	 * Get all of the clients in the database, selects all rows from the clients table.
	 * @return a list of all of the clients
	 * @throws SQLException - if any database operations fail
	 * 
	 SELECT name, street, city, state, postal_code,contact_last_name, contact_first_name, contact_middle_nameFROM clients;
	 * @throws ClassNotFoundException 
	 */
	public List<ClientAccount> getClients() throws SQLException, ClassNotFoundException{
		List<ClientAccount> listOfClientAccounts = new ArrayList<>();
		Class.forName( driverClassName );
		connect = DriverManager.getConnection( dbUrl, username, password );
		stmnt = connect.createStatement();
		
		rs = stmnt.executeQuery("SELECT name, street, city, state, postal_code, contact_last_name, contact_first_name, contact_middle_name FROM clients;");
		while(rs.next()) {
			String clientName = rs.getString("name");
			String street = rs.getString("street");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String postal_code = rs.getString("postal_code");
			String contactLast = rs.getString("contact_last_name");
			String contactFirst = rs.getString("contact_first_name");
			String contactMiddle = rs.getString("contact_middle_name");
			listOfClientAccounts.add(new ClientAccount(clientName,
					new PersonalName(contactLast,contactFirst,contactMiddle),
					new Address(street,city,StateCode.valueOf(state),postal_code)));
		}
		
        rs.close();
        stmnt.close();
        connect.close();
		return listOfClientAccounts;
	}
	
	/**
	 * Add a consultant to the database, inserts one row in the consultants table.
	 * @param consultant - the consultant to add
	 * @throws SQLException - if any database operations fail
	 * @throws ClassNotFoundException 
	 */
	public void addConsultant(Consultant consultant) throws SQLException, ClassNotFoundException{
		Class.forName( driverClassName );
		connect = DriverManager.getConnection( dbUrl, username, password );
		stmnt = connect.createStatement();
		
		ps = connect.prepareStatement("INSERT INTO consultants (last_name, first_name, middle_name)VALUES (?, ?, ?);\n",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,consultant.getName().getLastName());
        ps.setString(2,consultant.getName().getFirstName());
        ps.setString(3,consultant.getName().getMiddleName());
        ps.executeUpdate();
        
        stmnt.close();
        ps.close();
        connect.close();
	}

	/**
	 * Get all of the consultant in the database, selects all rows from the consultants table.
	 * @return a list of all of the consultants
	 * @throws SQLException - if any database operations fail
	 * @throws ClassNotFoundException 
	 */
	public List<Consultant> getConsultants() throws SQLException, ClassNotFoundException {
		List<Consultant> listOfConsultants = new ArrayList<>();
		Class.forName( driverClassName );
		connect = DriverManager.getConnection( dbUrl, username, password );
		stmnt = connect.createStatement();
		
		rs = stmnt.executeQuery("SELECT last_name, first_name, middle_name FROM consultants;");
		while(rs.next()) {
			String last = rs.getString("last_name");
			String first = rs.getString("first_name");
			String middle = rs.getString("middle_name");
			listOfConsultants.add(new Consultant(new PersonalName(last,first,middle)));
		}
		
        rs.close();
        stmnt.close();
        connect.close();
        
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
	 * @throws ClassNotFoundException 
	 */
	public void addTimeCard(TimeCard timeCard) throws SQLException, ClassNotFoundException {
		
		int consultantId;
		Class.forName( driverClassName );
		connect = DriverManager.getConnection( dbUrl, username, password );
		stmnt = connect.createStatement();
		
        rs = stmnt.executeQuery(
                "SELECT id FROM consultants WHERE last_name = '"
        		+ timeCard.getConsultant().getName().getLastName() +
        		"'AND first_name = '"
        		+ timeCard.getConsultant().getName().getFirstName() +
        		"'AND middle_name = '"
        		+ timeCard.getConsultant().getName().getMiddleName() + 
        		"';");
		
        if(rs.next()) {
        		consultantId = rs.getInt(1);
        		ps = connect.prepareStatement("INSERT INTO timecards (consultant_id, start_date) VALUES(?,?);\n",Statement.RETURN_GENERATED_KEYS);
        		ps.setInt(1, consultantId);
        		ps.setString(2,timeCard.getWeekStartingDay().toString());
        		
        		rs = ps.getGeneratedKeys();
        		rs.next();  
            int timeCardId = rs.getInt(1);
            
            List<ConsultantTime> timeCardHours = timeCard.getConsultingHours();
            
            for(ConsultantTime ct : timeCardHours) {
            		if(ct.isBillable()) {
            			ps = connect.prepareStatement("INSERT INTO billable_hours (client_id, timecard_id, date, skill, hours) VALUES (?,?,?,?,?);\n",Statement.RETURN_GENERATED_KEYS);
            			ps.setInt(1, consultantId);
            			ps.setInt(2, timeCardId);
            			ps.setString(3, timeCard.getWeekStartingDay().toString());
            			ps.setString(4, ct.getSkill().toString());
            			ps.setInt(5, ct.getHours());
            		}
            		else {
            			ps = connect.prepareStatement("INSERT INTO non_billable_hours (account_name, timecard_id, date, hours) VALUES (?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            			ps.setString(1, ct.getAccount().getName());
            			ps.setInt(2, timeCardId);
            			ps.setString(3, timeCard.getWeekStartingDay().toString());
            			ps.setInt(4, ct.getHours());
            		}
            }
        }
        rs.close();
        stmnt.close();
        ps.close();
        connect.close();
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

		return null;
	}

	/*
	 
	 Select invoice item
	 SELECT b.date, c.last_name, c.first_name, c.middle_name, b.skill, s.rate, b.hours FROM billable_hours b, consultants c, skills s, timecards t WHERE b.client_id = (SELECT DISTINCT id FROM clients WHERE name = ?) AND b.skill = s.name AND b.timecard_id = t.id AND c.id = t.consultant_id AND b.date >= ? AND b.date <= ?;
	 
	 Select all clients
	 SELECT name, street, city, state, postal_code,contact_last_name, contact_first_name, contact_middle_nameFROM clients;
	 
	 Select all consultants
	 SELECT last_name, first_name, middle_name
	 FROM consultants;
	 */

}
