package com.scg.beans;

import java.util.EventListener;

/**
 * Interface for accepting notification of consultant changes in medical and dental enrollment.
 * @author Brian Stamm
 */
public interface BenefitListener extends EventListener{
	
	/**
	 * Invoked when a consultant is enrolls in medical.
	 * @param event - the benefit event
	 */
	public void medicalEnrollment(BenefitEvent event);
	
	/**
	 * Invoked when a consultant is cancels medical.
	 * @param event - the benefit event
	 */
	public void medicalCancellation(BenefitEvent event);
	
	/**
	 * Invoked when a consultant is enrolls in dental.
	 * @param event - the benefit event
	 */
	public void dentalEnrollment(BenefitEvent event);
	
	/**
	 * Invoked when a consultant is cancels dental.
	 * @param event - the benefit event
	 */
	public void dentalCancellation(BenefitEvent event);


}
