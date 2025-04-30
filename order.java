package final_assignment;


//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JOptionPane;

public class order {
    //attributes
    private String order_id;
    private String user_id;
    private String vendor_name;
    private String item_name;
    private double item_price;
    private String order_type;
    private String order_status;
    private double total_bill;
    private String Data_and_time;
    private String Address;

    public order(String order_id, String user_id, String vendor_name, String item_name, double item_price, String order_type, String order_status, double total_bill, String Data_and_time, String Address) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.vendor_name = vendor_name;
        this.item_name = item_name;
        this.item_price = item_price;
        this.order_type = order_type;
        this.order_status = order_status;
        this.total_bill = total_bill;
        this.Data_and_time = Data_and_time;
        this.Address = Address;
    }

    public String getOrder_id() {
        return order_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getVendor_name() {
        return vendor_name;
    }
    public String getItem_name() {
        return item_name;
    }
    public double getItem_price() {
        return item_price;
    }
    public String getOrder_type() {
        return order_type;
    }
    public String getOrder_status() {
        return order_status;
    }
    public double getTotal_bill() {
        return total_bill;
    }    
    public String getData_and_time() {
        return Data_and_time;
    }
    public String getAddress() {
        return Address;
    }    
    
    //time
    public static String writerealtime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return currentTime.format(timeFormatter);
    }
    
    //date
    public static String writerealdate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(dateFormatter);
    }
    
    //get last balance
    public static double getLastUserBalance(String filename, String userId) {
    double previous_balance = 30.0; // Default balance for new users
    boolean userFound = false;

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 6 && parts[0].equals(userId)) { // Check if user ID matches
                previous_balance = Double.parseDouble(parts[4]); // Get the current balance
                userFound = true;
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }

    if (!userFound) {
        System.out.println("error");
        
    }

    return previous_balance;
    }   
    
    //get last balance for reordering
    public static double getLastUserBalanceforreordering(String filename, String userId) {
        double previous_balance = -1; // Default value if user is not found
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6 && parts[2].equals(userId)) { // Check if user ID matches
                    previous_balance = Double.parseDouble(parts[5]); // Get the current balance
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return previous_balance;
    }
    
    //order id generator
    public static String generateOrderID() {
        Random random = new Random();
        String firstNumber = String.valueOf(100 + random.nextInt(900)); 
        String secondNumber = String.valueOf(100 + random.nextInt(900));
        return "o" + firstNumber + secondNumber;
    }
    
    //transaction id generator
    public static String generatetransactionID() {
        Random random = new Random();
        String firstNumber = String.valueOf(100 + random.nextInt(900)); 
        String secondNumber = String.valueOf(100 + random.nextInt(900));
        return "t" + firstNumber + secondNumber;
    }
    
    //calculating the total price
    public static double CalculateTotalPrice(double item_price, String delivery_option) {
    double delivery_charge = 0.0;

    switch (delivery_option) {
        case "Dine in":
            delivery_charge = 0.0;
            break;
        case "Take away":
            delivery_charge = 0.0;
            break;
        case "Delivery":
            delivery_charge = 2.0;
            break;
        default:
            delivery_charge = 0.0;
            break;
    }

    double total_charge = item_price + delivery_charge;
    return total_charge;
    }
    
    //writing into both order and vendor history
    public static void writeorder(String fileName, String orderID, String userID, String selectedVendor, String selectedItem, double itemPrice, String selectedOption, String orderStatus, double totalCharge, String time, String address) {
        String order = orderID + "," + userID + "," + selectedVendor + "," + selectedItem + "," + itemPrice + "," + selectedOption + "," + orderStatus + "," + totalCharge + "," + time + "," + address;
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(order);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
    
    //updating an order
    public static void updateOrderStatus(String order_id, String status) {
    try {
        // Process all three files with the given status
        processFile("the_customer_order_history.txt", "Temp.txt", order_id, 9, status);
        processFile("order.txt", "Temp2.txt", order_id, 6, status);
        processFile("vendor_order_history.txt", "Temp3.txt", order_id, 6, status);
    } catch (IOException ex) {
        System.out.println("Error in updating order status: " + ex.getMessage());
    }
    }

    private static void processFile(String inputFile, String tempFile, String order_id, int statusIndex, String status) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));            
        PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)));
    
        String line = br.readLine();
        while (line != null) {                
            String[] words = line.split(",");
            if (words[0].equals(order_id)) {
                words[statusIndex] = status; // Update status dynamically
                pr.println(String.join(",", words));
            } else {
                pr.println(line);
            }
            line = br.readLine();
        }
    
        br.close();
        pr.close();
    
        File oldFile = new File(inputFile);
        File newFile = new File(tempFile);
        if (oldFile.delete()) {
            newFile.renameTo(oldFile);
        } else {
            throw new IOException("Error replacing file: " + inputFile);
        }
    }

    
    
}
