package final_assignment;

//imports
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class review {
    //attributes
    private String review_id;
    private String order_id;
    private String user_id;
    private String vendor_name;
    private String vendor_review;
    private String runner_name;
    private String runner_review;

    //constructor
    public review(String review_id, String order_id, String user_id, String vendor_name, String vendor_review, String runner_name, String runner_review) {
        this.review_id = review_id;
        this.order_id = order_id;
        this.user_id = user_id;
        this.vendor_name = vendor_name;
        this.vendor_review = vendor_review;
        this.runner_name = runner_name;
        this.runner_review = runner_review;
    }

    // Getters
    public String getReview_id() {
        return review_id;
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

    public String getVendor_review() {
        return vendor_review;
    }

    public String getRunner_name() {
        return runner_name;
    }

    public String getRunner_review() {
        return runner_review;
    }

    // Setters
    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public void setVendor_review(String vendor_review) {
        this.vendor_review = vendor_review;
    }

    public void setRunner_name(String runner_name) {
        this.runner_name = runner_name;
    }

    public void setRunner_review(String runner_review) {
        this.runner_review = runner_review;
    }
    
    //review id generator
    public static String generatereviewID() {
        Random random = new Random();
        String firstNumber = String.valueOf(100 + random.nextInt(900)); 
        String secondNumber = String.valueOf(100 + random.nextInt(900));
        return "r" + firstNumber + secondNumber;
    }
    
    //writing a review
    public static void writeReview(String review_id, String order_id, String customer_id,String vendor_name, String vendor_review, String runner_name, String runner_review) {
        String review = review_id + "," + order_id + "," + customer_id + "," + vendor_name + "," + vendor_review + "," + runner_name + "," + runner_review;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("review.txt", true))) {
            bw.write(review);
            bw.newLine();
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
}
