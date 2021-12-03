import java.util.Hashtable;
public class Login {

	private Hashtable<String, String> users = new Hashtable<String, String>();
	
	Login() {
		initialize();
	}
	
	private void initialize() {
		users.put("miao", "miao");
		users.put("mitha", "alshammari");
		users.put("junaid", "hashmi");
		users.put("zilong", "wong");
	}
	
	public boolean validateCustomer(String uid, String pwd) {
		if (users.get(uid) == null)
			return false;
		if (users.get(uid).equals(pwd))
			return true;
		else
			return false;
	}
	
	
	
}
