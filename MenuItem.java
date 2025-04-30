package final_assignment;

public class MenuItem {
    private String vendor_id;
    private String vendor_name;
    private String item_id;
    private String item_name;
    private double item_price; // Change this to double

    // Constructor
    public MenuItem(String vendor_id, String vendor_name, String item_id, String item_name, double item_price) {
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    // Getters
    public String getVendor_id() {
        return vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public double getItem_price() { // Getter for item_price as double
        return item_price;
    }

    // Setters
    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(double item_price) { // Setter for item_price as double
        this.item_price = item_price;
    }
}
