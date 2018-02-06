package com.scg.domain;

import java.time.LocalDate;

/**
 * Encapsulates a single billable item to be included in an invoice.
 * @author Brian Stamm
 *
 */
public final class InvoiceLineItem {
	
	private final LocalDate date;
	private final Consultant consultant;
	private final Skill skill;
	private final int hours;
	private final int charge;
	
	/**
	 * Construct an InvoiceLineItem.
	 * @param date - The date of this line item.
	 * @param consultant - Consultant for this line item.
	 * @param skill- Skill for this line item.
	 * @param hours- Hours for this line item.
	 */
	public InvoiceLineItem(LocalDate date, Consultant consultant, Skill skill, int hours) {
		//check for hours greater than zero
		if(hours <= 0) {
			throw new IllegalArgumentException();
			//throw error illegalArgementException
		}
		this.date = date;
		this.consultant = consultant;
		this.skill = skill;
		this.hours = hours;	
		charge = skill.getRate() * hours;
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
		return charge;
	}
	/**
	 * Print the date, consultant, skill, hours and charge for this line item.
	 * @return Formatted string.
	 */
	@Override
	public String toString() {
		return "InvoiceLineItem";
		//
		//LINEFORMAT = "%11$"
	}
}
