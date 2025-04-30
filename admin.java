/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_assignment;

// where all the login for each task goes
// call the functions to each jframe
// admin class extends users class

import final_assignment.dataloader;
import final_assignment.users;
//import groupassignment.customer_order_history;
//import groupassignment.top_up;
//import groupassignment.wallet;
import final_assignment.customer_order_history;
import final_assignment.top_up;
import final_assignment.wallet;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class admin extends users {

    public admin(String user_id, String user_pswd, String user_role, String user_name) {
        super(user_id, user_pswd, user_role, user_name);
    }
    
    // Default Constructor
    public admin() {
        super(); // Calls the default constructor of the users class
    }  
            
    
    // 1. CRUD
    // 1.1 create user old
    public void createUser(String userId, String userPswd, String userRole, String userName)
    {
        try (BufferedWriter writer = new BufferedWriter (new FileWriter("users.txt", true))) 
        {
            writer.newLine();
            String userData = String.join(",", userId, userPswd, userRole, userName);
            writer.write(userData);
            
            System.out.println("User created successfullY" );
            
            
        } 
        
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    // FINAL CREATE USER (DONE)
    public boolean createUser1(String userId, String userPswd, String userRole, String userName) 

    {
        try 
        {
            // Load existing users
            ArrayList<String> existingUsers = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    String[] userData = line.split(",");
                    if (userData.length > 0) 
                    {
                        existingUsers.add(userData[0]);
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Error reading users file: " + e.getMessage());
                return false;
            }
            // Validate if user ID already exists
            if (existingUsers.contains(userId)) 
            {
                System.out.println("Error: User ID already exists!");
                return false;
            } 
            // Validate the user ID prefix based on the role
            if (userRole.equalsIgnoreCase("customer") && !userId.startsWith("c")) 
            {
                System.out.println("Error: Customer user ID must start with 'c'.");
                return false;
            } 
            else if (userRole.equalsIgnoreCase("vendor") && !userId.endsWith("v")) 
            {
                System.out.println("Error: Vendor user ID must start with 'v'.");
                return false;
            } 
            else if (userRole.equalsIgnoreCase("runner") && !userId.startsWith("r")) 
            {
                System.out.println("Error: Runner user ID must start with 'r'.");
                return false;
            } 
            // Save the new user to users.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) 
            {
                File file = new File("users.txt");
                if (file.length() > 0) // Check if file is not empty
                {
                    writer.newLine(); // Add a newline before writing a new user
                }
                writer.write(String.join(",", userId, userPswd, userRole, userName));
            } 
            catch (IOException e) 
            {
                System.out.println("Error writing to users file: " + e.getMessage());
                return false;
            } 
            // If the user is a customer, add an entry in wallet.txt
            if (userRole.equalsIgnoreCase("customer")) 
            {
                //

                //
                String transactionID = order.generatetransactionID(); // Generate transaction ID in "tXXXXX" format 
                try (BufferedWriter walletWriter = new BufferedWriter(new FileWriter("wallet.txt", true))) 
                {
                    File file = new File("wallet.txt");
                    if (file.length() > 0) // Check if file is not empty
                    {
                        walletWriter.newLine(); // Add a newline before writing a new entry
                    }
                    walletWriter.write(String.format("%s,0.0,%s,new,0.0,none", userId, transactionID));
                }
                catch (IOException e) 
                {
                    System.out.println("Error writing to wallet file: " + e.getMessage());
                    return false;
                }
            } 
            System.out.println("User created successfully.");
            return true; // User creation successful
        } 
        catch (Exception e) 
        { // Catch any unexpected exceptions
            System.out.println("Unexpected error: " + e.getMessage());
            return false;
        }
    }   
 
    
    // 1.2 read user (DONE)
    public String readUser(String filename, String userId) 
    {
        try
        {
            // call the loadusers method
            ArrayList<users> userList = dataloader.loadusers (filename);
            
            // iterate through userList to find user ID
            for (users user : userList)
            {
                if (user.getUser_id().equals(userId))
                {
                    return "User ID: " + user.getUser_id() + "\n" + "Password: " + user.getUser_pswd() + "\n" + "Role: " + user.getUser_role() + "\n" + "Name: " + user.getUser_name();
                }
             
            }
            
            // if id not found
            return "User ID " + userId + " not found.";
           
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Error loading user data.";
        }
        
    }
    
    // 1.3 update user (DONE)
    public boolean updateUser(String filename, String userID, String newPassword, String newName)
    {
        try 
        {
            ArrayList<users> userList = dataloader.loadusers (filename);
            boolean userFound = false;
            for (users user : userList) 
            {
                if (user.getUser_id().equals(userID))
                {
                    // user id is found.
                    // update only the fields that jave user input in the jframe
                    if (newPassword != null && !newPassword.isEmpty())
                    {
                        user.setUser_pswd(newPassword);
                    }
                    if (newName != null && !newName.isEmpty())
                    {
                        user.setUser_name(newName);
                    }
                    userFound = true;
                    break;
                    
                }
            }
            if (userFound)
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                
                for (users user : userList)
                {
                    writer.write(user.getUser_id() + "," + user.getUser_pswd() + "," + user.getUser_role() + "," + user.getUser_name());
                    writer.newLine();           
                }
                
                writer.close();
                
            }
            return userFound;
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    
    // 1.4 delete user (DONE)
    public boolean deleteUser(String chosen_user_id)
    {
        // TODO add your handling code here:
        try
        {
            ArrayList<users> userList = dataloader.loadusers("users.txt");
            
            // user id inputted
            
            // find and remove the user with the given id
            // compare userID (inputted) with user_id
            boolean userFound = false;
            for (int i = 0; i < userList.size(); i++)
            {
                if (userList.get(i).getUser_id().equals(chosen_user_id))
                {
                    userList.remove(i);
                    userFound = true;
                    break;
                }
            }
        
            if (userFound)
            {
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt")))
                {
                    for (users user : userList)
                    {
                        writer.newLine();
                        writer.write(user.getUser_id() + ", " + user.getUser_pswd() + ", " + user.getUser_role() + ", " + user.getUser_name());
                    }
                    //System.out.println("User deleted successfully.");
                }
                return true;
            }
            else
            {
               // System.out.println("User not found. ");
               return false;
            }
        
        }
        catch (IOException e)
        {
            System.out.println("Error loading users: " + e.getMessage());
            e.printStackTrace();
            return false;             
        } 
        
    }
    
    
    // 2. top up
        // wallet.txt (user_id, transaction_amount, transaction_id, transaction_type, current_balance)
        // input for user_id of customer that wants to top up in users.txt (make sure it exist)
        // input for amount to top up 
        // if it exists then check the last instance of user_id in the wallet.txt to show the latest current_balance and store it in a variable "chosen current"
        // add the input amount to top up to the chosen_current_balance and store it in a new variable new_balance
        // write into the text file the same user_id, the transaction_amoun (how much they topped up), the transaction_id (randomly generate the id for the next line), transaction_type (which is topup), current_balance (which is the calculated new_balance)
        //  lets say there are 3 lines in thex text file with the same user_id, i want it to go to the last line of that user id
    
    
    // wallet.txt (user_id, transaction_amount, transaction_id, transaction_type, current_balance)
    // top_up.txt (user_id, notification, amount)
    // for the chosen userid (that will be taken from the text field later) check in top_up.txt for the line with the matching user_id and check if the notification column = "placed", also check for the amount they want to top up
    // if both are true then the same logic for topping up is executed : check latest balance in wallet.txt, calculating the newest balance based on the amount in the top_up file + the latest balance in wallet file, generating the txn id, appending into the wallet.txt 
    // the top up logic needs to be the same however instead of getting the amount to topup from user input, it will automatically get it from top_up
    // if the chosen user id is not "placed" then just print like "error"
    // once top up is successful then in top_up.txt , for that user_id change the "placed" notification to "topup"

    public boolean topup (String userID, String walletFile, String topUpFile, String customerOrderHistoryFile)
    {
        try 
        {
        
            // load wallet.txt and users.txt
            ArrayList<wallet> walletList = dataloader.loadwallet(walletFile);
            ArrayList<top_up> topUpList = dataloader.loadtopups(topUpFile);
            ArrayList<customer_order_history> customerOrderHistoryList = dataloader.loadcustomerorderhistory(customerOrderHistoryFile);

            
            // check if user exists in top_up.txt and notification is "placed"
            top_up selectedTopUp = null;
            for (top_up t : topUpList)
            {

                if (t.getUser_id().equals(userID) && t.getNotification().equalsIgnoreCase("placed"))
                {
                    selectedTopUp = t;
                    break;
                }
            }
            
            // if the notification is not topup
            if (selectedTopUp == null)
            {
                System.out.println("Error: No top-up request with status 'placed' for user ID: " + userID);
                return false; // No valid top-up request            
            }
            
            // get top up amount from top_up.txt
            double topupAmount = selectedTopUp.getAmount();
            
            
            // find the latest balance for the given user_id
            double currentBalance = 0.0;
            for (wallet w : walletList)
            {
                if (w.getUser_id().equals(userID))
                {
                    currentBalance = w.getCurrent_balance(); // get the last occurence of user_id
                }
            }
            
            // calculate new balance
            double newBalance = currentBalance + topupAmount;
            
            // generate random transaction id
            int lastTxnId = 0;
            for (wallet w : walletList)
            {
                if (w.getTransaction_id().startsWith("txn"))
                {
                    try
                    {
                        int txnId = Integer.parseInt(w.getTransaction_id().substring(3));
                        lastTxnId = Math.max(lastTxnId, txnId);
                    }
                    catch (NumberFormatException e)
                    {
                        
                    }
                }
            }
            
            String transactionID = "txn" + (lastTxnId + 1);
            
            // append the new transaction id to wallet txt
            try (BufferedWriter writer = new BufferedWriter (new FileWriter(walletFile, true))) 
            {
                String newTransaction = String.format("%s,%.2f,%s,topup,%.2f,none", userID, topupAmount, transactionID, newBalance);
                writer.write(newTransaction);
                writer.newLine();
            }
            
            // 3.1 generate top up notification 
            // if successful write into top_up.txt
            try (BufferedWriter topupWriter = new BufferedWriter(new FileWriter(topUpFile))) {
                for (top_up t : topUpList) {
                    if (t.getUser_id().equals(userID) && t.getNotification().equalsIgnoreCase("placed")) {
                        t.setNotification("topup"); // Update the notification status
                    }
                String updatedEntry = String.format("%s,%s,%.2f", t.getUser_id(), t.getNotification(), t.getAmount());
                topupWriter.write(updatedEntry);
                topupWriter.newLine();
                }
            }
            
            // 3.2 update customer order history txt
            // Update the last line in customer_order_history.txt with the new balance
            int lastIndex = -1;
            for (int i = 0; i < customerOrderHistoryList.size(); i++) 
            {
                if (customerOrderHistoryList.get(i).getUser_id().equals(userID)) 
                {
                    lastIndex = i; // Track the last occurrence of the user_id
                }
            }
            
            // also update current balance for customer_order_history
            if (lastIndex != -1) 
            {
                customerOrderHistoryList.get(lastIndex).setCurrent_balance(newBalance);

                // Rewrite customer_order_history.txt
                try (BufferedWriter historyWriter = new BufferedWriter(new FileWriter(customerOrderHistoryFile))) 
                {
                    for (customer_order_history history : customerOrderHistoryList) 
                    {
                        String updatedHistory = String.format(
                            "%s,%s,%s,%s,%.2f,%.2f,%s,%s,%s,%s",
                            history.getOrder_id(), history.getItem_name(), history.getUser_id(), history.getTime(),
                            history.getOrder_amount(), history.getCurrent_balance(), history.getAddress(),
                            history.getOrder_type(), history.getVendor_name(), history.getOrder_status()
                        );
                        historyWriter.write(updatedHistory);
                        historyWriter.newLine();
                    }
                }
            }            
            
            System.out.println("Top up successful, new balance :" + newBalance);
            return true; // top up successful
            
        }
        catch (IOException e)
        {
            return false; // top up failed
        }
    }   

    // 4. transaction receipt of all the occurences (DONE)
    // will be a method that returns a list of wallet objects corresponding tot hte transactions for a given userID
    public List<wallet> getUserTransactions(String userID, String walletFile) throws IOException
    {
        // an array to store the user transaction of the chosen user id
        List<wallet> userTransactions = new ArrayList<>();
        try
        {
            ArrayList<wallet> walletList = dataloader.loadwallet(walletFile);
            
            // filter transactions for the given user id
            for (wallet w : walletList)
            {
                if (w.getUser_id().equals(userID))
                {
                    userTransactions.add(w); // add it to the array for that user
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading walletfile: " + e.getMessage());
        }
        return userTransactions;
    }
    
    // 5. update user balance upon cancellation
    
    public boolean updateBalance (String userID, String walletFile, String topUpFile, String customerOrderHistoryFile)
    {
        try 
        {
            ArrayList<wallet> walletList = dataloader.loadwallet(walletFile);
            ArrayList<top_up> topUpList = dataloader.loadtopups(topUpFile);
            ArrayList<customer_order_history> customerOrderHistoryList = dataloader.loadcustomerorderhistory(customerOrderHistoryFile);
        
             // Check if there is a "cancelled" notification for the user in top_up.txt
            top_up cancelledTopUp = null;
            for (top_up t : topUpList) 
            {
                if (t.getUser_id().equals(userID) && t.getNotification().equalsIgnoreCase("cancelled")) 
                {
                    cancelledTopUp = t;
                    break;
                }    
            }
            
            if (cancelledTopUp == null) 
            {
                System.out.println("Error: No update balance request for user ID: " + userID);
                return false;
            }
            
            // Get the refund amount from the cancellation entry
            double refundAmount = cancelledTopUp.getAmount();
            
            // Find the user's current balance in wallet.txt
            double currentBalance = 0.0;
            for (wallet w : walletList) 
            {
                if (w.getUser_id().equals(userID)) 
                {
                    currentBalance = w.getCurrent_balance(); // Get the last recorded balance
                }
            }
            
            // Calculate the new balance after refund
            double newBalance = currentBalance + refundAmount;

            // Generate a new transaction ID
            int lastTxnId = 0;
            for (wallet w : walletList) 
            {
                if (w.getTransaction_id().startsWith("txn")) 
                {
                    try 
                    {
                        int txnId = Integer.parseInt(w.getTransaction_id().substring(3));
                        lastTxnId = Math.max(lastTxnId, txnId);
                    } 
                    catch (NumberFormatException e) 
                    {
                    // Ignore invalid transaction IDs
                    }
                }
            }
            String transactionID = "txn" + (lastTxnId + 1);
            
            // Append the new transaction to wallet.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(walletFile, true))) 
            {
                String newTransaction = String.format("%s,%.2f,%s,updated,%.2f,none", userID, refundAmount, transactionID, newBalance);
                writer.write(newTransaction);
                writer.newLine();
            }
            
            // Update the notification in top_up.txt to reflect the processed cancellation
            try (BufferedWriter topupWriter = new BufferedWriter(new FileWriter(topUpFile))) 
            {
                for (top_up t : topUpList) 
                {
                    if (t.getUser_id().equals(userID) && t.getNotification().equalsIgnoreCase("cancelled")) 
                    {
                        t.setNotification("refunded"); // Update notification to indicate the refund is processed
                    }
                    String updatedEntry = String.format("%s,%s,%.2f", t.getUser_id(), t.getNotification(), t.getAmount());
                    topupWriter.write(updatedEntry);
                    topupWriter.newLine();
                }
            }
            
            // now im updating the customer_order_history.txt
            int lastIndex = -1;
            for (int i = 0; i < customerOrderHistoryList.size(); i++) 
            {
                if (customerOrderHistoryList.get(i).getUser_id().equals(userID)) 
                {
                    lastIndex = i; // Track the last occurrence of the user_id
                }
            }        
            
            if (lastIndex != -1) 
            {
                customerOrderHistoryList.get(lastIndex).setCurrent_balance(newBalance);

                // Rewrite customer_order_history.txt
                try (BufferedWriter historyWriter = new BufferedWriter(new FileWriter(customerOrderHistoryFile))) 
                {
                    for (customer_order_history history : customerOrderHistoryList) 
                    {
                        String updatedHistory = String.format(
                        "%s,%s,%s,%s,%.2f,%.2f,%s,%s,%s,%s",
                        history.getOrder_id(), history.getItem_name(), history.getUser_id(), history.getTime(),
                        history.getOrder_amount(), history.getCurrent_balance(), history.getAddress(),
                        history.getOrder_type(), history.getVendor_name(), history.getOrder_status()
                        );
                        historyWriter.write(updatedHistory);
                        historyWriter.newLine();
                    }
                }
            }
            
            System.out.println("Cancellation processed successfully. New balance: " + newBalance);
            return true;
        }
        
        catch (IOException e)
        {
            System.err.println("Error processing cancellation: " + e.getMessage());
            return false;
        }
    }
    
    
    
    
}

