package spree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Finance {

	private int balance;
	static Connection currentCon = null; 
    static ResultSet rs = null;
	public Finance(int amountToBePaid) {
		this.balance = amountToBePaid;
	}

	public void removeBalance(int amount) {
		this.setBalance(balance - amount);
	}

	public void addBalance(int amount) {
		this.setBalance(balance + amount);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public static void updateFinance(int amount){
		String query = "SELECT account FROM admin";
		Statement stmt = null;
		int balance = 0;
		String updateFinance = "update admin set account = ? where id = 1";
		
		
		//connect to DB
		currentCon = ConnectionManager.getConnection(); 
		try {
			PreparedStatement preparedStatement = currentCon.prepareStatement(updateFinance);
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
			balance = rs.getInt("account");
    		preparedStatement.setInt(1, balance + amount);
    		preparedStatement.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String...strings){
		Finance.updateFinance(1500);
	}
}