package models;

import java.util.ArrayList;

public class ClubTansferTable {

	public String clubName;
	public String season;
	public ArrayList <TransferPlayerInformation> transferPlayers;
	
	public ClubTansferTable() {
		transferPlayers = new ArrayList<>();
	}
	public ClubTansferTable(String clubName , String season ,  ArrayList <TransferPlayerInformation> transferPlayers) {
		this.clubName = clubName;
		this.season = season;
		this.transferPlayers = transferPlayers;
	}
	public String toString () {
		String result ="";
		result = clubName + "  " + season + "\n";
		for(int i=0 ; i<transferPlayers.size() ; i++) {
			if(transferPlayers.get(i).toClub.equals(clubName)) {
				result = result +" IN "+ transferPlayers.get(i).toString()+"\n";
			}
			else {
				result = result +" OUT "+ transferPlayers.get(i).toString()+"\n";
			}
		}
		return result;
	}
}
