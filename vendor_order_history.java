package final_assignment;
public class vendor_order_history extends order{
    public vendor_order_history(String order_id, String user_id, String vendor_name, String item_name, double item_price, String order_type, String order_status, double total_bill, String Data_and_time, String Address) {
        super(order_id, user_id, vendor_name, item_name, item_price, order_type, order_status, total_bill, Data_and_time, Address);
    }    
}
