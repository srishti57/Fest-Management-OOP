package spree;
import java.util.ArrayList;

public class Team {

	public Team(ArrayList<Participant> participants, Sport sport,
			Participant teamHead, String teamName, String collegeName) {
		super();
		this.participants = participants;
		this.sport = sport;
		this.teamHead = teamHead;
		this.teamName = teamName;
		this.collegeName = collegeName;
	}
	public Team() {
		// do nothing
	}
	private ArrayList<Participant> participants;
	private Sport sport;
	private Participant teamHead;
	private String teamName;
	private String collegeName;

	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
	
	public void removeParticipant(Participant participant) {
		this.participants.remove(participant);
	}

//	public void updateStatistics() {
//		// TODO - implement Team.updateStatistics
//		throw new UnsupportedOperationException();
//	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Participant> participants) {
		this.participants = participants;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public Participant getTeamHead() {
		return teamHead;
	}

	public void setTeamHead(Participant teamHead) {
		this.teamHead = teamHead;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public static void main(String[] args){
//	Rule newRule = new Rule(20, 1, 10, 2, 16, "Description");
//	Sport cricket = new Sport("Cricket", null, newRule);
//	System.out.println(cricket.getSportName());
//	//Team MI = new Team(participants, sport, teamHead, teamName, collegeName);
	}

}