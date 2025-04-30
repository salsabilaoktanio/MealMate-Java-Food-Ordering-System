/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_assignment;

import java.io.*;
import java.util.*;

public class users {
    private String user_id;
    private String user_pswd;
    private String user_role;
    private String user_name;
    
    // constructors
    public users(String user_id, String user_pswd, String user_role, String user_name) {
        this.user_id = user_id;
        this.user_pswd = user_pswd;
        this.user_role = user_role;
        this.user_name = user_name;
    }    
 
    // Default Constructor
    public users() {
        // Initialize fields with default values if needed
        this.user_id = "";
        this.user_pswd = "";
        this.user_role = "";
        this.user_name = "";
    }    
  
    
    // getter and setter

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pswd() {
        return user_pswd;
    }
    public void setUser_pswd(String user_pswd) {
        this.user_pswd = user_pswd;
    }

    public String getUser_role() {
        return user_role;
    }
    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    // loading the users from file

    
    // the actual login function
    // user_id and user_pswd = data in the txt
    // chosen_id and chosen_pswd = what the user inputs
    public static users login (String chosen_id, String chosen_pswd, ArrayList<users> userList ) 
    {
        for (users user : userList)
        {
            if (user.getUser_id().equalsIgnoreCase(chosen_id)&& 
                user.getUser_pswd().equalsIgnoreCase(chosen_pswd)) 
            {
                return user; // login successful
            }
        }
        return null; // login failed
    }
    
}
