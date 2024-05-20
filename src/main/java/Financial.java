/*
	Shaker, Tim     
	
	May 20, 2024
	
	CS A170
	Project 4
*/

/**
 * Class containing a static method to calculate interest.
 */
public class Financial {
	/**
	 * Returns the amount of interest earned on a given balance.
	 * 
	 * @param interestRate the interest rate
	 * @param balance      the account balance
	 * @return the amount of interest earned
	 */
	public static double percentOf(double interestRate, double balance) {
		return (interestRate / 100.0) * balance;
	}
}
