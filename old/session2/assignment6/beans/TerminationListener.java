package com.scg.beans;

import java.util.EventListener;

/**
 * Interface for accepting notification of consultant terminations.
 * @author Brian Stamm
 */
public interface TerminationListener extends EventListener{
	
	/**
	 * Invoked when a consultant is voluntarily terminated.
	 * @param evt - the termination event
	 */
	public void voluntaryTermination(TerminationEvent evt);
	
	/**
	 * Invoked when a consultant is involuntarily terminated.
	 * @param evt - the termination event
	 */
	public void forcedTermination(TerminationEvent evt);



}
