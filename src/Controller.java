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
	
	private static int browseRestaurants() {
		System.out.print("Would you like to browse campus restaurants (y/n): ");
		String response = scn.nextLine();
		if (response.equals("y") || response.equals("Y")) {
			RestaurantInventory myRList = new RestaurantInventory();
			return myRList.getRestaurantList();
		}
		return 0;
	}

}
