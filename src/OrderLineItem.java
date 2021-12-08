
public class OrderLineItem {
	private String orderLineItemId;
	private String orderId;
	private int itemId;
	private String name;
	private int qty;
	private double total;
	
	public String getOrderLineItemId() {
        return orderLineItemId;
    }

    public void setOrderLineItemId(String orderLineItemId) {
        this.orderLineItemId = orderLineItemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
