package models;



public class PlayerPersonalInformation {

	public Player playerBasicInfo;
	public String fullName;
	public String born;
	public String birthPlace;
	public String nationality;//or array
	public String height;
	public String weight;
	public String positions;//or array
	public String foot;
	
	public PlayerPersonalInformation() {
		playerBasicInfo = new Player();
	}
	public PlayerPersonalInformation(String name , String fullName , String birthDate , String birthPlace , String nationality
			,String height ,  String weight , String position , String foot) {
		this();
		this.playerBasicInfo.name = name;
		this.fullName = fullName;
		this.born = birthDate;
		this.birthPlace = birthPlace;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
		this.positions = position;
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
