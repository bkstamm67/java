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
		vcs.fireVetoableChange("payrate", this.payRate, newRate);
		double oldRate = payRate;
		this.payRate = newRate;
		pcs.firePropertyChange("payRate", oldRate, payRate);  
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
		pcs.addPropertyChangeListener("payRate",pcl);
	}
	
	/**
	 * Removes a payRate property change listener.
	 * @param pcl  - the listener
	 */
	public synchronized void removePayRateListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener("payRate",pcl);
	}
	
	/**
	 * Adds a vetoable change listener, only applicable to payRate changes.
	 * @param pcl  - the listener
	 */
	public synchronized void addVetoableChangeListener(VetoableChangeListener v) {
		vcs.addVetoableChangeListener("payRate",v);
	}

	/**
	 * Removes a vetoable change listener, only applicable to payRate changes.
	 * @param pcl  - the listener
	 */
	public synchronized void removeVetoableChangeListener(VetoableChangeListener pcl) {
		vcs.removeVetoableChangeListener("payRate", pcl);
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
		pcs.firePropertyChange("sickLeave", oldHours, sickLeaveHours); 
		
	}
	
	/**
	 * Adds a sickLeaveHours property change listener.
	 * @param pcl  - the listener
	 */
	public synchronized void addSickLeaveHoursListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener("sickLeave",pcl);
	}
	
	/**
	 * Removes a sickLeaveHours property change listener.
	 * @param pcl  - the listener
	 */
	public synchronized void removeSickLeaveHoursListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener("sickLeave",pcl);
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
		pcs.firePropertyChange("vacationHours", oldHours, this.vacationHours); 
	}

	/**
	 * Adds a vacationHours property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void addVacationHoursListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener("vacationHours",pcl);
	}
	/**
	 * Removes a vacationHours property change listener.
	 * @param pcl - the listener
	 */
	public synchronized void removeVacationHoursListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener("vacationHours",pcl);
	}
}
