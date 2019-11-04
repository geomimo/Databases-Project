import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

	public static void main(String[] args) {
		
		Connection c = null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
        	Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:Ticket-Service-DB://127.0.0.1:62515/",
                            "postgres", "Geomimo99");
            
            System.out.println("Opened database successfully");
            
            stmt = c.createStatement();
            
            System.out.println("Create statement successfully");
                        
            //String data="Ramesh";
            //stmt.execute("set standard_conforming_strings = off");
            String data=" den me noiazei\\' OR 1=1 --' ";

            String sql=" SELECT * FROM customers WHERE name=?";
            
            System.out.println(sql);
            
            rs = stmt.executeQuery(sql);
            
            while ( rs.next() ) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String  age = rs.getString(3);
                String address = rs.getString(4);
                String  salary = rs.getString(5);

                System.out.println(  id );
                System.out.println(  name );
                System.out.println(  age );
                System.out.println(  address );
                System.out.println(  salary );
                System.out.println();

            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
        	Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		
	}

}

/*
 * 
 CREATE TABLE CUSTOMERS(
   ID   INT              NOT NULL,
   NAME VARCHAR (20)     NOT NULL,
   AGE  INT              NOT NULL,
   ADDRESS  CHAR (25) ,
   SALARY   DECIMAL (18, 2),       
   PRIMARY KEY (ID)
	);
	


INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (1, 'Ramesh', 32, 'Ahmedabad', 2000.00 );

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (2, 'Khilan', 25, 'Delhi', 1500.00 );

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (3, 'kaushik', 23, 'Kota', 2000.00 );

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (4, 'Chaitali', 25, 'Mumbai', 6500.00 );

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (5, 'Hardik', 27, 'Bhopal', 8500.00 );

INSERT INTO CUSTOMERS (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (6, 'Komal', 22, 'MP', 4500.00 );
 */

