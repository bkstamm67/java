package com.scg.net.cmd;

import java.time.LocalDate;

import com.scg.domain.ClientAccount;
import com.scg.domain.Invoice;

/**
 * @author Brian Stamm
 *
 */
public class CreateInvoicesCommand extends AbstractCommand<LocalDate>{

	private static final long serialVersionUID = 771199975086868151L;
	
	/**
	 * Construct a CreateInvoicesCommand with a target month, which should be 
	 * obtained by getting the desired month constant from LocalDate.
	 * 
	 * @param target - the target month.
	 */
	public CreateInvoicesCommand(LocalDate target) {
		super(target);
	}
	
	/**
	 * Execute this Command by calling receiver.execute(this).
	 */
	public void execute() {
		getReceiver().execute(this);
	}
	

}
