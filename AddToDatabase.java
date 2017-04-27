package spree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddToDatabase {
	static Connection currentCon = null; 
    static ResultSet rs = null;

	public static int AddToParticipantsDB(Participant p){
		Statement stmt = null;
		int id = 0;
    	try {
    		
    		String query = "SELECT id FROM studentdetail order by id desc;";
    		//connect to DB
    		currentCon = ConnectionManager.getConnection(); 
    		stmt=currentCon.createStatement();
    		rs = stmt.executeQuery(query);
    		if(rs.next()) {
    		id = rs.getInt("id");
    		id++;
    		System.out.println(id);
    		}
    		String addToStudentDetails = "INSERT INTO studentdetail (id,studentID,studentName,collegeName,email) VALUES"
    				+ "("+id+",?,?,?,?)";
    		PreparedStatement preparedStatement = currentCon.prepareStatement(addToStudentDetails);
    		preparedStatement.setString(1, p.getDetails().getStudentID());
    		preparedStatement.setString(2, p.getDetails().getStudentName());
    		preparedStatement.setString(3, p.getDetails().getCollegeName());
    		preparedStatement.setString(4, p.getDetails().getEmail());
    		preparedStatement.executeUpdate();
    		/**
    		 * event,team,fixture id need to be filled
    		 */
    		String query1 = "SELECT id FROM participant order by id desc;";
    		rs = stmt.executeQuery(query1);
    		if(rs.next()) {
    		id = rs.getInt("id");
    		id++;
    		System.out.println(id);
    		}
    		String addToParticipant = "INSERT INTO participant (id,username,password,details)"
    				+ "VALUES("+id+",?,?,?)";
    		preparedStatement = currentCon.prepareStatement(addToParticipant);
    		preparedStatement.setString(1, p.getUsername());
    		preparedStatement.setString(2, p.getPassword());
    		preparedStatement.setInt(3, id);
    		preparedStatement.executeUpdate();
    		return id;

        }
        catch (Exception ex) {
            System.out.println("12Log In failed: An Exception has occurred! " + ex);
            return id;
        }finally{
        	try {
				stmt.close();
				currentCon.close();
			} catch (SQLException e) {
				System.out.println("SQL Exception");
			}
        	
        }
	}
	public static void AddToTeamDB(int sport, String teamName,String collegeName, int participantKey) {
		Statement stmt = null;
		int id = 0,teamid = 0;
    	try {
    		
    		String query = "SELECT id FROM team order by id desc;";
    		//connect to DB
    		currentCon = ConnectionManager.getConnection(); 
    		stmt=currentCon.createStatement();
    		rs = stmt.executeQuery(query);
    		if(rs.next()) {
    		teamid = rs.getInt("id");
    		teamid++;
    		System.out.println(teamid);
    		}
    		String addToTeam = "INSERT INTO team (id,sport,teamHead,teamName,collegeName) VALUES"
    				+ "("+teamid+",?,?,?,?)";
    		PreparedStatement preparedStatement = currentCon.prepareStatement(addToTeam);
    		preparedStatement.setInt(1, sport);
    		preparedStatement.setInt(2, participantKey);
    		preparedStatement.setString(4, collegeName);
    		preparedStatement.setString(3, teamName);
    		preparedStatement.executeUpdate();
    		/**
    		 * event,team,fixture id need to be filled
    		 */
    		String query1 = "SELECT id FROM sport_team order by id desc;";
    		rs = stmt.executeQuery(query1);
    		if(rs.next()) {
    		id = rs.getInt("id");
    		id++;
    		System.out.println(id);
    		}
    		String addTosport_team = "INSERT INTO sport_team (id,sportid,teamid)"
    				+ "VALUES("+id+",?,?)";
    		preparedStatement = currentCon.prepareStatement(addTosport_team);
    		preparedStatement.setInt(1, sport);
    		preparedStatement.setInt(2, teamid);
    		preparedStatement.executeUpdate();
    		String updateToParticipant = "update participant set team = ? where id = ?";
    		preparedStatement = currentCon.prepareStatement(updateToParticipant);
    		preparedStatement.setInt(1, teamid);
    		preparedStatement.setInt(2, participantKey);
    		preparedStatement.executeUpdate();

        }
        catch (Exception ex) {
            System.out.println("123Log In failed: An Exception has occurred! " + ex);
        }	
	}
	
//	public static void main(String ... args){
//		StudentDetail s = new StudentDetail("749", "Mandar", "BITS", "f2012749@gmail.com");
//		Participant p = new Participant("mandar", "mandar", s, null, null, null, false);
//		AddToParticipantsDB(p);
//	}
}
