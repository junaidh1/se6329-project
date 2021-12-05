import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Item {
	
    private int itemID;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private int itemStock;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }
    
	public Item getItem(String name) {
		String QUERY = "SELECT * FROM Item WHERE name = '" + name + "'";
		ArrayList<Item> items = new ArrayList<Item>();
		try(Connection conn = DriverManager.getConnection(Configurations.DB_URL, Configurations.USER, Configurations.PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);) {
		         while (rs.next()) {
		        	Item item = new Item();
		        	item.setItemID(rs.getInt("id"));
		        	item.setItemName(rs.getString("name"));
		        	item.setItemPrice(rs.getDouble("price"));
		        	item.setItemStock(rs.getInt("stock"));
		        	item.setItemDescription(rs.getString("description"));	 
		        	items.add(item);
		         }
		         conn.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		 }
		return items.get(0);
	}
    
}
