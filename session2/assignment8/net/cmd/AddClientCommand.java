package com.scg.net.cmd;

import com.scg.domain.ClientAccount;

/**
 * The command to add a ClientAccount to a list maintained by the server, target type is ClientAccount.
 * 
 * @author Brian Stamm
 *
 */
public class AddClientCommand extends AbstractCommand<ClientAccount>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3241027397614416646L;
	
	/**
	 * Construct an AddClientCommand with a target.
	 * 
	 * @param target - The target of this Command.
	 */
	public AddClientCommand(ClientAccount target) {
		super(target);
	}
	
	/**
	 * Execute this Command by calling receiver.execute(this).
	 */
	public void execute() {
		getReceiver().execute(this);
	}
	
}
