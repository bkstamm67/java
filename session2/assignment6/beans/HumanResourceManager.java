package com.scg.beans;

import java.beans.PropertyVetoException;
import java.time.LocalDate;

import javax.swing.event.EventListenerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.Consultant;

/**
 * Responsible for modifying the pay rate, sick leave and vacation hours of staff 
 * consultants. Provide methods for registration of BenefitListeners, and 
 * TerminationListeners.
 * @author Brian Stamm
 */
public final class HumanResourceManager extends Object{
	
	private static final Logger log = LoggerFactory.getLogger(HumanResourceManager.class);
	private EventListenerList listenerList = new EventListenerList();;
	
	/**
	 * Constructor.
	 */
	public HumanResourceManager() {
		
	}
	
	/**
	 * Sets the pay rate for a staff consultant and logs whether the pay rate 
	 * change was approved or rejected (vetoed).
	 * @param c  - the consultant
	 * @param newPayRate - the new pay rate for the consultant
	 */
	public void adjustPayRate(StaffConsultant c,int newPayRate) {
		try {
			c.setPayRate(newPayRate);
			if(log.isInfoEnabled()) {
				String msg = String.format("Percent change = %d - %d", newPayRate, c.getPayRate());
				log.info(msg);
			}
		}
		catch(final PropertyVetoException ex){ 
			log.info("Caught HRM PropertyVetoException error");
		}
	}
	
	/**
	 * Sets the sick leave hours for a staff consultant.
	 * @param c - the consultant
	 * @param newSickLeaveHours - the new sick leave hours for the consultant
	 */
	public void adjustSickLeaveHours(StaffConsultant c,int newSickLeaveHours) {
		c.setSickLeaveHours(newSickLeaveHours);
	}
	
	/**
	 * Sets the vacation hours for a staff consultant.
	 * @param c - the consultant
	 * @param newVacationHours - the new vacation hours for the consultant
	 */
	public void adjustVacationHours(StaffConsultant c, int newVacationHours) {
		c.setVacationHours(newVacationHours);
	}
	
	/**
	 * Accepts the resignation of a consultant and fires a voluntary termination 
	 * event for the consultant.
	 * @param c - the consultant
	 */
	public void acceptResignation(Consultant c) {
		fireTerminationEvent(new TerminationEvent(this,c,true));
	}
	
	/**
	 * Fires an involuntary termination event for the staff consultant. Terminates 
	 * the employment of a consultant and fires a forced termination event for the 
	 * consultant.
	 * @param c - the consultant
	 */
	public void terminate(Consultant c) {
		fireTerminationEvent(new TerminationEvent(this,c,false));
	}
	
	/**
	 * Adds a termination listener.
	 * @param tl - listener
	 */
	public void addTerminationListener(TerminationListener tl) {
		listenerList.add(TerminationListener.class,tl);
	}
	
	/**
	 * Removes a termination listener.
	 * @param tl - listener
	 */
	public void removeTerminationListener(TerminationListener tl) {
		listenerList.remove(TerminationListener.class,tl);
	}
	
	/**
	 * Enroll a consultant in medical, and fires a medical enrollment event.
	 * @param c - the consultant enrolling in medical
	 */
	public void enrollMedical(Consultant c) {
		fireBenefitEvent(BenefitEvent.enrollMedical(this, c, LocalDate.now()));
	}
	
	/**
	 * Cancel a consultant's enrollment in medical, and fires a medical cancellation event.
	 * @param c - the consultant canceling medical enrollment
	 */
	public void cancelMedical(Consultant c) {
		fireBenefitEvent(BenefitEvent.cancelMedical(this, c, LocalDate.now()));
	}
	
	/**
	 * Enroll a consultant in dental, and fires a dental enrollment event.
	 * @param c - the consultant
	 */
	public void enrollDental(Consultant c) {
		fireBenefitEvent(BenefitEvent.enrollDental(this, c, LocalDate.now()));
	}
	
	/**
	 * Cancel a consultant's enrollment in dental, and fires a dental cancellation event
	 * @param c - the consultant
	 */
	public void cancelDental(Consultant c) {
		fireBenefitEvent(BenefitEvent.cancelDental(this, c, LocalDate.now()));
	}
	
	/**
	 * Adds a benefit listener.
	 * @param bl - the listener to add
	 */
	public void addBenefitListener(BenefitListener bl) {
		listenerList.add(BenefitListener.class, bl);
	}
	
	/**
	 * Removes a benefit listener.
	 * @param bl - the listener to remove
	 */
	public void removeBenefitListener(BenefitListener bl) {
		listenerList.remove(BenefitListener.class, bl);
	}
	/*
	private void fireTerminationEvent(new TerminationEvent(this,c,true)){
		final TerminationListener[] listeners = listenerList.getListeners(TerminationLister.class);
	}
	*/
	
	private void fireTerminationEvent(final TerminationEvent evnt){
		//final TerminationListener[] listeners = listenerList.getListeners(TerminationLister.class);
		final TerminationListener[] listeners = listenerList.getListeners(TerminationListener.class);
		for(final TerminationListener listener : listeners ) {
			if(evnt.isVoluntary()) {
				listener.voluntaryTermination(evnt);
			}
			else {
				listener.forcedTermination(evnt);
			}
		}
	}
	
	private void fireBenefitEvent(final BenefitEvent evnt){
		final BenefitListener[] listeners = listenerList.getListeners(BenefitListener.class);
		if(evnt.medicalStatus().isPresent()) {
			boolean medicalStatus = evnt.medicalStatus().get();//evnt.medicalStatus.get();
			for(final BenefitListener listener: listeners) {
				if(medicalStatus) {
					//listener.medicalEnrollemnt(evnt);
					listener.medicalEnrollment(evnt);
				}else {
					//listnener.medicalCacellation(evnt);
					listener.medicalCancellation(evnt);
				}
			}
		}
		if(evnt.dentalStatus().isPresent()) {
			boolean dentalStatus = evnt.dentalStatus().get();
			for(final BenefitListener listener: listeners) {
				if(dentalStatus) {
					listener.dentalEnrollment(evnt);
				}else {
					listener.dentalCancellation(evnt);
				}
			}
		}
	}
}
