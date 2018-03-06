package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 * Approves or rejects compensation changes. Listens for PropertyChangeEvents on the 
 * payRate property, any pay rate increase in excess of will be vetoed. The rejection 
 * (veto) or acceptance of each pay rate change will be logged as will any successful 
 * pay rate change.
 * @author Brian Stamm
 */
public class CompensationManager extends Object implements PropertyChangeListener, VetoableChangeListener{

	int max = 105;
	int to = 100;
	
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
		// TODO Auto-generated method stub
		if(StaffConsultant.PAY_RATE_PROPERTY_NAME.equals(evt.getPropertyName())) {
			int old = (Integer)evt.getOldValue();
			//do same for new
			
			if(newValue * to > oldValue) {
				if(log.isInfoEnabled) {
					log.
				}
			}throw new PropertyVetoException("Raised denied")
		}
		
	}

	/**
	 * Processes to final pay rate change.
	 * @param evt - a change event for the payRate property
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(StaffConsultant.PayRate)
	}

}
