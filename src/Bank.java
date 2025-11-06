import java.util.ArrayList; // Store many accounts in one collection
public class Bank {
    
    private ArrayList<Account> accounts;
    
    public Bank(){ // Constructor
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account){ // Add acount method
        accounts.add(account);
        System.out.println("Account for " + account.getOwnerName() + 
                           " added successfully.");
    }

    public Account findAccount (String accountNumber){ // Find account method
        for(Account account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        System.out.println("Account not found!");
        return null; // so the rest of the code can safely check if the account exists 
                     // before doing anything else
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount){
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if(fromAccount == null || toAccount == null){ // checks if both accounts exist before continuing
            System.out.println("Transfer failed: One or both accounts not found!");
            return;
        }

        if(fromAccount == toAccount){
            System.out.println("Transfer failed: You cannot transfer to the same account!");
            return;
        }

        if (amount > 0 && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred $" + amount + " from " + fromAccount.getOwnerName() +
                                " to " + toAccount.getOwnerName() + " successfully.");
        }else{
            System.out.println("Transfer failed: Invalid amount or Insufficient Balance!");
        }
    }

    public void printAllAccounts(){ // print all account method
        System.out.println("\n--- Bank Accounts ---");
        for (Account account : accounts){
            System.out.println(account.getAccountNumber() + " | " + account.getOwnerName() +
                               " | Balance: $" + account.getBalance());
        }
    }
}
