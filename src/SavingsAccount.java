public class SavingsAccount extends Account { // inherits Account class

    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String owner, double balance, double interestRate){
        super(accountNumber, owner, balance); // calls constructor in the Account class
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount){ // Deposit Method
        if (amount > 0){
            balance += amount;
            transactions.add(new Transaction("Deposit: ", amount, balance));
            System.out.println("Deposited $" + amount + " successfully.");
        }else{
            System.out.println("Deposit amount must be positive!");
        }
    }

    @Override
    public void withdraw(double amount){ // Withdraw Method
        if(amount > 0 && amount <= balance){
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount, balance));
            System.out.println("Withdrew $" + amount + " successfuly.");
        }else{
            System.out.println("Insufficient balance or Invalid amount!");
        }    
    }

    public void applyInterest(){ // Getter
        double interest = balance * interestRate;
        balance += interest;
        transactions.add(new Transaction("Interest", interest, balance));
        System.out.println("Interest of $" + interest + " applied.");
    }

    public double getInterestRate(){ // Getter
        return interestRate;
    }
}