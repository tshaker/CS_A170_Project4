
public class BankAccountDemo {
	/**
	 * Performs various operations on BankAccount objects.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		BankAccount AdamsAcc = new BankAccount();
		AdamsAcc.setAccountType('C');
		AdamsAcc.setName("Adam Sandler");
		AdamsAcc.setBalance(10_000);
		AdamsAcc.displayAccountInfo();
		System.out.println("*****************************************");

		BankAccount LeilasAcc = new BankAccount(500, "Leila", 'S');
		LeilasAcc.deposit(300);
		LeilasAcc.displayAccountInfo();

		BankAccount.transfer(AdamsAcc, LeilasAcc, 200);
		System.out.println("Balance after transfering: " + LeilasAcc.getBalance());
		LeilasAcc.addInterest();
		System.out.println("Account balance after adding interest is: " + LeilasAcc.getBalance());
		System.out.println("******************************************");

		BankAccount SamsAcc = new BankAccount(300, "Sam", 'S');
		SamsAcc.displayAccountInfo();
		SamsAcc.withdraw(100);
		System.out.println("The balance after withdrawning is: " + SamsAcc.getBalance());

		BankAccount.transfer(SamsAcc, LeilasAcc, 300);
	}
}
