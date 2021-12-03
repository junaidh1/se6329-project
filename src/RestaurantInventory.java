
public class RestaurantInventory {
	
	private String [] restaurantList = {"Jason's Deli", "BookStore Coffee Shop", "IHOP"};
	
	private String [][] restaurants = {{"Jason's Deli",
		      "Jason’s Deli is all about fresh food and premium, natural\n"
			+ "ingredients. As the first major restaurant concept to ban\n"
			+ "artificial trans fats and high fructose corn syrup in the U.S.,\n"
			+ "Jason’s Deli is honored to serve you fresh, wholesome choices.\n",
			  "Timing: Everyday 8AM-6PM",
			  "IHOP"},
			{"Mitha Alshammari", "456 Mitha Street, Allen, TX", "mitha.alhammari@utdallas.edu"},
			{"Junaid Hashmi", "789 Hashmi Street, Richardson, TX", "junaid.hashmi@utdallas.edu"},
			{"Zilong Wong", "1000 Wong Way, McKinney, TX", "zilong.wong@utdallas.edu"}};
	
	RestaurantInventory() {
	System.out.println("BrowseRestaurant Class was called.");
	}
	
	public int getRestaurantList() {
		System.out.println("I would display a numbered list of all restaurants at UTD campus.");
		System.out.println("I would ask customer to select one of them, or select 0 to exit");
		return 0;
	}
}
