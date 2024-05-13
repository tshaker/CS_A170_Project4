public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount AdamsAcc = new BankAccount();
        AdamsAcc.setAccountType('C');
        AdamsAcc.setName("Adam's Account");
        AdamsAcc.setBalance(10_000);

        BankAccount SamsAcc = new BankAccount(300, "Sam's Account", 'S');
        BankAccount LeilasAcc = new BankAccount(500, "Leilas's Account", 'S');
    }
}
