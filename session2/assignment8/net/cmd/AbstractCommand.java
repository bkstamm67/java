package com.scg.net.cmd;

import com.scg.net.server.CommandProcessor;

/**
 * The superclass of all Command objects, implements the command role in the Command design pattern.
 * 
 * @author Brian Stamm
 *
 * @param <T> - the target type, the type the command operates on
 */
public class AbstractCommand<T> implements Command<T>{

	private static final long serialVersionUID = -7637863811830949921L;

	/**
	 * Construct an AbstractCommand without a target; called from subclasses.
	 */
	public AbstractCommand(){
		
	}
	
	/**
	 * Construct an AbstractCommand with a target; called from subclasses.
	 * @param target - the target
	 */
	public AbstractCommand(T target) {
		
	}
	
	/**
	 * {@inheritDoc}
	 * @return the receiver for this Command.
	 */
	@Override
	public CommandProcessor getReceiver() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc} 
	 * @return receiver - the receiver for this Command.
	 */
	@Override
	public void setReceiver(CommandProcessor receiver) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractCommand []";
	}
	
	

}
