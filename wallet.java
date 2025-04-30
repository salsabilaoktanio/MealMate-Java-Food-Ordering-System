package final_assignment;

//imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class wallet {
    //attributes
    private String user_id;
    private double transaction_amount;
    private String transaction_id;
    private String transaction_type;
    private double current_balance;
    private String order_id;
    
    //constructor
    public wallet(String user_id, double transaction_amount, String transaction_id, String transaction_type, double current_balance, String order_id) {
        this.user_id = user_id;
        this.transaction_amount = transaction_amount;
        this.transaction_id = transaction_id;
        this.transaction_type = transaction_type;
        this.current_balance = current_balance;
        this.order_id = order_id;
    }

    // Getters and setters
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(double current_balance) {
        this.current_balance = current_balance;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    
    //writing into wallet.txt
    public static void writeransaction(String userID, double totalCharge, String transactionID, String transactionType, double currentBalance, String orderID) {
        String transaction = userID + "," + totalCharge + "," + transactionID + "," + transactionType + "," + currentBalance + "," + orderID;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("wallet.txt", true))) {
            bw.write(transaction);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
    
}
