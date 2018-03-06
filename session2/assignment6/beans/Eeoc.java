package com.scg.beans;

import org.slf4j.Logger;

/**
 * The EEOC monitors SCG's terminations. Listens for TerminationEvents and maintains 
 * a count of each type of termination event, and makes these counts available. All 
 * TerminationEvents are logged.
 * @author Brian Stamm
 *
 */
public class Eeoc extends Object implements TerminationListener{
	
	private int v;
	private int n;
	private Logger log;
	
	/**
	 * Constructor.
	 */
	public Eeoc() {
		
	}
	
	/**
	 * Simply prints a message indicating that the consultant quit and adjusts the 
	 * voluntary termination count.
	 * @param evt - the termination event
	 */
	public void voluntaryTermination(TerminationEvent evt) {
		PersonalName name = evt.getConsultant().getName();
		if(log.isInfoEnabled()) {
			log.info(name + )
		}
	}
	
	/**
	 * Simply prints a message indicating that the consultant was fired and adjusts 
	 * the forced termination count.
	 * @param evt - the termination event
	 */
	public void forcedTermination(TerminationEvent evt) {
		
	}
	
	/**
	 * Gets the forced termination count.
	 * @return the forced termination count
	 */
	public int forcedTerminationCount() {
		return 1;
	}
	
	/**
	 * Gets the voluntary termination count.
	 * @return the voluntary termination count
	 */
	public int voluntaryTerminationCount() {
		return 1;
	}
	
}
