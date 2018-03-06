package com.scg.beans;

import java.util.EventObject;

import com.scg.domain.Consultant;
import com.scg.util.PersonalName;

/**
 * Event used to notify listeners of a Consultant's termination.
 * @author Brian Stamm
 */
public class TerminationEvent extends EventObject{
	
	private consultant;
	boolean voluntary;

	/**
	 * Constructor
	 * @param source - the event source
	 * @param consultant - the consultant being terminated
	 * @param voluntary - was the termination voluntary
	 */
	public TerminationEvent(Object source, Consultant consultant, boolean voluntary){
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the voluntary termination status.
	 * @return true if a voluntary termination
	 */
	public boolean isVoluntary() {
		return true;
	}
	
	/**
	 * Gets the consultant that was terminated.
	 * @return the consultant that was terminated
	 */
	public Consultant getConsultant() {
		return new Consultant(new PersonalName("Stamm", "Brian"));
	}

}
