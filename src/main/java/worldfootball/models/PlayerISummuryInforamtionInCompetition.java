package worldfootball.models;

public class PlayerISummuryInforamtionInCompetition {

	public Player playerInfo;
	public Club clubInfo;
	public String born;
	public String height;
	public String position;//or enum
	
	public PlayerISummuryInforamtionInCompetition() {
		playerInfo = new Player();
		clubInfo = new Club();
	}
	public PlayerISummuryInforamtionInCompetition(String playerName , String clubName , String born , String height , String position) {
		this();
		this.playerInfo.name = playerName;
		this.clubInfo.name = clubName;
		this.born = born;
		this.height = height;
		this.position = position;
	}

	public String toString() {
		String result ="";
		result = playerInfo.name + "  In Club  " + clubInfo.name + "   Born At  " + born + " His Height is " + height + " His Position is " + position;
		return result;
	}
}
