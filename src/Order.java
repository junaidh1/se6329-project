import java.util.ArrayList;
import java.util.Date;

public class Order {
	private String orderID;
	private boolean isComplete = false;
	private double total = 0.0;
	private Date date;
	private ArrayList<OrderLineItem> items = new ArrayList<OrderLineItem>();
	

public String getOrderID() {
    return orderID;
}

public void setOrderID(String orderID) {
    this.orderID = orderID;
}

public Boolean getIsComplete() {
    return isComplete;
}

public void setIsComplete(boolean isComplete) {
    this.isComplete = isComplete;
}

public double getTotal() {
    return total;
}

public void setTotal(double total) {
    this.total = total;
}

public Date getDate() {
    return date;
}

public void setDate(Date date) {
    this.date = date;
}

public ArrayList<OrderLineItem> getItems() {
    return items;
}

public void setItems(ArrayList<OrderLineItem> items) {
    this.items = items;
}

public void addItem(int qty, Item item) {
	OrderLineItem oli = new OrderLineItem();
	oli.setItemId(item.getItemID());
	oli.setName(item.getItemName());
	oli.setQty(qty);
	oli.setTotal(qty * item.getItemPrice());
	items.add(oli);
	total += oli.getTotal();
}

}