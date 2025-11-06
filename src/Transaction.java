import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction{
    // Variables
    private String type;
    private double amount;
    private LocalDateTime date;
    private double balanceAfter;

    public Transaction (String type, double amount, double balanceAfter){ // Constructor
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.date = LocalDateTime.now();
    }
    public String getType(){ // Getter
        return type;
    }

    public  double getAmount(){ // Getter
        return amount;
    }

    public double getBalanceAfter(){ // Getter
        return balanceAfter;
    }
    
    public LocalDateTime getDate(){ // Getter
        return date;
    }
    
    @Override
    public String toString(){ // toString method
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        return "[" + date.format(formatter) + "] "
                + type + ": $" + amount + " | Balance after: $" + balanceAfter;
    }
}
