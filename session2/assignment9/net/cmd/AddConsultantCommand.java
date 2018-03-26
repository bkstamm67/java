package com.scg.net.cmd;

import com.scg.domain.Consultant;

/**
 * @author Brian Stamm
 *
 */
public final class AddConsultantCommand extends AbstractCommand<Consultant>{


	private static final long serialVersionUID = 4171596416963385918L;

	/**
	 * Construct an AddConsultantCommand with a target.
	 * 
	 * @param target - the target of this command
	 */
	public AddConsultantCommand(Consultant target) {
		super(target);
	}
	
	/**
	 * Execute this Command by calling receiver.execute(this).
	 */
	@Override
	public void execute() {
		getReceiver().execute(this);
	}


}
