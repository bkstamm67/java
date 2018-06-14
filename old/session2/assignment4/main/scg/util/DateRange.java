package com.scg.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
* Encapsulates a range of two dates, inclusive of the start date and end date.
* @author Brian Stamm
*/
public final class DateRange{

  private LocalDate startDate;
  private LocalDate endDate;
  
  
  /**
  * Construct a DateRange given two dates.
  * @params startDate - the start date for this DateRange.
  * @params endDate - the end date for this DateRange.
  */
  public DateRange(LocalDate startDate, LocalDate endDate){
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  /**
  * Construct a DateRange given two date strings in the correct format.
  * @params start - String representing the start date, of the form yyyy-MM-dd.
  * @params end - String representing the end date, of the form yyyy-MM-dd.
  */
  public DateRange(String start, String end){
    this.startDate = LocalDate.parse(start,DateTimeFormatter.ISO_LOCAL_DATE);
    this.endDate = LocalDate.parse(end,DateTimeFormatter.ISO_LOCAL_DATE);
  }
  
  /**
  * Construct a DateRange for the given month.
  * @params month - the month for which this DateRange should be constructed.
  * @params year - the calendar year
  */
  public DateRange(Month month,int year){
	  this.startDate = LocalDate.of(year, month, 1);
	  this.endDate = startDate.plusDays(startDate.lengthOfMonth()-1);
  }
  
  /**
  * Returns the start date for this DateRange.
  * @return the start date for this DateRange.
  */
  public LocalDate getStartDate(){
    return startDate;
  }

  /**
  * Returns the end date for this DateRange.
  * @return the end date for this DateRange.
  */
  public LocalDate getEndDate(){
    return endDate;
  }
  
  /**
  * Returns true if the specified date is within the range start date <= date <= end date.
  * @params date - the date to check for being within this DateRange.
  * @return true if the specified date is within this DateRange.
  */
  public boolean isInRange(LocalDate date){
    boolean answer = false;
    if(startDate.isBefore(date) || startDate.isEqual(date)){
      if(endDate.isAfter(date) || endDate.isEqual(date)){
        answer = true;
      }
    }
    return answer;
  }
  
}