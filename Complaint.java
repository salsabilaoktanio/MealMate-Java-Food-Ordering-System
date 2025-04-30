package final_assignment;

//imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Complaint extends review{
    //attributes
    private String complaint_status;

    //constructor
    public Complaint(String complain_id, String order_id, String user_id, String vendor_name,
                     String vendor_complaint, String runner_name, String runner_complaint, 
                     String complaint_status) {
        super(complain_id, order_id, user_id, vendor_name, vendor_complaint, runner_name, runner_complaint);
        this.complaint_status = complaint_status;
    }

    //getter
    public String getComplaint_status() {
        return complaint_status;
    }

    //setter for complaint status
    public void setComplaint_status(String complaint_status) {
        this.complaint_status = complaint_status;
    }
    
    //complaint id generator
    public static String generatecomplaintID() {
        Random random = new Random();
        String firstNumber = String.valueOf(100 + random.nextInt(900)); 
        String secondNumber = String.valueOf(100 + random.nextInt(900));
        return "c" + firstNumber + secondNumber;
    }
    
    //writing into complaint.txt
    public static void writeComplaintToFile(String complain_id, String order_id, String customer_id, String vendor_name, String vendor_complaint, String runner_name, String runner_complaint, 
                                     String complaint_status) {
        String complaint = complain_id + "," + order_id + "," + customer_id + "," + vendor_name + "," + vendor_complaint + "," + runner_name + "," + runner_complaint + "," + complaint_status;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("complains.txt", true))) {
            bw.write(complaint);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
}
