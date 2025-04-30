package final_assignment;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EarningsCalculator {

    private static final String FILE_PATH = "tasks.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    // Parse the date from the task string
    private static Date parseDate(String dateStr) throws ParseException {
        return DATE_FORMAT.parse(dateStr);
    }

    // Method to calculate daily earnings
    public static Map<String, Double> calculateDailyEarnings() {
        Map<String, Double> dailyEarnings = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] taskDetails = line.split(",");
                String status = taskDetails[4].trim();
                double earning = Double.parseDouble(taskDetails[5].trim());
                String date = taskDetails[6].trim();

                // Include only tasks with relevant statuses
                if (status.equalsIgnoreCase("completed") || status.equalsIgnoreCase("delivered") || status.equalsIgnoreCase("accepted")) {
                    dailyEarnings.put(date, dailyEarnings.getOrDefault(date, 0.0) + earning);
                }
            }
                } catch (IOException | NumberFormatException  e) {
                    System.err.println("Error reading file: " + e.getMessage());
        }

        return dailyEarnings;
    }

    // Method to calculate monthly earnings
    public static Map<String, Double> calculateMonthlyEarnings() {
        Map<String, Double> monthlyEarnings = new HashMap<>();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM-yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] taskDetails = line.split(",");
                String status = taskDetails[4].trim();
                double earning = Double.parseDouble(taskDetails[5].trim());
                String date = taskDetails[6].trim();

                // Include only tasks with relevant statuses
                if (status.equalsIgnoreCase("completed") || status.equalsIgnoreCase("delivered") || status.equalsIgnoreCase("accepted")) {
                    Date parsedDate = parseDate(date);
                    String month = monthFormat.format(parsedDate);

                    monthlyEarnings.put(month, monthlyEarnings.getOrDefault(month, 0.0) + earning);
                }
            }
        } catch (IOException | ParseException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return monthlyEarnings;
    }

    // Method to calculate yearly earnings
    public static Map<String, Double> calculateYearlyEarnings() {
        Map<String, Double> yearlyEarnings = new HashMap<>();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] taskDetails = line.split(",");
                String status = taskDetails[4].trim();
                double earning = Double.parseDouble(taskDetails[5].trim());
                String date = taskDetails[6].trim();

                // Include only tasks with relevant statuses
                if (status.equalsIgnoreCase("completed")) {
                    Date parsedDate = parseDate(date);
                    String year = yearFormat.format(parsedDate);

                    yearlyEarnings.put(year, yearlyEarnings.getOrDefault(year, 0.0) + earning);
                }
            }
        } catch (IOException | ParseException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return yearlyEarnings;
    }
}