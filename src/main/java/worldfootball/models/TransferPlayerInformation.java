package worldfootball.models;

public class TransferPlayerInformation {

	public Player playerBasicInfo;
	public String date;
	public String playerNation;
	public String playerPosition;
	public Club fromClub;
	public Club toClub;
	
	
	public TransferPlayerInformation() {
		playerBasicInfo = new Player();
		fromClub = new Club();
		toClub = new Club();
	}
	public TransferPlayerInformation( String date, String playerName, String playerNation ,
	 String position,  String fromClub, String toClub) {
		 this();
		 this.playerBasicInfo.name =playerName;
		 this.date = date;
		 this.playerNation= playerNation;
		 this.playerPosition = position;
		 this.fromClub.name = fromClub;
		 this.toClub.name = toClub;
	}
	public String toString() {
		String result="";
		result = date + "  " + playerBasicInfo.name + "  " + playerNation + "  " + playerPosition + "  From  "
		+ fromClub.name + " TO " + toClub.name; 
		return result;
	}
	
}
