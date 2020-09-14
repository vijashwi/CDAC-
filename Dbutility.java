package src.com.in.squad.khanakhaza.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutility {

	static Connection con=null;
	
	public static Connection getcon() {
		
		
		try {
			if(con==null) {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/khanakhazana","root","root");
			return con;
			}
			else
			{
			return con;	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
