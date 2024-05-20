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
