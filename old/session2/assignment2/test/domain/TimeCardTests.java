package com.scg.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.scg.util.PersonalName;

/**
 * Unit tests for TimeCard class
 * @author Brian Stamm
 */
public class TimeCardTests {

	//Variables for TimeCard
	private Consultant consultant;
	private LocalDate weekStartingDay;
	private List<ConsultantTime> consultingHours;
	
	//Used to create Consultant
	private PersonalName testConsultantName; 
	
	//Used to create ConsultantTime
	private ClientAccount testAccount;
	private ConsultantTime testConsultantTimeBillable;
	private ConsultantTime testConsultantTimeNonBillable;
	private PersonalName testClientAccountName;
	private int billableHours;
	private int nonBillableHours;
	
	/**
	* Initialize all the variables for testing
	*/
	@Before
	public void initialize() {
		testConsultantName = new PersonalName("Rothfuss", "Patrick");
		consultant = new Consultant(testConsultantName);
		weekStartingDay = LocalDate.now();
		consultingHours = new ArrayList<>();
		testClientAccountName = new PersonalName("KingKiller", "Kvothe");
		testAccount = new ClientAccount("Name of the Wind", testClientAccountName);
		billableHours = 15;
		nonBillableHours = 23;
		testConsultantTimeBillable = new ConsultantTime(weekStartingDay,testAccount,Skill.SOFTWARE_ENGINEER,billableHours);
		testConsultantTimeNonBillable = new ConsultantTime(weekStartingDay,NonBillableAccount.VACATION,Skill.PROJECT_MANAGER,nonBillableHours);
	}
	
	/**
	* Tests the constructor
	*/
	@Test
	public void testConstructor() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		assertEquals(test.getConsultant(),consultant);
		assertEquals(test.getWeekStartingDay(),weekStartingDay);
	}
	
	/**
	* Tests addConsultantTime() method, checking by looking at the hours and 
	* checking the list of <ConsultantTime> are present
	*/
	@Test
	public void testAddConsultantTime() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		test.addConsultantTime(testConsultantTimeBillable);
		test.addConsultantTime(testConsultantTimeNonBillable);
		
		assertEquals(test.getTotalNonBillableHours(),nonBillableHours);
		assertEquals(test.getTotalBillableHours(),billableHours);
		
		List<ConsultantTime> testList = test.getConsultingHours();
		assertTrue(testList.contains(testConsultantTimeBillable));
		assertTrue(testList.contains(testConsultantTimeNonBillable));
	}
	
	/**
	* Tests getConsultingHours() method, first when first initialized does
	* not have any values, and then that the list has all that are added.
	*/
	@Test
	public void testGetConsultingHours() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		List<ConsultantTime> testList = test.getConsultingHours();
		assertEquals(testList,consultingHours);
		
		test.addConsultantTime(testConsultantTimeBillable);
		test.addConsultantTime(testConsultantTimeNonBillable);
		consultingHours.add(testConsultantTimeBillable);
		consultingHours.add(testConsultantTimeNonBillable);
		List<ConsultantTime> testListTwo = test.getConsultingHours();
		assertEquals(testListTwo,consultingHours);
	}
	
	/**
	* Tests getWeekStartingDay() method
	*/
	@Test
	public void testGetWeekStartingDay() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		assertEquals(test.getWeekStartingDay(),weekStartingDay);
	}
	
	/**
	* Tests getBillableHoursForClients is empty when searching for something not present
	*/
	@Test
	public void testGetBillableHoursForClient_NoClient() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		List<ConsultantTime> testList = test.getBillableHoursForClient("Name of the Wind");
		assertTrue(testList.isEmpty());
	}
	
	/**
	* Tests getBillableHoursForClients returns something when present
	*/
	@Test
	public void testGetBillableHoursForClient_ClientPresent() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		test.addConsultantTime(testConsultantTimeBillable);
		List<ConsultantTime> testList = test.getBillableHoursForClient("Name of the Wind");
		assertTrue(!testList.isEmpty());
	}
	
	/**
	* Tests the various getHours methods - getTotalBillableHours(), getTotalNonBillableHours(),
	* and getTotalHours()
	*/
	@Test
	public void testGetHours() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		test.addConsultantTime(testConsultantTimeBillable);
		test.addConsultantTime(testConsultantTimeNonBillable);
		
		assertEquals(test.getTotalBillableHours(),billableHours);
		assertEquals(test.getTotalNonBillableHours(),nonBillableHours);
		assertEquals(test.getTotalHours(),billableHours+nonBillableHours);
	}
	
	/**
	* Tests toString() method
	*/
	@Test
	public void testToString() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("Consultant:  %s     Week Starting: %2$tb %2$td, %2$tY\n",consultant.toString(),weekStartingDay);
		ft.close();
		
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		assertEquals(test.toString(),sb.toString());
	}
	
	/**
	* Tests toReportString(), uses buildReport() method to build mock report
	*/
	@Test
	public void testToReportString() {
		TimeCard test = new TimeCard(consultant,weekStartingDay);
		String result = buildReport();
		assertEquals(test.toReportString(),result);
	}

	/**
	* A private method used to create a string that mocks what a report should look like
	*/
	private String buildReport() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("====================================================================\n");
		ft.format("Consultant:  %s     Week Starting: %2$tb %2$td, %2$tY\n",consultant.toString(),weekStartingDay);
		ft.format("Billable Time:  \n");
		ft.format("Account                      Date        Hours  Skill\n");
		ft.format("---------------------------  ----------  -----  --------------------\n");
		ft.format("\n");
		ft.format("Non-billable Time:  \n");
		ft.format("Account                      Date        Hours  Skill\n");
		ft.format("---------------------------  ----------  -----  --------------------\n");
		ft.format("\n");
		ft.format("Summary:\n");
		ft.format("Total Billable:  %d\n", 0);
		ft.format("Total Non-Billable:  %d\n", 0);
		ft.format("Total Hours:  %d\n", 0);
		ft.format("====================================================================\n");
		ft.close();
		return sb.toString();
	}

}
