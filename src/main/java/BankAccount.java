public class BankAccount {

    private double balance;
    private String accName;
    private int accNum;
    private char accountType;
    private double interestRate = 0.03;

    private static int lastAccNum = 0;

    public BankAccount() {
        this.accNum = ++lastAccNum;
    }

    public BankAccount(double balance, String accName, char accountType) {
        this.balance = balance;
        this.accName = accName;
        this.accountType = accountType;
        this.accNum = ++lastAccNum;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public static void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void displayAccountInfo() {
    }

    public void addInterest() {
        if (accountType == 'S') {
            double amount = Financial.percentOf(interestRate, balance);
            balance += amount;
        }
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
