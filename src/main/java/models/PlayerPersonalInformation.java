package models;

import java.util.ArrayList;

public class PlayerPersonalInformation {

	public Player playerBasicInfo;
	public String fullName;
	public String born;
	public String birthPlace;
	public ArrayList<String> nationality;//there are many players have more than one nationality https://www.worldfootball.net/player_summary/che-adams/
	public String height;
	public String weight;
	public ArrayList<String> positions;//or array
	public String foot;
	
	public PlayerPersonalInformation() {
		playerBasicInfo = new Player();
		nationality = new ArrayList<String>();
		positions = new ArrayList<>();
	
	}
	public PlayerPersonalInformation(String name , String fullName , String birthDate , String birthPlace , ArrayList<String> nationality
			,String height ,  String weight ,ArrayList <String> positions , String foot) {
		this();
		this.playerBasicInfo.name = name;
		this.fullName = fullName;
		this.born = birthDate;
		this.birthPlace = birthPlace;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
		this.positions = positions;
		this.foot = foot;
		
	}
	
	public String toString() {
		String result ="";
		result = "Personal Information are \n"+
				playerBasicInfo.name + "\n" +
				fullName +"\n" +
				born + "\n" +
				birthPlace + "\n" +
				nationality + "\n" +
				height + "\n" +
				weight + "\n" +
				positions + "\n" +
				foot;
		return result;
	}
	
}
