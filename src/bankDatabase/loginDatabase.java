package bankDatabase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class loginDatabase {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			
			String url = "jdbc:mySQL://localhost:3306/atm_simulation";
			String username = "root";
			String password = "Thongminh2906";
			
			c = DriverManager.getConnection(url, username, password);
			
		} catch(SQLException e) {
			System.out.println(e);
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch(Exception e) {
			 e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
