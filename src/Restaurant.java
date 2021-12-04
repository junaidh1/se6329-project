
public class Restaurant {
	private int restaurantID;
	private String restaurantName;
	private String address;
	private int menuNumber;
	private String restaurantDescription;
	
	Restaurant() {}
	
	
    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMenuNumber(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }
    
    public int getRestaurantID() {
        return restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }
    
}
