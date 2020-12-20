package models;

public class TransferPlayerInformation {

	public String playerName;
	public String date;
	public String playerNation;
	public String playerPosition;
	public String fromClub;
	public String toClub;
	
	public TransferPlayerInformation() {}
	public TransferPlayerInformation(String playerName, String date, String playerNation ,
	 String position,  String fromClub, String toClub) {
		 this.playerName =playerName;
		 this.date = date;
		 this.playerNation= playerNation;
		 this.playerPosition = position;
		 this.fromClub = fromClub;
		 this.toClub = toClub;
	}
	public String toString() {
		String result="";
		result = date + "  " + playerName + "  " + playerNation + "  " + playerPosition + "  From  "
		+ fromClub + " TO " + toClub; 
		return result;
	}
}
