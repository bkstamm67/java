package com.scg.util;

import java.util.List;

import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
* Utility class for processing TimeCard lists.
* @author Brian Stamm
*/
public final class TimeCardListUtil{
	
	private static TimeCardConsultantComparator timeCardConsultantComparator = new TimeCardConsultantComparator();
	
	private TimeCardListUtil() {
	}

  /**
  * Get a list of TimeCards for the specified consultant.
  * @param timeCards - the list of time cards to extract the sub set from
  * @param consultant - the consultant whose TimeCards will be obtained.
  * @return a list of TimeCards for the specified consultant.
  */
  public static List<TimeCard>	getTimeCardsForConsultant(List<TimeCard> timeCards, Consultant consultant){
    List<TimeCard> returnList = new ArrayList<>();
    for(TimeCard currentTimeCard : timeCards){
      Consultant timeCardConsultant = currentTimeCard.getConsultant();
      if(timeCardConsultant.equals(consultant)){
        returnList.add(currentTimeCard);
      }
    }
    return returnList;
  }
  
  /**
  * Get a list of TimeCards that cover dates that fall within a date range. Each time may have time 
  * entries through out one week beginning with the time card start date.
  * @param timeCards - the list of time cards to extract the sub set from
  * @param dateRange - The DateRange within which the dates of the returned TimeCards must fall.
  * @return a list of TimeCards having dates fall within the date range.
  */
  public static List<TimeCard>	getTimeCardsForDateRange(List<TimeCard> timeCards, DateRange dateRange){
    List<TimeCard> returnList = new ArrayList<>();
    for(TimeCard currentTimeCard : timeCards){
      LocalDate timeCardDate = currentTimeCard.getWeekStartingDay();
      if(dateRange.isInRange(timeCardDate)){
        returnList.add(currentTimeCard);
      }
    }
    return returnList;
  }
  
  /**
  * Sorts this list into ascending order, by the start date.
  * @param timeCards - the list of time cards to sort
  */
  public static void sortByStartDate(List<TimeCard> timeCards){
	  Collections.sort(timeCards);
  }
  
  
  /**
  * Sorts this list into ascending order by consultant name.
  * @param timeCards - the list of time cards to sort
  */
  public static void sortByConsultantName(List<TimeCard> timeCards){
	  Collections.sort(timeCards,timeCardConsultantComparator);
  }

}
