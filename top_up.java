package final_assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class top_up {
    
    // top_up.txt : user_id,notification,amount
    
    // ask text for user id and see if it exists in notif_top_up and also check for the notification column
    //if it exists then check in top_up.txt and check the notification if the string is "placed"
    // top_up.txt structure "user_id,notification,amount" where data is string,string,double
    // user_id is the id of the customer that wants to top up
    // notification is either "placed" or "topup" or 
    // amount is the amount to top up

    // if the notification is "placed" then the steps of this top up method is executed  (in "top_up" txt
    // it will check for the latest current balance in wallet.txt and calculate new balance after the amount is topped up 
    // it will generate new transaction id 
    // finally append the info into wallet txt

    // now in top_up txt change the line with the chosen user_id, change "placed" to "topup"
    
    private String user_id;
    private String notification;
    private double amount;

    public top_up(String user_id, String notification, double amount) {
        this.user_id = user_id;
        this.notification = notification;
        this.amount = amount;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNotification() {
        return notification;
    }
    public void setNotification(String notification) {
        this.notification = notification;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    //writing into top up.txt
    public static void writetopup(String customer_id, String topup_status, double total_bill) {
        String top_up = customer_id + "," + topup_status + "," + total_bill;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("top_up.txt", true))) {
            bw.write(top_up);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
    
    

    
}
