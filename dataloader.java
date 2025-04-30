/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_assignment;

import final_assignment.users;
//import groupassignment.customer_order_history;
//import groupassignment.menu;
//import groupassignment.top_up;
//import groupassignment.wallet;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class dataloader {
    
    // load users.txt data
    // loading the users from file
    public static ArrayList<users> loadusers(String filename) throws IOException 
    {
        ArrayList<users> user = new ArrayList<>();
        BufferedReader reader = new BufferedReader (new FileReader(filename));
        String line;
        
        while ((line = reader.readLine()) != null) 
        {
            String[] parts = line.split(",");
            if (parts.length == 4) 
            {
                String user_id = parts[0].trim();
                String user_pswd = parts[1].trim();
                String user_role = parts[2].trim();
                String user_name = parts[3].trim();
                user.add(new users(user_id, user_pswd, user_role, user_name));
            }
        }
        reader.close();
        return user;
        
    }
    
    // load e wallet data
    public static ArrayList <wallet> loadwallet (String filename) throws IOException 
    {
        ArrayList <wallet> walletList = new ArrayList<> ();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split(",");
            if (parts.length == 6) 
            {
                String user_id = parts[0].trim();
                String transaction_id = parts[2].trim();
                String transaction_type = parts[3].trim();
                String order_id = parts[5].trim();
                
                double transaction_amount = 0.0;    
                double current_balance = 0.0;
                
                // try parsing the transaction amount and current balance
                try 
                {
                    transaction_amount = Double.parseDouble(parts[1].trim());        
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format for current balance in line: " + line);
                    continue;        
                }
                
                try
                {
                    current_balance = Double.parseDouble(parts[4].trim());
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format for current balance in line: " + line);
                    continue;                    
                }
                
                //add it
                walletList.add(new wallet(user_id, transaction_amount, transaction_id, transaction_type, current_balance, 
                                       order_id.equalsIgnoreCase("null") ? null : order_id));
                
                
            }
            else
            {
                System.out.println("Skipping invalid line (incorrect number of parts): " + line);   
            }

        }
        reader.close();
        return walletList;
    }
    
    //load top_up
    public static ArrayList<top_up> loadtopups(String filename) throws IOException {
        ArrayList<top_up> topUps = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String user_id = parts[0].trim();
                String notification = parts[1].trim();
                double amount;
                try {
                    amount = Double.parseDouble(parts[2].trim());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid amount format in line: " + line);
                    continue; // Skip this line if the amount is invalid
                }
                topUps.add(new top_up(user_id, notification, amount));
            } else {
                System.err.println("Invalid line format: " + line);
            }
        }
        reader.close();
        return topUps;
    }
    
    // load themenu.txt
    public static ArrayList<menu> loadmenuitems(String filename) throws IOException {
        ArrayList<menu> menu_items = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String Line;
        
        while ((Line = br.readLine()) != null) {
            String[] parts = Line.split(",");
            if(parts.length == 5) {
                String vendor_id = parts[0];
                String vendor_name = parts[1];
                String item_id = parts[2];
                String item_name = parts[3];
                double item_price = Double.parseDouble(parts[4]);
                
                menu_items.add(new menu (vendor_id, vendor_name, item_id, item_name, item_price));
            }
        }
        
        br.close();
        return menu_items;
        
        // Create/ read/ update/ delete item
        // vendor_id, vendor_name, item_id, item_name, item_price
        
    }
    
    // load customer order history
    public static ArrayList<customer_order_history> loadcustomerorderhistory(String filename) throws IOException {
        ArrayList<customer_order_history> customerorderhistorylist = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String Line;
        // order_id, item_name, user_id, time, order_amount, current_balance, address, order_type, vendor_name, order_status
        while ((Line = br.readLine()) != null) {
            String[] parts = Line.split(",");
            if(parts.length == 10) {
                String order_id = parts [0];
                String item_name = parts[1];
                String user_id = parts[2];              
                String time = parts[3];
                double order_amount = Double.parseDouble(parts[4]);
                double current_balance = Double.parseDouble(parts[5]);
                String address = parts[6];
                String order_type = parts[7];
                String vendor_name = parts[8];
                String order_status = parts[9];
                customerorderhistorylist.add(new customer_order_history (order_id, user_id, item_name, time, order_amount, current_balance, address, order_type, vendor_name, order_status));
            }
        }
        
        br.close();
        return customerorderhistorylist;
    }
    
    public static ArrayList<review> loadreviews(String filename) throws IOException {
        ArrayList<review> reviewlist = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String Line;
        
        while ((Line = br.readLine()) != null) {
            String[] parts = Line.split(",");
            if(parts.length == 7) {
                String review_id = parts[0];
                String order_id = parts[1];
                String user_id = parts[2];
                String vendor_name = parts[3];
                String vendor_review = parts[4];
                String runner_name = parts[5];
                String runner_review = parts[6];
                reviewlist.add(new review (review_id, order_id, user_id, vendor_name, vendor_review, runner_name, runner_review));
            }
        }
        
        br.close();
        return reviewlist;
    }
    
    public static ArrayList<order> loadorder(String filename) throws IOException {
        ArrayList<order> orderlist = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String Line;
        // o260619,c1,arab,falafel,7.0,Take away,Placed,7.0,06:35:17 2025-01-27,

        while ((Line = br.readLine()) != null) {
            String[] parts = Line.split(",");
            if(parts.length == 10) {
                String order_id = parts [0];
                String user_id = parts[1];
                String vendor_name = parts[2];   
                String item_name = parts[3];              
                String order_type = parts[5];
                String order_status = parts[6];
                String Data_and_time = parts[8];
                String Address = parts[9];
                
                double item_price = Double.parseDouble(parts[4]);
                double total_bill = Double.parseDouble(parts[7]);
                
                try 
                {
                    item_price = Double.parseDouble(parts[4].trim());
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format in line: " + Line);
                    continue;
                }
                
                try 
                {
                    total_bill = Double.parseDouble(parts[7].trim());
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format in line: " + Line);
                    continue;
                }                
                
                orderlist.add(new order (order_id, user_id, vendor_name, item_name, item_price, order_type, order_status, total_bill, Data_and_time, Address));
            }
            else 
            {
                System.out.println("Skipping invalid line: " + Line);
            }
        }
        
        br.close();
        return orderlist;
    }
    
    public static ArrayList<vendor_order_history> loadvendorhistory(String filename) throws IOException {
        ArrayList<vendor_order_history> vendorhistory = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String Line;
        // o260619,c1,arab,falafel,7.0,Take away,Placed,7.0,06:35:17 2025-01-27,

        while ((Line = br.readLine()) != null) {
            String[] parts = Line.split(",");
            if(parts.length == 10) {
                String order_id = parts [0];
                String user_id = parts[1];
                String vendor_name = parts[2];   
                String item_name = parts[3];              
                String order_type = parts[5];
                String order_status = parts[6];
                String Data_and_time = parts[8];
                String Address = parts[9];
                
                double item_price = Double.parseDouble(parts[4]);
                double total_bill = Double.parseDouble(parts[7]);
                
                try 
                {
                    item_price = Double.parseDouble(parts[4].trim());
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format in line: " + Line);
                    continue;
                }
                
                try 
                {
                    total_bill = Double.parseDouble(parts[7].trim());
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number format in line: " + Line);
                    continue;
                }                
                
                vendorhistory.add(new vendor_order_history (order_id, user_id, vendor_name, item_name, item_price, order_type, order_status, total_bill, Data_and_time, Address));
            }
            else 
            {
                System.out.println("Skipping invalid line: " + Line);
            }
        }
        
        br.close();
        return vendorhistory;
    }
    
    //Suhana
    
    //private final String filePath;

    // Constructor to specify the file path
    //public DataLoader(String filePath) {
        //this.filePath = filePath;
    //}

    // Method to load all data from the file
    public List<String[]> loadData() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("tasksreview.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields (assuming comma-separated values)
                String[] fields = line.split(",");
                data.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return data;
    }

    // Overloaded method to load filtered data
    public List<String[]> loadFilteredData(String columnValue, int columnIndex) {
        List<String[]> filteredData = new ArrayList<>();
        for (String[] row : loadData()) {
            if (row[columnIndex].equalsIgnoreCase(columnValue)) {
                filteredData.add(row);
            }
        }
        return filteredData;
    }
    
  public static ArrayList<Complaint> loadComplaints(String filename) throws IOException {
        ArrayList<Complaint> complaints = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                complaints.add(new Complaint(
                    parts[0], // complain_id
                    parts[1], // order_id
                    parts[2], // user_id
                    parts[3], // vendor_name
                    parts[4], // vendor_review
                    parts[5], // runner_name
                    parts[6], // runner_review
                    parts[7]  // complaint_status
                ));
            } else {
                // Log malformed lines for debugging
                System.out.println("Skipping malformed line: " + line);
            }
        }

        reader.close();
        return complaints;
    }

    // Method to save complaints to a file
    public static void saveComplaints(String fileName, ArrayList<Complaint> complaints) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

    for (Complaint complaint : complaints) {
        writer.write(String.join(",",
            complaint.getReview_id(),  // Use getReview_id() instead of getComplain_id()
            complaint.getOrder_id(),
            complaint.getUser_id(),
            complaint.getVendor_name(),
            complaint.getVendor_review(),  // Use getVendor_review() instead of getVendor_complaint()
            complaint.getRunner_name(),
            complaint.getRunner_review(),  // Use getRunner_review() instead of getRunner_complaint()
            complaint.getComplaint_status()
        ));
        writer.newLine(); // Write a new line for each complaint
    }

    writer.close();
    }


 public static ArrayList<MenuItem> loadMenuItems(String filename) throws IOException {
    ArrayList<MenuItem> menuItems = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));

    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 5) {
            menuItems.add(new MenuItem(
                parts[0], // vendor_id
                parts[1], // vendor_name
                parts[2], // item_id
                parts[3], // item_name
                Double.parseDouble(parts[4]) // item_price
            ));
        } else {
            // Log malformed lines for debugging
            System.out.println("Skipping malformed line: " + line);
        }
    }

    reader.close();
    return menuItems;
}

// Method to save menu items to a file
public static void saveMenuItems(String fileName, ArrayList<MenuItem> menuItems) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

    for (MenuItem menuItem : menuItems) {
        writer.write(String.join(",",
            menuItem.getVendor_id(),
            menuItem.getVendor_name(),
            menuItem.getItem_id(),
            menuItem.getItem_name(),
            String.valueOf(menuItem.getItem_price()) // Convert double to String
        ));
        writer.newLine(); // Write a new line for each menu item
    }

    writer.close();
}

public static ArrayList<review> loadReviews(String filename) throws IOException {
    ArrayList<review> reviews = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));

    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 7) {
            reviews.add(new review(
                parts[0], // review_id
                parts[1], // order_id
                parts[2], // user_id
                parts[3], // vendor_name
                parts[4], // vendor_review
                parts[5], // runner_name
                parts[6]  // runner_review
            ));
        } else {
            System.out.println("Skipping malformed line: " + line);
        }
    }

    reader.close();
    return reviews;
}

public static void saveReviews(String fileName, ArrayList<review> reviews) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

    for (review review : reviews) {
        writer.write(String.join(",",
            review.getReview_id(),
            review.getOrder_id(),
            review.getUser_id(),
            review.getVendor_name(),
            review.getVendor_review(),
            review.getRunner_name(),
            review.getRunner_review()
        ));
        writer.newLine();
    }

    writer.close();
}
 public static ArrayList<VendorPerformance> loadVendorPerformance(String filename) throws IOException {
        HashMap<String, Double> revenueMap = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 8) {  // Ensure correct format (at least 8 fields)
                String vendorName = parts[2]; // Vendor name
                double totalBill;

                try {
                    totalBill = Double.parseDouble(parts[7]); // Corrected index for total bill
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid total bill: " + parts[7]);
                    continue; // Skip invalid entries
                }

                // Add revenue to vendor's total
                revenueMap.put(vendorName, revenueMap.getOrDefault(vendorName, 0.0) + totalBill);
            }
        }
        reader.close();

        // Convert to an ArrayList of VendorPerformance objects
        ArrayList<VendorPerformance> vendorPerformanceList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : revenueMap.entrySet()) {
            vendorPerformanceList.add(new VendorPerformance(entry.getKey(), entry.getValue()));
        }
        return vendorPerformanceList;
    }



public static ArrayList<VendorOrder> loadVendorOrders(String fileName) throws IOException {
    ArrayList<VendorOrder> orders = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;

    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 10) {
            orders.add(new VendorOrder(
                parts[0],  // orderID
                parts[1],  // userID
                parts[2],  // vendorName
                parts[3],  // itemName
                Double.parseDouble(parts[4]),  // itemPrice
                parts[5],  // orderType
                parts[6],  // orderStatus
                Double.parseDouble(parts[7]),  // totalBill
                parts[8],  // dateTime
                parts[9]   // address
            ));
        } else {
            System.out.println("Skipping malformed line: " + line);
        }
    }

    reader.close();
    return orders;
}

    public static ArrayList<holduserdata> loadheldusers(String filename) throws IOException {
        ArrayList<holduserdata> helduserlist = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        String Line;
        
        while ((Line = br.readLine()) != null) {
            String[] parts = Line.split(",");
            if(parts.length == 3) {
                String userId = parts[0];
                String userName = parts[1];
                String role = parts[2];
                helduserlist.add(new holduserdata (userId, userName, role));
            }
        }
        
        br.close();
        return helduserlist;
    }
    
}
