public class CheckingAccount extends Account { // inherits from abstract Account Class
    
    private double transactionFee;

    public CheckingAccount (String accountNumber, String owner, double balance, double transactionFee){
        super(accountNumber, owner, balance); // calls the parent (Account) constructor
        this.transactionFee = transactionFee; // to initialize the shared attributes.
    }

    @Override
    public void deposit (double amount){ // Deposit Method
        if (amount > 0){
            balance += amount;
            transactions.add(new Transaction("Deposit", amount, balance));
            System.out.println("Deposited $" + amount + " successfully.");
        }else{
            System.out.println("Deposit must be positive!");
        }
    }

    @Override
    public void withdraw(double amount){ // Withdraw Method with transaction fee
        if(amount > 0 && amount <= balance){
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount, balance));
            transactions.add(new Transaction("Fee", transactionFee, balance));
            System.out.println("Withdrew $" + amount + " sucessfully (Fee: $" + transactionFee + ").");
        }else{
            System.out.println("Insufficient balance or Invalid Input!");
        }
    }

    public double getTransactionFee(){ // getter
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee){ // setter
        this.transactionFee = transactionFee;
    }
}
