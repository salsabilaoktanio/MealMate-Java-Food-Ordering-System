package final_assignment;

public class VendorPerformance {
    private String vendorName;
    private double totalRevenue;

    public VendorPerformance(String vendorName, double totalRevenue) {
        this.vendorName = vendorName;
        this.totalRevenue = totalRevenue;
    }

    public String getVendorName() {
        return vendorName;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void addRevenue(double amount) {
        this.totalRevenue += amount;
    }
}

