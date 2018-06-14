package cp120.assignments.assignment005;

/**
 * @author bkstamm67
 * This class runs an simple interface either encrypting or
 * decrypting a string.  There are two public facing methods
 * and 6 private helper methods.
 */
public class Crypto {
	
	/*
	 * @param str is a String that is needs the '\u0000' char
	 * appended to it.  The final string needs to be divisible by
	 * 3.  It returns a StringBuilder. 
	 */
	private static StringBuilder pad(String str) {
		int n = str.length() % 3;
		int len = 3 - n;
		StringBuilder builder = new StringBuilder();
		builder.append(str);
		for(int i=0; i<len;i++) {
			builder.append('\u0000');
		}
		return builder;
	}
	
	/*
	 * @param StringBuilder sb
	 * The StringBuilder takes the last 3 chars and puts it first in
	 * a new StringBuilder object, appending the rest of the chars
	 * afterward.  It returns the new StringBuilder
	 */
	private static StringBuilder flip(StringBuilder sb) {
		StringBuilder builder = new StringBuilder();
		int last = sb.length(); 
		builder.append(sb.substring(last-3));
		builder.append(sb.substring(0,last-3));
		return builder;
	}
	
	/*
	 * @param StringBuilder sb
	 * This method takes in a StringBuilder object, iterates over each
	 * char of it and adds the numeric value of the chars position to 
	 * the ASCII char value.  It returns a new StringBuilder 
	 */
	public static StringBuilder incrementingChar(StringBuilder sb) {
		StringBuilder builder = new StringBuilder();
		int len = sb.length();
		for(int i=0;i<len;i++) {
			char temp = sb.charAt(i);
			int charNum = (int)temp;
			charNum += i;
			builder.append(Character.toChars(charNum));
		}
		return builder;
	}
	
	/*
	 * @param String str
	 * This method takes in a string from the user and uses methods
	 * to alter the values of the chars per the specifications in the
	 * assignment.  This encodes the string.
	 */
	public static String encrypt(String str) {
		StringBuilder sb = pad(str);
		sb = flip(sb);
		sb = incrementingChar(sb);		
		return sb.toString();
	}
	
	/*
	 * @param StringBuilder sb
	 * This method takes in a StringBuilder object, iterates over each
	 * char of it and subtracts the numeric value of the chars position to 
	 * the ASCII char value.  It returns a new StringBuilder 
	 */
	private static StringBuilder decrementingChar(String sb) {
		StringBuilder builder = new StringBuilder();
		int len = sb.length();
		for(int i=0;i<len;i++) {
			char temp = sb.charAt(i);
			int charNum = (int)temp;
			charNum -= i;
			builder.append(Character.toChars(charNum));
		}
		return builder;
	}
	
	/*
	 * @param StringBuilder sb
	 * The StringBuilder takes the first 3 chars and puts it last in
	 * a new StringBuilder object, appending the rest of the chars
	 * afterward.  It returns the new StringBuilder
	 */
	private static StringBuilder flop(StringBuilder sb) {
		StringBuilder builder = new StringBuilder();
		int len = sb.length();
		if(len > 3) {
			builder.append(sb.substring(3));
			builder.append(sb.substring(0, 2));
		}
		else {
			builder.append(sb);
		}

		return builder;	
	}
	
	/*
	 * @param StringBuilder sb
	 * It takes in a StringBuilder and removes the '\u0000' char
	 * from the new StringBuilder. 
	 */
	private static StringBuilder removePad(StringBuilder sb) {
		int len = sb.length();

		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<len;i++) {
			char temp = sb.charAt(i);
		
			if(temp != '\u0000') {
				builder.append(temp);
			}
		}
		return builder;
		
	}
	
	/*
	 * @param String str
	 * This method takes in a string from the user and uses methods
	 * to alter the values of the chars per the specifications in the
	 * assignment.  This decodes the string.
	 */
	public static String decrypt(String str) {

		StringBuilder sb = decrementingChar(str);
		sb = flop(sb);
		sb = removePad(sb);
		return sb.toString();
		
	}
	

}