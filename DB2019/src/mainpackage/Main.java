package mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {


    
	public static void main(String[] args) {
		Connection c = null;
	    PreparedStatement pstmt= null;
	    ResultSet rs = null;
	    
	    try {
	    	String user = "postgres";
			String password = "Geomimo99";
			String url = "jdbc:postgresql://localhost:5432/TicketService";
			
			c = DriverManager.getConnection(url, user, password);
			System.out.println("Opened Database Successfully!");
			
			Scanner inp = new Scanner(System.in);
			boolean f = true;
			do {
				System.out.println("Choose action:\n"
						+ "A: Average Sales per Category.\n"
						+ "B: Top Show (not functional).\n"
						+ "C: Tickets Sold Until Today (not functional)");
				switch(inp.next()) {
				case("A"):
					f = false;
					break;
				case("B"):
					break;
				case("C"):
					break;
				}
			}while(f);
			
			String sql = "select category, round(avg(price*ticket_num),3) as avgSales\r\n" + 
					"from tickets inner join (\r\n" + 
					"	select ticket_id, ticket_num\r\n" + 
					"	from customers inner join transactions on id = cust_id\r\n" + 
					"	where age between ? and ?\r\n" + 
					") as rng on ticket_id = id\r\n" + 
					"group by category";
			
			pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, 16);
			pstmt.setInt(2, 44);
			
			rs = pstmt.executeQuery();
			
			String spaces = " ".repeat(15);
			System.out.println("Category" + spaces + "AvgSales");
			System.out.println("-------------------------------");
			while(rs.next()) {
				String category = rs.getString("category");
				float avgSales = rs.getFloat("avgSales");
			
				spaces = " ".repeat(15 + ("Category".length() - category.length()));
				String output = category + spaces + avgSales;
				System.out.println(output);
			}
			
	    } catch (SQLException ex) {
	    	System.out.println(ex);
	    } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                	pstmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
            	System.out.println(ex);
            }
        }
	}
}
