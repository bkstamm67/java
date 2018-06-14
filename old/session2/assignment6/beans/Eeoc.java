package com.scg.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.util.PersonalName;

/**
 * The EEOC monitors SCG's terminations. Listens for TerminationEvents and maintains 
 * a count of each type of termination event, and makes these counts available. All 
 * TerminationEvents are logged.
 * @author Brian Stamm
 */
public class Eeoc extends Object implements TerminationListener{
	
	private int voluntary;
	private int forced;
	private static final Logger log = LoggerFactory.getLogger(Eeoc.class);
	
	/**
	 * Constructor.
	 */
	public Eeoc() {
		voluntary = 0;
		forced = 0;
	}
	
	/**
	 * Simply prints a message indicating that the consultant quit and adjusts the 
	 * voluntary termination count.
	 * @param evt - the termination event
	 */
	public void voluntaryTermination(TerminationEvent evt) {
		PersonalName name = evt.getConsultant().getName();
		if(log.isInfoEnabled()) {
			log.info(name + "voluntary left.");
		}
		voluntary++;
	}
	
	/**
	 * Simply prints a message indicating that the consultant was fired and adjusts 
	 * the forced termination count.
	 * @param evt - the termination event
	 */
	public void forcedTermination(TerminationEvent evt) {
		PersonalName name = evt.getConsultant().getName();
		if(log.isInfoEnabled()) {
			log.info(name + "FORCED out!");
		}
		forced++;
	}
	
	/**
	 * Gets the forced termination count.
	 * @return the forced termination count
	 */
	public int forcedTerminationCount() {
		return forced;
	}
	
	/**
	 * Gets the voluntary termination count.
	 * @return the voluntary termination count
	 */
	public int voluntaryTerminationCount() {
		return voluntary;
	}
	
}
