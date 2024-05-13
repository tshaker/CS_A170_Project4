public class BankAccount {

    private double balance;
    private String accName;
    private int accNum;
    private char accountType;
    private double interestRate;

    private static int lastAccNum = 0;

    public BankAccount() {
        this.accNum = ++lastAccNum;
    }

    public BankAccount(double balance, String accName, char accountType) {
        setAccountType(accountType);
        this.balance = balance;
        this.accName = accName;
        this.accNum = ++lastAccNum;
    }

    public void withdraw(double amount) {
        double newBalance = balance - amount;
        if (newBalance >= 0) {
            balance = newBalance;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void displayAccountInfo() {
        System.out.println("The account name is: " + getName());
        System.out.println("The account balance is: " + getBalance());
        System.out.println("The account number is: " + accNum);
        System.out.println("The account interest rate is: " + getInterestRate());
    }

    public void addInterest() {
        if (accountType == 'S') {
            double amount = Financial.percentOf(interestRate, balance);
            balance += amount;
        } else {
            throw new IllegalArgumentException("Account type does not bear interest");
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
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

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
