public class BankAccount {

	private double balance;
	private String accName;
	private int accNum;
	private char accountType;
	private double interestRate;

	private static int lastAccNum = 0;

	public BankAccount(double balance, String accName, char accountType) {
		this.balance = balance;
		this.accName = accName;
		this.accountType = accountType;
		this.interestRate = 0.03;
		this.accNum = ++lastAccNum;
	}

	public void withdraw() {
	}

	public void deposit() {
	}

	public void transfer(BankAccount otherAccount, double amount) {
	}

	public void displayAccountInfo() {
	}

	public void addInterest() {
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return accName;
	}

	public void setName(String accName) {
		this.accName = accName;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
