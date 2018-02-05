package com.scg.domain;

import java.time.LocalDate;

/**
 * Encapsulates a single billable item to be included in an invoice.
 * @author Brian Stamm
 *
 */
public final class InvoiceLineItem {
	
	private LocalDate date;
	private Consultant consultant;
	private Skill skill;
	private int hours;
	
	/**
	 * Construct an InvoiceLineItem.
	 * @param date - The date of this line item.
	 * @param consultant - Consultant for this line item.
	 * @param skill- Skill for this line item.
	 * @param hours- Hours for this line item.
	 */
	public InvoiceLineItem(java.time.LocalDate date, Consultant consultant, Skill skill, int hours) {
		this.date = date;
		this.consultant = consultant;
		this.skill = skill;
		this.hours = hours;	
	}
	
	/**
	 * Get the date for this line item.
	 * @return The date.
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Get the consultant for this line item.
	 * @return The consultant.
	 */
	public Consultant getConsultant() {
		return this.consultant;
	}
	
	/**
	 * Get the skill for this line item.
	 * @return The skill.
	 */
	public Skill getSkill() {
		return skill;
	}
	
	/**
	 * Get the hours for this line item.
	 * @return The hours.
	 */
	public int getHours() {
		return hours;
	}
	
	/**
	 * Get the charge for this line item.
	 * @return The charge.
	 */
	public int getCharge() {
		return 1;
	}
	/**
	 * Print the date, consultant, skill, hours and charge for this line item.
	 * @return Formatted string.
	 */
	@Override
	public String toString() {
		return "InvoiceLineItem";
	}
}
