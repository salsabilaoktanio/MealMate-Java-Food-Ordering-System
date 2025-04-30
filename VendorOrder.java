package final_assignment;

public class VendorOrder {
    private String orderID;
    private String userID;
    private String vendorName;
    private String itemName;
    private double itemPrice;
    private String orderType;
    private String orderStatus;
    private double totalBill;
    private String dateTime;
    private String address;

    // Constructor
    public VendorOrder(String orderID, String userID, String vendorName, String itemName,
                       double itemPrice, String orderType, String orderStatus, 
                       double totalBill, String dateTime, String address) {
        this.orderID = orderID;
        this.userID = userID;
        this.vendorName = vendorName;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.totalBill = totalBill;
        this.dateTime = dateTime;
        this.address = address;
    }

    // Getters
    public String getOrderID() { return orderID; }
    public String getUserID() { return userID; }
    public String getVendorName() { return vendorName; }
    public String getItemName() { return itemName; }
    public double getItemPrice() { return itemPrice; }
    public String getOrderType() { return orderType; }
    public String getOrderStatus() { return orderStatus; }
    public double getTotalBill() { return totalBill; }
    public String getDateTime() { return dateTime; }
    public String getAddress() { return address; }
}
