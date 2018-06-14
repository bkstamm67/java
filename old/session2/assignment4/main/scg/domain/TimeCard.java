package com.scg.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Encapsulates a time card capable of storing a consultant's billable and non-billable hours for a week.
 * @author Brian Stamm
 */
public class TimeCard implements Comparable<TimeCard>{
	
	private Consultant consultant;
	private LocalDate weekStartingDay;
	private int totalBillableHours;
	private int totalNonBillableHours;
	private List<ConsultantTime> consultingHours;
	
	/**
	 * Creates a new instance of TimeCard
	 * @param consultant - The Consultant whose information this TimeCard records.
	 * @param weekStartingDay - The date of the first work day of the week this TimeCard records information for.
	 */
	public TimeCard(Consultant consultant, LocalDate weekStartingDay) {
		this.consultant = consultant;
		this.weekStartingDay = weekStartingDay;
		totalBillableHours = 0;
		totalNonBillableHours = 0;
		this.consultingHours = new ArrayList<>();
	}
	
	/**
	 * Getter for property consultant.
	 * @return Value of property consultant.
	 */
	public Consultant getConsultant() {
		return this.consultant;
	}
	
	/**
	 * Getter for property billableHours.
	 * change this to just return number
	 * @return Value of property billableHours.
	 */
	public int getTotalBillableHours() {
		return totalBillableHours;
	}
	
	/**
	 * Getter for property totalNonBillableHours.
	 * @return Value of property totalNonBillableHours.
	 */
	public int getTotalNonBillableHours() {
		return totalNonBillableHours;
	}
	
	/**
	 * Getter for property consultingHours.
	 * @return Value of property consultingHours.
	 */
	public List<ConsultantTime> getConsultingHours(){
		return Collections.unmodifiableList(this.consultingHours);
	}
	
	/**
	 * Add a ConsultantTime object to this TimeCard.
	 * @param consultantTime - The ConsultantTime to add.
	 */
	public void addConsultantTime(ConsultantTime consultantTime) {
		consultingHours.add(consultantTime);
		if(consultantTime.isBillable()) {
			totalBillableHours += consultantTime.getHours();
		}
		else {
			totalNonBillableHours += consultantTime.getHours();
		}
	}
	
	/**
	 * Getter for property totalHours.
	 * @return Value of property totalHours.
	 */
	public int getTotalHours() {
		int total = totalBillableHours + totalNonBillableHours;
		return total;
	}
	
	/**
	 * Getter for property weekStartingDay.
	 * @return Value of property weekStartingDay.
	 */
	public LocalDate getWeekStartingDay() {
		return this.weekStartingDay;
	}
	
	/**
	 * Returns the billable hours (if any) in this TimeCard for the specified Client.
	 * @param clientName - name of the client to extract hours for.
	 * @return list of billable hours for the client.
	 */
	public List<ConsultantTime> getBillableHoursForClient(String clientName){
		/*
		List<ConsultantTime> temp = new ArrayList<ConsultantTime>();
		for(ConsultantTime ct: consultingHours) {
			if(clientName.equals(ct.getAccount().getName()) && ct.getAccount().isBillable()){
				temp.add(ct);
			}
		}
		*/
		return consultingHours.stream().filter(ct->ct.getAccount().getName().startsWith(clientName))
				.filter(ct->ct.isBillable()).collect(Collectors.toList());
		
		
	}
	
	/**
	 * @return a string containing the consultant name and the time card week starting day
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("Consultant:  %s     Week Starting: %2$tb %2$td, %2$tY\n",consultant.toString(),weekStartingDay);
		ft.close();
		return sb.toString();
	}
	
	/**
	 * Create a string representation of this object, suitable for printing the entire time card.
	 * @return this TimeCard as a formatted String.
	 */
	public String toReportString() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("====================================================================\n");
		//ft.format("Consultant:  %s     Week Starting: %2$tb %2$td, %2$tY\n",consultant.toString(),weekStartingDay);
		ft.format("%s", this.toString());
		ft.format("Billable Time:  \n");
		ft.format("Account                      Date        Hours  Skill\n");
		ft.format("---------------------------  ----------  -----  --------------------\n");
		ft.format("%s", buildTime(true));
		ft.format("\n");
		ft.format("Non-billable Time:  \n");
		ft.format("Account                      Date        Hours  Skill\n");
		ft.format("---------------------------  ----------  -----  --------------------\n");
		ft.format("%s", buildTime(false));
		ft.format("\n");
		ft.format("Summary:\n");
		ft.format("Total Billable:  %d\n", this.getTotalBillableHours());
		ft.format("Total Non-Billable:  %d\n", this.getTotalNonBillableHours());
		ft.format("Total Hours:  %d\n", this.getTotalHours());
		ft.format("====================================================================\n");
		ft.close();
		return sb.toString();
	}
	
	/**
	* Private method used to build either the Nonbillable or Billable section of
	* the report
	* @param bill - value used to determine if string consists of ConsultantTime that 
	* is billable or not
	* @return String value of ConsultantTime list
	*/
	private String buildTime(boolean bill) {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		for(ConsultantTime ct: consultingHours) {
			if(Boolean.compare(ct.isBillable(),bill) == 0) {
				ft.format("%s", ct.toString());
			}
		}
		ft.close();
		return sb.toString();
	}

	/**
	 * Compares TimeCard, in ascending order by (in precedence order) consultant, totalHours, 
	 * totalBillableHours and totalNonBillableHours.
	 * @param other - the TimeCard to compare to
	 * @return a negative integer, zero, or a positive integer as this object is less than, 
	 * equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(TimeCard other) {
		/*
		int answer = 0;
		Consultant otherConsultant = other.getConsultant();
		answer = consultant.compareTo(otherConsultant);
		if(answer == 0) {
			int thisTotalHours = this.getTotalHours();
			if(other.getTotalHours() == thisTotalHours) {
				int otherNonBillable = other.getTotalNonBillableHours();
				if(totalNonBillableHours > otherNonBillable) {
					answer = 1;
				}
				else if(totalNonBillableHours < otherNonBillable) {
					answer = -1;
				}
			}
			else if(other.getTotalHours() < thisTotalHours) {
				answer = 1;
			}
			else if(other.getTotalHours() > thisTotalHours) {
				answer = -1;
			}
		}
		
		return answer;
		*/
		return Comparator.comparing(TimeCard::getWeekStartingDay)
				.thenComparing(TimeCard::getConsultant)
				.thenComparing(TimeCard::getTotalHours)
				.thenComparing(TimeCard::getTotalBillableHours)
				.thenComparing(TimeCard::getTotalNonBillableHours)
				.compare(this,other);
	}

}
