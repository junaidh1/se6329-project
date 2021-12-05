import java.sql.*;
import java.util.ArrayList;

public class Menu {
	
    private int menuID;
    private int restaurantID;
    private String description;
    private int itemID;
    private String itemName;
    

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
    
	
	public ArrayList<Menu> getMenuList(int rid) {
		String QUERY = "SELECT * FROM Menu WHERE rid = " + rid;
		ArrayList<Menu> menus = new ArrayList<Menu>();
		try(Connection conn = DriverManager.getConnection(Configurations.DB_URL, Configurations.USER, Configurations.PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);) {
		         while (rs.next()) {
		        	Menu menu = new Menu();
		        	menu.setMenuID(rs.getInt("id"));
		        	menu.setRestaurantID(rid);
		        	menu.setDescription(rs.getString("description"));
		        	menu.setItemID(rs.getInt("itemId"));
		        	menu.setItemName(rs.getString("itemName"));	 
		        	menus.add(menu);
		         }
		         conn.close();
		      } catch (SQLException e) {
		         e.printStackTrace();
		 }
		return menus;
		
	}

}
