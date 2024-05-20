/**
 * Class representing a checking or savings account.
 */
public class BankAccount {

    /**
     * The balance of the bank account.
     */
    private double balance;

    /**
     * The account's name.
     */
    private String accName;

    /**
     * The account number.
     */
    private int accNum;

    /**
     * The account type: Checking (C) or Savings (S).
     */
    private char accountType;

    /**
     * The interest rate for a savings account, expressed as percentage points,
     * e.g., 4.0 for a 4% interest rate.
     */
    private double interestRate;

    /**
     * The last assigned account number.
     */
    private static int lastAccNum = 0;

    /**
     * Creates a new instance of BankAccount and increments the lastAccNum.
     */
    public BankAccount() {
        this.accNum = ++lastAccNum;
    }

    /**
     * Creates a new instance of BankAccount with the specified parameters and
     * increments the lastAccNum.
     * 
     * @param balance     the starting balance of the account
     * @param accName     the account name
     * @param accountType the account type
     */
    public BankAccount(double balance, String accName, char accountType) {
        setAccountType(accountType);
        this.balance = balance;
        this.accName = accName;
        this.accNum = ++lastAccNum;
    }

    /**
     * Withdraws the specified amount from the bank account.
     * 
     * @param amount the amount to withdraw.
     * @throws IllegalArgumentException if the account has insufficient funds
     */
    public void withdraw(double amount) {
        double newBalance = balance - amount;
        if (newBalance >= 0) {
            balance = newBalance;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    /**
     * Deposits the specified amount from the bank account.
     * 
     * @param amount the amount to deposit.
     */
    public void deposit(double amount) {
        balance += amount;
    }

    public void displayAccountInfo() {
        System.out.println("The account name is: " + getName());
        System.out.println("The account balance is: " + getBalance());
        System.out.println("The account number is: " + accNum);
        System.out.println("The account interest rate is: " + getInterestRate());
    }

    /**
     * Adds interest to the account balance. Only savings accounts bear interest.
     * 
     * @throws IllegalArgumentException if the account type is not 'S'
     */
    public void addInterest() {
        if (accountType == 'S') {
            double amount = Financial.percentOf(interestRate, balance);
            balance += amount;
        } else {
            throw new IllegalArgumentException("Account type does not bear interest");
        }
    }

    /**
     * Returns the balance of the account..
     * 
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     * 
     * @param balance the new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the account name.
     * 
     * @return the name of the account
     */
    public String getName() {
        return accName;
    }

    /**
     * Sets the name of the account.
     * 
     * @param accName the new name
     */
    public void setName(String accName) {
        this.accName = accName;
    }

    /**
     * Returns the account type.
     * 
     * @return the type of the account
     */
    public char getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type. Only 'S' for savings and 'C' for checking are allowed.
     * 
     * @param accountType the new account type
     * @throws IllegalArgumentException if the account type is invalid
     */
    public void setAccountType(char accountType) {
        switch (accountType) {
            case 'S':
                this.interestRate = 3;
                break;
            case 'C':
                this.interestRate = 0;
                break;
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
        this.accountType = accountType;
    }

    /**
     * Returns the interest rate of the account.
     * 
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate of the account.
     * 
     * @param interestRate the new interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Performs a transfer of funds from one account to another.
     * 
     * @param fromAccount the account to transfer funds from
     * @param toAccount   the account to transfer funds to
     * @param amount      the amount to transfer
     * @throws IllegalArgumentException if the fromAccount has insufficient funds
     */
    public static void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        double newBalance = fromAccount.getBalance() - amount;
        if (newBalance >= 0) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("Insufficient funds to transfer");
        }
    }
}
