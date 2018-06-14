package cp120.assignments.assignment004;

import javax.swing.JOptionPane;

/**
 * @author bkstamm67
 * This class runs an simple user interface asking for a number 
 * between two values passed in and returns the user's number.
 * There is some error handling in case of invalid input.
 */
public class Utils {
	
	/**
	 * @param min smallest number passed in, not checked
	 * @param max largest number passed in, not checked
	 * @return result is the number user inputs 
	 * @throws OpCanceledException per instructions during lecture
	 */
	public static int askInt(int min, int max) throws OpCanceledException
	{
		//initializes variables
		String answer = null;
		int result = -1;
		Boolean cont = true;
		
		//loop until user enters valid number
		while (cont) {
			try 
			{
				StringBuilder startPrompt = new StringBuilder();
				startPrompt.append("Enter an integer between ")
					.append(min)
					.append(" and ")
					.append(max)
					.append(".");
				answer = JOptionPane.showInputDialog(null, startPrompt.toString());
				
				if(answer == null) {
					throw new OpCanceledException();
				}
				
				result = Integer.parseInt(answer);
				
				if((result >= min) && (result <= max)) {
					JOptionPane.showMessageDialog(null, "Thanks for playing!");
					cont = false;
				}
				else{
					StringBuilder invalidNum = new StringBuilder();
					invalidNum.append(answer)
						.append(" is not between ")
						.append(min)
						.append(" and ")
						.append(max)
						.append(".");
					JOptionPane.showMessageDialog(null, invalidNum.toString());
				}	
			}
			catch(NumberFormatException e) 
			{
				StringBuilder numFormatErrorMessage = new StringBuilder();
				numFormatErrorMessage.append("\"")
					.append(answer)
					.append("\"")
					.append(" is not valid.");
				JOptionPane.showMessageDialog(null, numFormatErrorMessage.toString());
			}
		}
		return result;
	}

}