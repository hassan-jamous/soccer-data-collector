package models;

public class TransferPlayerInformation {

	public Player playerBasicInfo;
	public String date;
	public String playerNation;
	public String playerPosition;
	public String fromClub;
	public String toClub;
	
	
	public TransferPlayerInformation() {
		playerBasicInfo = new Player();
	}
	public TransferPlayerInformation( String date, String playerName, String playerNation ,
	 String position,  String fromClub, String toClub) {
		 this.playerBasicInfo = new Player();
		 this.playerBasicInfo.name =playerName;
		 this.date = date;
		 this.playerNation= playerNation;
		 this.playerPosition = position;
		 this.fromClub = fromClub;
		 this.toClub = toClub;
	}
	public String toString() {
		String result="";
		result = date + "  " + playerBasicInfo.name + "  " + playerNation + "  " + playerPosition + "  From  "
		+ fromClub + " TO " + toClub; 
		return result;
	}
	
}
