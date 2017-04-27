package spree;
public class Rule {
	private int ageLimit;
	private int minNoOfPlayers;
	private int maxNoOfPlayers;
	private int minNoOfTeams;
	private int maxNoOfTeams;
	private String rulesDescription;
	
	public Rule(int ageLimit, int minNoOfPlayers, int maxNoOfPlayers,
			int minNoOfTeams, int maxNoOfTeams, String rulesDescription) {
		super();
		this.ageLimit = ageLimit;
		this.minNoOfPlayers = minNoOfPlayers;
		this.maxNoOfPlayers = maxNoOfPlayers;
		this.minNoOfTeams = minNoOfTeams;
		this.maxNoOfTeams = maxNoOfTeams;
		this.rulesDescription = rulesDescription;
	}
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	public int getMinNoOfPlayers() {
		return minNoOfPlayers;
	}
	public void setMinNoOfPlayers(int minNoOfPlayers) {
		this.minNoOfPlayers = minNoOfPlayers;
	}
	public int getMaxNoOfPlayers() {
		return maxNoOfPlayers;
	}
	public void setMaxNoOfPlayers(int maxNoOfPlayers) {
		this.maxNoOfPlayers = maxNoOfPlayers;
	}
	public int getMinNoOfTeams() {
		return minNoOfTeams;
	}
	public void setMinNoOfTeams(int minNoOfTeams) {
		this.minNoOfTeams = minNoOfTeams;
	}
	public int getMaxNoOfTeams() {
		return maxNoOfTeams;
	}
	public void setMaxNoOfTeams(int maxNoOfTeams) {
		this.maxNoOfTeams = maxNoOfTeams;
	}
	public String getRulesDescription() {
		return rulesDescription;
	}
	public void setRulesDescription(String rulesDescription) {
		this.rulesDescription = rulesDescription;
	}
//	public static void main(String[] args){
//		Rule newRule = new Rule(20, 1, 10, 2, 16, "Description");
//	}
}