package com.scg.util;

import java.util.Comparator;

import com.scg.domain.TimeCard;

/**
 * Compares two TimeCard objects ascending order by (in precedence order) consultant, time card starting 
 * date, totalHours, totalBillableHours and totalNonBillableHours.
 * @author Brian Stamm
 */
public class TimeCardConsultantComparator implements Comparator<TimeCard> {

	/**
	 * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as 
	 * the first argument is less than, equal to, or greater than the second.
	 * @param firstTimeCard - the first object to be compared.
	 * @param secondTimeCard - the second object to be compared.
	 * @return a negative integer, zero, or a positive integer as the first argument is less than, equal 
	 * to, or greater than the second.
	 */
	@Override
	public int compare(TimeCard firstTimeCard, TimeCard secondTimeCard){
		
		return Comparator.comparing(TimeCard::getConsultant)
				.thenComparing(TimeCard::getWeekStartingDay)
				.thenComparing(TimeCard::getTotalHours)
				.compare(firstTimeCard, secondTimeCard);
	}

}
