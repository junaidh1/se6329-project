//import java.io.BufferedReader;
//import java.io.Console;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.*;

public class Controller {
	
	static String cname;
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		cname = login();
		
		if (cname != null)
			browseRestaurants();
		else
			System.out.println("Something went wrong...exiting.");
		
	}
	
	private static String login() {
		Login session = new Login();
		System.out.print("Enter Username: ");
		String uid = scn.nextLine();
		System.out.print("Enter Password: ");
		String pwd = scn.nextLine();
		//scn.close();
		if (session.validateCustomer(uid, pwd)) {
			Customer cDB = new Customer();
			cname = cDB.getName(uid);
			System.out.println("\nWelcome to CometsEat " + cname + "\n");
			return cname;
		}
		else
			return null;
	}

	private static void browseRestaurants() {
		System.out.print("Would you like to browse campus restaurants (y/n): ");
		String response = scn.nextLine();
	
		if (response.equals("y") || response.equals("Y")) {
			RestaurantInventory myRList = new RestaurantInventory();
			restaurantList = myRList.getRestaurantList();
			for (int i = 0; i < restaurantList.size(); i++) {
				String id=String.format("%d",restaurantList.get(i).getRestaurantID());
				String name = restaurantList.get(i).getRestaurantName();
				System.out.println(id + " : " + name);
	        }
			System.out.print("Please select a restaurant: (enter the restaurant id here)");
			int rid = Integer.valueOf(scn.nextLine());
			
			String id=String.format("%d",restaurantList.get(rid - 1).getRestaurantID());
			String name = restaurantList.get(rid - 1).getRestaurantName();
			String address = restaurantList.get(rid - 1).getAddress();
			String description = restaurantList.get(rid - 1).getRestaurantDescription();
			
			System.out.println(id + " : " + name);
			System.out.println(address);
			System.out.println(description);
			
			browseMenu(rid);
		}
	}
	
	private static void browseMenu(int rid) {
		System.out.print("Would you like to browse menu of this restaurant (y/n), press n return to restaurant list: ");
		String choice = scn.nextLine();
		if (choice.equals("y") || choice.equals("Y")) {
			Menu menu = new Menu();
			menuList = menu.getMenuList(rid);
			for (int i = 0; i < menuList.size(); i++) {
				String name = menuList.get(i).getItemName();
				System.out.println(name);
	        }
			System.out.print("Please select an item to browse description or press n return to restaurant list: (enter the item name here)");
			String name = scn.nextLine();
			
			if (name.equals("n") || name.equals("N")) {
				browseRestaurants();
			} else {
				browseItemDesc(name);
			}
		} else if (choice.equals("n") || choice.equals("N")) {
			browseRestaurants();
		}
	}
	
	private static void browseItemDesc(String name) {
		Item item = new Item();
		item = item.getItem(name);
		String idesc = item.getItemDescription();
		Double iprice = item.getItemPrice();
		
		System.out.println(name + " : " + idesc + " : " + "$" + iprice);
		System.out.print("Would you like to add this item to order(y/n), press n return to menu list: ");
		
		String choice = scn.nextLine();
		
		if (choice.equals("y") || choice.equals("Y")) {
			System.out.print("Please enter the quantity you want to purchase (current stock is " + item.getItemStock() + ")");
			int qty = Integer.valueOf(scn.nextLine());
			checkQty(qty, item);
		} else {
			browseMenu(menuList.get(0).getRestaurantID());
		}
	}
	
	private static void checkQty(int qty, Item item) {
		if (qty > item.getItemStock()) {
			System.out.println("Invalid quantity, quantity should be less than stock...");
			System.out.print("Please enter the quantity you want to purchase (current stock is " + item.getItemStock() + ")");
			qty = Integer.valueOf(scn.nextLine());
			checkQty(qty, item);
		} else {
			addItem(item.getItemID(), qty);
		}
	}
	
	
	private static void addItem(int id, int qty) {
		
	}


}
