package com.scg.net.cmd;

/**
 * The command to disconnect, this command has no target, so target type is Void.
 * 
 * @author Brian Stamm
 *
 */
public final class DisconnectCommand extends AbstractCommand<Void>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2148533327944546162L;
	
	/**
	 * Construct an DisconnectCommand.
	 */
	public DisconnectCommand() {
		super();
	}
	
	/**
	 * Execute this Command by calling receiver.execute(this).
	 */
	public void execute() {
		getReceiver().execute(this);
	}

}
