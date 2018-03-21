package com.scg.net.cmd;

/**
 * @author Brian Stamm
 *
 */
public final class ShutdownCommand extends AbstractCommand<Void> {

	private static final long serialVersionUID = -3595313732319325568L;
	
	/**
	 * Construct an ShutdownCommand.
	 */
	public ShutdownCommand() {
		super();
	}
	
	/**
	 * Execute this Command by calling receiver.execute(this).
	 */
	public void execute() {
		getReceiver().execute(this);
	}
	
	
}
