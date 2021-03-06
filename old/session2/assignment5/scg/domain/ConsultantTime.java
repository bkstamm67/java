package com.scg.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A consultants time, maintains date, skill, account and hours data.
 * @author Brian Stamm
 *
 */
public class ConsultantTime implements Serializable{

	private static final long serialVersionUID = 5589703475056871137L;
	private LocalDate date;
	private Account account;
	private Skill skillType;
	private int hours;
	
	/**
	 * Creates a new instance of ConsultantTime.
	 * @param date - The date this instance occurred.
	 * @param account - The account to charge the hours to; either a Client or NonBillableAccount.
	 * @param skillType - The skill type.
	 * @param hours - The number of hours, which must be positive.
	 * @throws IllegalArgumentException - if the hours are <= 0.
	 */
	public ConsultantTime(LocalDate date, Account account, Skill skillType, int hours) {			
		setHours(hours);
		this.date = date;
		this.account = account;
		this.skillType = skillType;

	}
	
	/**
	 * Getter for property date.
	 * @return Value of property date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Setter for property date.
	 * @param date - New value of property date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Getter for property account.
	 * @return Value of property account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Setter for property account.
	 * @param account - New value of property account.
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * Determines if the time is billable
	 * @return true if the time is billable otherwise false.
	 */
	public boolean isBillable() {
		return this.account.isBillable();
	}
	
	/**
	 * Getter for property hours.
	 * @return Value of property hours.
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Setter for property hours.
	 * @param hours - New value of property hours must be > 0.
	 * @throws IllegalArgumentException - if the hours are <= 0.
	 */
	public void setHours(int hours) throws IllegalArgumentException {
		if(hours <= 0) {
			throw new IllegalArgumentException("Hours must be a positive integer.");
		}
		else {
			this.hours = hours;
		}
	}
	
	/**
	 * Getter for property skill.
	 * @return Value of property skill.
	 */
	public Skill getSkill() {
		return skillType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + hours;
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultantTime other = (ConsultantTime) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hours != other.hours)
			return false;
		if (skillType != other.skillType)
			return false;
		return true;
	}

	/**
	 * Creates a string representation of the consultant time.
	 * @return this ConsultantTime as a formatted string.
	 */
	@Override
	public String toString() {
        return String.format("%-28s %2$tm/%2$td/%2$tY  %3$5d  %4$s%n",
                account.getName(), date, hours, skillType);
	}
	
}
