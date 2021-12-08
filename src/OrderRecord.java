import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OrderRecord {
	
	public void createOrder(Order order) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(Configurations.DB_URL, Configurations.USER, Configurations.PASS);
			
			String insertOrderQuery = "INSERT INTO CometEats.Order (id, total, isComplete, createAt) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmtOrder = conn.prepareStatement(insertOrderQuery);
		    String ouuid = UUID.randomUUID().toString().replace("-", "");
			
			String insertLineItemsQuery = "INSERT INTO CometEats.OrderLineItem (id, orderId, itemId, name, qty, total) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmtLineItems = conn.prepareStatement(insertLineItemsQuery);
		    
		    String queryItemsQuery = "SELECT * FROM CometEats.Item WHERE id=?";
			PreparedStatement pstmtQItems = conn.prepareStatement(queryItemsQuery);
		    
		    String updateItemsQuery = "UPDATE CometEats.Item SET stock=? WHERE id=?";
			PreparedStatement pstmtUItems = conn.prepareStatement(updateItemsQuery);
		    
            conn.setAutoCommit(false);

            pstmtOrder.setString(1, ouuid);
            pstmtOrder.setDouble(2, order.getTotal());
            pstmtOrder.setInt(3, 0);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            pstmtOrder.setString(4, formatter.format(date));
            
            pstmtOrder.executeUpdate();

            for (int i = 0; i < order.getItems().size(); i++) {
            	String oliuuid = UUID.randomUUID().toString().replace("-", "");
            	pstmtLineItems.setString(1, oliuuid);
            	pstmtLineItems.setString(2, ouuid);
                pstmtLineItems.setInt(3, order.getItems().get(i).getItemId());
                pstmtLineItems.setString(4, order.getItems().get(i).getName());
                pstmtLineItems.setInt(5, order.getItems().get(i).getQty());
                pstmtLineItems.setDouble(6, order.getItems().get(i).getTotal());
                pstmtLineItems.executeUpdate();
                
                pstmtQItems.setInt(1, order.getItems().get(i).getItemId());
                ResultSet rs = pstmtQItems.executeQuery();
                
                while(rs.next()) {
                	pstmtUItems.setInt(1, rs.getInt("stock") - order.getItems().get(i).getQty());
                    pstmtUItems.setInt(2, order.getItems().get(i).getItemId());
                    pstmtUItems.executeUpdate();
                }
              
            }        

            conn.commit();
            conn.setAutoCommit(true);
		    
			conn.close();
			System.out.println("Order checked out successfully ...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateOrder(Order order) {
		
	}

}
