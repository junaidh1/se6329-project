import java.util.Hashtable;

public class Customer {
	private Hashtable<String, Integer> customers = new Hashtable<String, Integer>();
	private String [][] customerRecords = {{"Miao Miao", "123 Miao Street, Richardson, TX", "miao.miao@utdallas.edu"},
			{"Mitha Alshammari", "456 Mitha Street, Allen, TX", "mitha.alhammari@utdallas.edu"},
			{"Junaid Hashmi", "789 Hashmi Street, Richardson, TX", "junaid.hashmi@utdallas.edu"},
			{"Zilong Wong", "1000 Wong Way, McKinney, TX", "zilong.wong@utdallas.edu"}};
	
	Customer() {
		initializeCustomerDB();
	}
	
	private void initializeCustomerDB() {
		customers.put("miao", 0);
		customers.put("mitha", 1);
		customers.put("junaid", 2);
		customers.put("zilong", 3);
	}
	
	public String getName(String userID) {
		Integer id = customers.get(userID);
		if (id < 0 || id > 4) {
			System.out.println("ERR: User " + userID + " not found in the CustomerDB");
			return null;
		}
		else {
			return customerRecords[id][0];
		}	
	}
}
