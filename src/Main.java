import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean isRunning = true;

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║ Welcome to Java Bank Simulator ║");
        System.out.println("╚════════════════════════════════╝");

        while (isRunning) {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║          Main Menu         ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("╔════════════════════════════╗");
            System.out.println("║ 1. Create Savings Account  ║");
            System.out.println("║ 2. Create Checking Account ║");
            System.out.println("║ 3. Deposit                 ║");
            System.out.println("║ 4. Withdraw                ║");
            System.out.println("║ 5. Transfer                ║");
            System.out.println("║ 6. Print All Accounts      ║");
            System.out.println("║ 7. View Account Statement  ║");
            System.out.println("║ 8. Exit                    ║");
            System.out.println("╚════════════════════════════╝");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String owner = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter interest rate (0.02 for 2%): ");
                    double rate = scanner.nextDouble();

                    SavingsAccount savings = new SavingsAccount(accNum, owner, balance, rate);
                    bank.addAccount(savings);
                }
                
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String owner = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter transaction fee: ");
                    double fee = scanner.nextDouble();

                    CheckingAccount checking = new CheckingAccount(accNum, owner, balance, fee);
                    bank.addAccount(checking);
                }
                
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();

                    Account account = bank.findAccount(accNum);
                    if(account != null) account.deposit(amount);   
                }

                case 4 -> {
                    System.out.print("Enter account number: ");
                    String accNum =scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();

                    Account account = bank.findAccount(accNum);
                    if(account != null) account.withdraw(amount);
                }

                case 5 -> {
                    System.out.print("Enter sender account number: ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("Enter receiver account number: ");
                    String toAcc =  scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double amount = scanner.nextDouble();

                    bank.transfer(fromAcc, toAcc, amount);
                }
                
                case 6 -> bank.printAllAccounts();

                case 7 -> {
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    Account account = bank.findAccount(accNum);
                    if(account != null) account.printStatement();
                }

                case 8 -> {
                    System.out.println("Exiting system... Thank you for using Java Bank");
                    isRunning = false;
                }

                default -> System.out.println("Invalid Option, please try again!");

                }
            }
            scanner.close();
    }   
}
