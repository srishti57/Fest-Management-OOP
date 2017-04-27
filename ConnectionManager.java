package spree;

import java.sql.*;

public class ConnectionManager {
    static Connection con;
    static String url;
    public static Connection getConnection() {
        try {
            //String url = "jdbc:mysql://" + "localhost/spree";
        	String url = "jdbc:mysql://localhost:3306/spree";
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection(url,"root","");
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                
            }
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return con;
        
    }
    
}