package com.scg.beans;

import java.util.EventObject;

import com.scg.domain.Consultant;

/**
 * Event used to notify listeners of a Consultant's termination.
 * @author Brian Stamm
 */
public class TerminationEvent extends EventObject{
	
	private static final long serialVersionUID = 5057775166410885952L;
	private Consultant consultant;
	private boolean voluntary;

	/**
	 * Constructor
	 * @param source - the event source
	 * @param consultant - the consultant being terminated
	 * @param voluntary - was the termination voluntary
	 */
	public TerminationEvent(Object source, Consultant consultant, boolean voluntary){
		super(source);
		this.consultant = consultant;
		this.voluntary = voluntary;
	}
	
	/**
	 * Gets the voluntary termination status.
	 * @return true if a voluntary termination
	 */
	public boolean isVoluntary() {
		return voluntary;
	}
	
	/**
	 * Gets the consultant that was terminated.
	 * @return the consultant that was terminated
	 */
	public Consultant getConsultant() {
		return consultant;
	}

}
