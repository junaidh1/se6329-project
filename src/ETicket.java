import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class ETicket {
	
	   private String id;
	   private String orderId;
	   private String description;
	   private int isComplete;


	   public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public int getIsComplete() {
	        return isComplete;
	    }

	    public void setIsComplete(int isComplete) {
	        this.isComplete = isComplete;
	    }
	    
	    public void createETicket(Order order) {
	    	Connection conn;
			try {
				conn = DriverManager.getConnection(Configurations.DB_URL, Configurations.USER, Configurations.PASS);
				
				String insertETicketQuery = "INSERT INTO CometEats.ETicket (id, orderId, description, isComplete) VALUES (?, ?, ?, ?)";
				PreparedStatement pstmtEticket = conn.prepareStatement(insertETicketQuery);
			    String euuid = UUID.randomUUID().toString().replace("-", "");
			    
			    String insertPaymentQuery = "INSERT INTO CometEats.Payment (id, etId, description, method, amount, createAt) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmtPayment = conn.prepareStatement(insertPaymentQuery);
			    String puuid = UUID.randomUUID().toString().replace("-", "");
				
			    String queryOrderQuery = "SELECT * FROM CometEats.Order WHERE id=?";
				PreparedStatement pstmtQOrder = conn.prepareStatement(queryOrderQuery);
			    
			    String updateOrderQuery = "UPDATE CometEats.Order SET isComplete=? WHERE id=?";
				PreparedStatement pstmtUOrder = conn.prepareStatement(updateOrderQuery);
			    
	            conn.setAutoCommit(false);

	            pstmtEticket.setString(1, euuid);
	            pstmtEticket.setString(2, order.getOrderID());
	            pstmtEticket.setString(3, "description for " + euuid);
	            pstmtEticket.setInt(4, 1);
	            
	            pstmtEticket.executeUpdate();

	            pstmtPayment.setString(1, puuid);
	            pstmtPayment.setString(2, euuid);
	            pstmtPayment.setString(3, "description for " + puuid);
	            pstmtPayment.setString(4, "Credit Card");
	            pstmtPayment.setDouble(5, order.getTotal());
	            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	            Date date = new Date(System.currentTimeMillis());
	            pstmtPayment.setString(6, formatter.format(date));
	            pstmtPayment.executeUpdate();
                
	            pstmtQOrder.setString(1, order.getOrderID());
                ResultSet rs = pstmtQOrder.executeQuery();
                
                while(rs.next()) {
                	pstmtUOrder.setInt(1, 1);
                	pstmtUOrder.setInt(2, rs.getInt("id"));
                	pstmtUOrder.executeUpdate();
                }

	            conn.commit();
	            conn.setAutoCommit(true);
			    
				conn.close();
				System.out.println("Order is paid successfully ...");
				
				System.out.println("ETicket Id : " + euuid);
				System.out.println("Payment method : " + "Credit card");
				System.out.println("Total : $" + order.getTotal());
				System.out.println("Create At : " + formatter.format(date));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
}
