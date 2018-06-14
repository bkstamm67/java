package cp120.assignments.assignment003;

import java.math.BigInteger;
import java.util.Arrays;



/**
 * @author bkstamm67
 *
 */
public class Numbers {
	
	/**
	 * @param num is an int passed in
	 * @return a boolean true if num is prime
	 * or false if not
	 * precondition num is a non-negative number.
	 */
	public static boolean isPrime(int num)
	{
		if(num == 1 | num == 0) {
			return false;
		}
		else{
			for(int i = 2;i<num;i++){
				if((num%i) == 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	
	/**
	 * @param param1 an int
	 * @param param2 an int
	 * @return lowest common multiple
	 * precondition param1 and param2 are non-negative numbers.
	 */
	public static int lcm( int param1, int param2 )
	{
		if((param1 == 0) | (param2 == 0)) {
			return 0;
		}
		
		int highest = param1 * param2;
		int tracker = param1;
		while(tracker < highest) {
			if((tracker % param2) == 0) {
				return tracker;
			}
			tracker += param1;
		}
		return highest;
	}
	
	/**
	 * @param param1 an int
	 * @param param2 an int
	 * @return greatest common factor
	 * precondition  param1 and param2 are non-negative numbers.
	 */
	public static int gcf( int param1, int param2 )
	{
		if((param1 == 0) | (param2 == 0)) {
			return 0;
		}
		int min = Math.min(param1, param2);
		int max = Math.max(param1, param2);
		int counter = 2;
		while(counter < min) {
			if(((max%counter) == 0)&&((min%counter == 0))){
				return counter;
			}
			counter += 1;
		}
		
		if(max%min == 0) {
			return min;
		}
		return 1;
		
	}
	
	/**
	 * @param num an int
	 * @return the sum of the digits of 'num'
	 * precondition num is a non-negative number.
	 */
	public static int digitSum( int num )
	{
		int total = 0;
		while(num > 0) {
			total += (num % 10);
			num /= 10;
		}
		return total;
	}
	
	/**
	 * @param arr an array of doubles
	 * @return the mean of the numbers
	 * precondition arr contains at least one element
	 */
	public static double mean( double[] arr )
	{
		double mean = 0;
		for(int i=0; i<arr.length;i++) {
			mean += arr[i];
		}
		mean /= arr.length;
		return mean;
	}
	
	/**
	 * @param arr array of doubles
	 * @return the mean of the array
	 * precondition num is a non-negative number.
	 */
	public static double median( double[] arr )
	{
		Arrays.sort(arr);
		if((arr.length%2 == 0)) {
			double med = (arr[(arr.length/2)] + arr[arr.length/2 -1]);
			med /= 2;
			return med;
		}
		else {
			return arr[(arr.length/2)];
		}
	}
	
	
	/**
	 * @param num an int
	 * @return the factorial of num
	 * precondition  num is a non-negative number
	 */
	public static BigInteger factorial( int num )
	{
		BigInteger biggie = new BigInteger("1");
		
		if(num > 1) 
		{
			for(int i=2;i<=num;i++) {
				biggie = biggie.multiply(BigInteger.valueOf(i));
			}
		}
		
		return biggie;
				
	}
	
	/**
	 * @param num a BigInteger
	 * @return the factorial of num
	 * precondition num is a non-negative number
	 */
	public static BigInteger factorial( BigInteger num )
	{
		BigInteger biggie = new BigInteger("1");
		BigInteger count = new BigInteger("1");
		
		if(num.intValue() > 1) 
		{
			while(count.intValue()<=num.intValue())
			{
				biggie = biggie.multiply(count);
				count = count.add(BigInteger.valueOf(1));
			}
		}
		
		return biggie;
	}
	
	
}
