/*
	Shaker, Tim     
	
	May 20, 2024
	
	CS A170
	Project 4
*/

/**
 * This class demonstrates the use of the BankAccount class.
 */
public class BankAccountDemo {
	/**
	 * Performs various operations on BankAccount objects.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// Create AdamsAcc with the default constructor, set account type, name, and
		// balance, then display account info.
		BankAccount AdamsAcc = new BankAccount();
		AdamsAcc.setAccountType('C');
		AdamsAcc.setName("Adam Sandler");
		AdamsAcc.setBalance(10_000);
		AdamsAcc.displayAccountInfo();
		System.out.println("*****************************************");

		// Create LeilasAcc with the parameterized constructor, then deposit money and
		// display the account info.
		BankAccount LeilasAcc = new BankAccount(500, "Leila", 'S');
		LeilasAcc.deposit(300);
		LeilasAcc.displayAccountInfo();

		// Transfer money from AdamsAcc to LeilasAcc, then display the balance after
		// transferring.
		BankAccount.transfer(AdamsAcc, LeilasAcc, 200);
		System.out.println("Balance after transfering: " + LeilasAcc.getBalance());
		// Add interest to LeilasAcc, then display the balance after adding interest.
		LeilasAcc.addInterest();
		System.out.println("Account balance after adding interest is: " + LeilasAcc.getBalance());
		System.out.println("******************************************");

		// Create SamsAcc with the parameterized constructor, then display the account
		// info.
		BankAccount SamsAcc = new BankAccount(300, "Sam", 'S');
		SamsAcc.displayAccountInfo();
		// Withdraw money from SamsAcc, then display the balance after withdrawing.
		SamsAcc.withdraw(100);
		System.out.println("The balance after withdrawning is: " + SamsAcc.getBalance());

		// Attempt to transfer money from SamsAcc to LeilasAcc. Since SamsAcc does not
		// have enough money, the transfer will fail and throw an exception.
		BankAccount.transfer(SamsAcc, LeilasAcc, 300);
	}
}
