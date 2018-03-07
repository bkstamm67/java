package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Tracks changes in employee benifits. Listens for any PropertyChangeEvent and simply logs 
 * them. Additionally, Listens for any BenefitEvent and logs those as well. No other actions
 *  are taken in response to any event.
 * @author Brian Stamm
 *
 */
public final class BenefitManager extends Object implements PropertyChangeListener, BenefitListener{
	
	private static final Logger log = LoggerFactory.getLogger(BenefitManager.class);
	
	/**
	 * Constructor
	 */
	public BenefitManager() {
		
	}
	
	/**
	 * Logs the change.
	 * propertyChange in interface PropertyChangeListener
	 * @param evt - a property change event for the sickLeaveHours or vacationHours, or payRate property
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		final String popName = evt.getPropertyName();
		int oldVale = (Integer)evt.getOldValue();
		int newVale = (Integer)evt.getNewValue();
		/*if(log.isInforEnable.)
		
		System.out.printf("Tracker: Hours changed for %s from %d to %d%n",
		          evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());*/
		if(log.isInfoEnabled()) {
			System.out.printf("Tracker: Hours changed for %s from %d to %d%n",
					popName, oldVale, newVale);
		}
		else {
			System.out.printf("Tracker ELSE: Hours changed for %s from %d to %d%n",
					popName, oldVale, newVale);
		}
	}
	
	/**
	 * Description copied from interface: BenefitListener
	 * Invoked when a consultant is enrolls in medical.
	 * Specified by:
	 * medicalEnrollment in interface BenefitListener
	 * @param evnt - the benefit event
	 */
	public void medicalEnrollment(BenefitEvent evnt) {
		if(log.isInfoEnabled()) {
			log.info(""+ evnt.getConsultant().getName() +"+ MED enrolled");
		}
	}

	/**
	 * Description copied from interface: BenefitListener
	 * Invoked when a consultant is cancels medical.
	 * Specified by:
	 * medicalCancellation in interface BenefitListener
	 * @param evnt - the benefit event
	 */
	public void medicalCancellation(BenefitEvent evnt) {
		if(log.isInfoEnabled()) {
			log.info(""+ evnt.getConsultant().getName() +"+ MED cancelled");
		}
	}

	/**
	 * Description copied from interface: BenefitListener
	 * Invoked when a consultant is enrolls in dental.
	 * Specified by:
	 * dentalEnrollment in interface BenefitListener
	 * @param evnt - the benefit event
	 */
	public void dentalEnrollment(BenefitEvent evnt) {
		if(log.isInfoEnabled()) {
			log.info(""+ evnt.getConsultant().getName() +"+ DENTAL enrolled");
		}
	}

	/**
	 * Description copied from interface: BenefitListener
	 * Invoked when a consultant is cancels dental.
	 * Specified by:
	 * dentalCancellation in interface BenefitListener
	 * @param evnt - the benefit event
	 */
	public void dentalCancellation(BenefitEvent evnt) {
		if(log.isInfoEnabled()) {
			log.info(""+ evnt.getConsultant().getName() +"+ DENTAL cancelled");
		}
	}

}
