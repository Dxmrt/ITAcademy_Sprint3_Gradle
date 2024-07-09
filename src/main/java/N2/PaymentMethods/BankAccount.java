package N2.PaymentMethods;



public class BankAccount implements PaymentMethod {
    private final String owner;
    private final String accountNumber;
    private double balance;

    public BankAccount(String owner, String accountNumber, double initialBalance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void pay(double price) {
        if (price <= balance) {
            balance -= price;
            System.out.println("Paid " + price + " using Bank Account. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance to pay " + price);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
