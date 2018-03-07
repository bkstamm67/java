package com.scg.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

import com.scg.domain.Consultant;
import com.scg.util.PersonalName;

/**
 * A consultant who is kept on staff (receives benefits). The StaffConsultant has bound properties 
 * for vacation hours and sick leave hours and a constrained property for pay rate (allows veto).
 * @author Brian Stamm
 *
 */
public final class StaffConsultant extends Consultant implements Serializable {
	
	public static final String PAY_RATE_PROPERTY_NAME = "payRate";
	public static final String SICK_LEAVE_HOURS_PROPERTY_NAME = "sickLeaveHours";
	public static final String VACATION_HOURS_PROPERTY_NAME = "vacationHours";
	
	private static final long serialVersionUID = -7841900527734028856L;
	private int payRate;
	private int sickLeaveHours;
	private int vacationHours;
	private final PropertyChangeSupport pcs;
	private final VetoableChangeSupport vcs;
	
	/**
	 * Creates a new instance of StaffConsultant
	 * @param name - the consultant's name
	 * @param rate - the pay rate in cents
	 * @param sickLeave - the sick leave hours
	 * @param vacation - the vacation hours
	 */
	public StaffConsultant(PersonalName name,int rate,int sickLeave,int vacation) {
		super(name);
		this.payRate = rate;
		this.sickLeaveHours = sickLeave;
		this.vacationHours = vacation;
		pcs = new PropertyChangeSupport(this);
		vcs = new VetoableChangeSupport(this);
	}
	
	/**
	 * Get the current pay rate.
	 * @return the pay rate in cents
	 */
	public int getPayRate() {
		return payRate;
	}


	/**
	 * Set the pay rate. Fires the VetoableChange event and if approved the PropertyChange event.
	 * @param payRate - the pay rate in cents
	 * @throws PropertyVetoException - if a veto occurs
	 */
	public synchronized void setPayRate(int newRate) throws PropertyVetoException {
		//vcs.fireVetoableChange(PAY_RATE_PROPERTY_NAME, this.payRate, newRate);
		int oldRate = payRate;
		this.payRate = newRate;
		pcs.firePropertyChange(PAY_RATE_PROPERTY_NAME, oldRate, payRate);  
	}
	
	/**
	 * Adds a general property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener pcl) {
	    pcs.addPropertyChangeListener(pcl);
	    }
	
	/**
	 * Remove a general property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
		}
	
	/**
	 * Adds a payRate property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void addPayRateListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(PAY_RATE_PROPERTY_NAME,pcl);
	}
	
	/**
	 * Removes a payRate property change listener.
	 * @param pcl  - the listener
	 */
	public synchronized void removePayRateListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(PAY_RATE_PROPERTY_NAME,pcl);
	}
	
	/**
	 * Adds a vetoable change listener, only applicable to payRate changes.
	 * @param pcl  - the listener
	 */
	public synchronized void addVetoableChangeListener(VetoableChangeListener v) {
		vcs.addVetoableChangeListener(PAY_RATE_PROPERTY_NAME,v);
	}

	/**
	 * Removes a vetoable change listener, only applicable to payRate changes.
	 * @param pcl  - the listener
	 */
	public synchronized void removeVetoableChangeListener(VetoableChangeListener pcl) {
		vcs.removeVetoableChangeListener(PAY_RATE_PROPERTY_NAME, pcl);
	}
	
	/**
	 * Get the available sick leave.
	 * @return the sickLeaveHours
	 */
	public int getSickLeaveHours() {
		return sickLeaveHours;
	}


	/**
	 * Set the sick leave hours. Fires the ProperrtyChange event.
	 * @param sickLeaveHours the sickLeaveHours to set
	 */
	public synchronized void setSickLeaveHours(int sickLeaveHours) {
		int oldHours = this.sickLeaveHours;
		this.sickLeaveHours = sickLeaveHours;
		pcs.firePropertyChange(SICK_LEAVE_HOURS_PROPERTY_NAME, oldHours, sickLeaveHours); 
		
	}
	
	/**
	 * Adds a sickLeaveHours property change listener.
	 * @param pcl  - the listener
	 */
	public synchronized void addSickLeaveHoursListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME,pcl);
	}
	
	/**
	 * Removes a sickLeaveHours property change listener.
	 * @param pcl  - the listener
	 */
	public synchronized void removeSickLeaveHoursListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME,pcl);
	}

	/**
	 * @return the vacationHours
	 */
	public int getVacationHours() {
		return vacationHours;
	}


	/**
	 * @param vacationHours the vacationHours to set
	 */
	public synchronized void setVacationHours(int vacationHours) {
		int oldHours = this.vacationHours;
		this.vacationHours = vacationHours;
		pcs.firePropertyChange(VACATION_HOURS_PROPERTY_NAME, oldHours, this.vacationHours); 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + payRate;
		result = prime * result + ((pcs == null) ? 0 : pcs.hashCode());
		result = prime * result + sickLeaveHours;
		result = prime * result + vacationHours;
		result = prime * result + ((vcs == null) ? 0 : vcs.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffConsultant other = (StaffConsultant) obj;
		if (payRate != other.payRate)
			return false;
		if (pcs == null) {
			if (other.pcs != null)
				return false;
		} else if (!pcs.equals(other.pcs))
			return false;
		if (sickLeaveHours != other.sickLeaveHours)
			return false;
		if (vacationHours != other.vacationHours)
			return false;
		if (vcs == null) {
			if (other.vcs != null)
				return false;
		} else if (!vcs.equals(other.vcs))
			return false;
		return true;
	}

	/**
	 * Adds a vacationHours property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void addVacationHoursListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(VACATION_HOURS_PROPERTY_NAME,pcl);
	}
	/**
	 * Removes a vacationHours property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void removeVacationHoursListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(VACATION_HOURS_PROPERTY_NAME,pcl);
	}
}
