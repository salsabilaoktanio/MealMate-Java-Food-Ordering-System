/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suhanashabhik
 */
public class TaskUtils {
        // Method 1: Update Table
    public static void updateTable(List<String[]> taskList, JTable table) {
        String[] columnNames = {"Task ID", "Order ID", "User ID", "Address", "Status", "Earning", "Date"};
        String[][] data = new String[taskList.size()][columnNames.length];
        for (int i = 0; i < taskList.size(); i++) {
            data[i] = taskList.get(i);
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table.setModel(model);
    }

    // Method 2: Update Task Status
    public static void updateTaskStatus(String filePath, String taskId, String newStatus) {
        List<String> updatedTasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] taskDetails = line.split(",");
                if (taskDetails[0].equals(taskId)) {
                    taskDetails[4] = newStatus;
                }
                updatedTasks.add(String.join(",", taskDetails));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String task : updatedTasks) {
                bw.write(task);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to the file: " + e.getMessage());
        }
    }

    // Method 3: Show Completed Tasks
    public static List<String[]> getCompletedTasks(String filePath) {
        List<String[]> completedTasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",");
                if (taskData[4].trim().equalsIgnoreCase("completed")) {
                    completedTasks.add(taskData);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading tasks file: " + e.getMessage());
        }
        return completedTasks;
    }

    // Method 4: Load Review Data
    public static List<String[]> loadReviewData(String filePath) {
        List<String[]> reviewData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reviewData.add(line.split(","));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading reviews file: " + e.getMessage());
        }
        return reviewData;
    }
    
}
