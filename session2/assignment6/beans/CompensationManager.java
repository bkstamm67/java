package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Approves or rejects compensation changes. Listens for PropertyChangeEvents on the 
 * payRate property, any pay rate increase in excess of will be vetoed. The rejection 
 * (veto) or acceptance of each pay rate change will be logged as will any successful 
 * pay rate change.
 * @author Brian Stamm
 */
public class CompensationManager extends Object implements PropertyChangeListener, VetoableChangeListener{

	private int maxIncrease = 105;
	private int standard = 100;
	private static final Logger log = LoggerFactory.getLogger(CompensationManager.class);
	
	/**
	 * Constructor.
	 */
	public CompensationManager() {
		
	}
	
	/**
	 * Rejects any raise over 5%.
	 * @param evt - a vetoable change event for the payRate property
	 * @throws PropertyVetoException - if the change is vetoed
	 */
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		if(StaffConsultant.PAY_RATE_PROPERTY_NAME.equals(evt.getPropertyName())) {
			int oldPay = (Integer)evt.getOldValue();
			int newPay = (Integer)evt.getNewValue();
			
			if((newPay*standard) > (oldPay * maxIncrease)) {
				if(log.isInfoEnabled()) {
					log.info("Raise is too big this time!");
				}
				throw new PropertyVetoException("Raised denied",evt);
			}
		}
	}

	/**
	 * Processes to final pay rate change.
	 * @param evt - a change event for the payRate property
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(StaffConsultant.PAY_RATE_PROPERTY_NAME.equals(evt.getPropertyName())) {
			int oldPay = (Integer)evt.getOldValue();
			int newPay = (Integer)evt.getNewValue();
			
			if((newPay * standard) < (oldPay * maxIncrease)) {
				if(log.isInfoEnabled()) {
					log.info("You got a raise!");
				}
			}
		}
	}

}
