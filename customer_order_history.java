package final_assignment;

//imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class customer_order_history {
    //attributes
    private String order_id;
    private String user_id;
    private String item_name;
    private String time;
    private double order_amount;
    private double current_balance;
    private String address;
    private String order_type;
    private String vendor_name;
    private String order_status;
    
    //constructor
    public customer_order_history(String order_id, String user_id, String item_name, String time, double order_amount, double current_balance, String address, String order_type, String vendor_name, String order_status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.item_name = item_name;
        this.time = time;
        this.order_amount = order_amount;
        this.current_balance = current_balance;
        this.address = address;
        this.order_type = order_type;
        this.order_status = order_status;
        this.vendor_name = vendor_name;
    }

    
    //getters
    public String getOrder_id() {
        return order_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getItem_name() {
        return item_name;
    }
    public String getTime() {
        return time;
    }
    public double getOrder_amount() {
        return order_amount;
    }
    public double getCurrent_balance() {
        return current_balance;
    }
    public String getAddress() {
        return address;
    }    
    public String getOrder_type() {
        return order_type;
    }    
    public String getVendor_name() {
        return vendor_name;
    }
    public String getOrder_status() {
        return order_status;
    }   
    
    //setters
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }

    public void setCurrent_balance(double current_balance) {
        this.current_balance = current_balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
    
    //writing into customer hsitory
    public static void writeintocustomerhistory(String orderID, String selectedItem, String userID, String time, double orderAmount, double currentBalance, String address, String selectedOption, String selectedVendor, String orderStatus) {
        String entry = orderID + "," + selectedItem + "," + userID + "," + time + "," + orderAmount + "," + currentBalance + "," + address + "," + selectedOption + "," + selectedVendor + "," + orderStatus;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("the_customer_order_history.txt", true))) {
            bw.write(entry);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
    
}
