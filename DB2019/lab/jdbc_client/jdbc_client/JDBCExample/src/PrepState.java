import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrepState {

	public static void main(String[] args) {
        Connection c = null;
        PreparedStatement prepared_stmt= null;
        ResultSet rs = null;
        
        try {

        	
        	String user = "postgres";
    		String password = "Geomimo99";
    		String url = "jdbc:postgresql://localhost:5432/Ticket-Service-DB";
            //Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection(url, user, password);

            System.out.println("Opened database successfully");
            //String data="Ramesh";

            int data= 20;

            String sql = "select category, round(avg(price*ticket_num),3) as avgSales\n" + 
            		"from (\n" + 
            		"	select ticket_id, ticket_num\n" + 
            		"	from customers, transactions \n" + 
            		"	where (id = cust_id and age between ? and ?)\n" + 
            		") as cust \n" + 
            		"inner join tickets on tickets.id = ticket_id\n" + 
            		"group by category";

            prepared_stmt = c.prepareStatement(sql);

            prepared_stmt.setInt(1, 16);
            prepared_stmt.setInt(2, 44);
            
            rs = prepared_stmt.executeQuery();
            while ( rs.next() ) {
                String category = rs.getString("category");
                float avg = rs.getFloat("avgSales");
                //String address = rs.getString("address");
                //String  salary = rs.getString("salary");
                
                System.out.println(  category );
                System.out.println(  avg );
               // System.out.println(  address );
               // System.out.println(  salary );
               
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrepState.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prepared_stmt != null) {
                    prepared_stmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PrepState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		
	}

}
