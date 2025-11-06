import java.util.ArrayList;

public abstract class Account {

    private String accountNumber; // private = only accesible inside the class
    private String owner;
    protected double balance;   // protected = accessible inside parent and child classes
    protected ArrayList<Transaction> transactions;

    public Account(String accountNumber, String ownerName, double balance){ // Constructor
        this.accountNumber = accountNumber;
        this.owner = ownerName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    public String getAccountNumber(){ // Getter
        return accountNumber;
    }
    public String getOwnerName(){ // Getter
        return owner;
    }
    public double getBalance(){ // Getter
        return balance;
    }

    public abstract void deposit(double amount); // Abstract methods

    public abstract void withdraw(double amount); // Abstract methods

    public void printStatement(){ // method
        System.out.println("\n--- Account Statement ---");
        System.out.println("Account: " + accountNumber + " | Owner: " + owner);
        for(Transaction t : transactions){
            System.out.println(t);
        }
        System.out.println("Current Balance: $" + balance);
    }
}
