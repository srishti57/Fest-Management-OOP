package spree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckDuplicateEntry {
	static Connection currentCon = null; 
    static ResultSet rs = null;

	public static boolean CheckDuplicateUsername(String name){
	    Statement stmt = null;
		//connect to DB
		currentCon = ConnectionManager.getConnection(); 
		try {
			stmt=currentCon.createStatement();
			String query1 = "SELECT * FROM participant where username = '"+name+"'";
			rs = stmt.executeQuery(query1);
			if(rs.next()) {
				return true;
			}else
				return false;
		} catch (SQLException e) {
//			System.out.println("SQLException");
//			return true;
			e.printStackTrace();
			return true;
		}

	}
//	public static void main(String ...strings ){
//		System.out.println(CheckDuplicateUsername("participant1"));
//	}
}
