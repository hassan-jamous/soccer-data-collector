package worldfootball.models;

public class Club {
	public String name;
	
	public Club() {}

	public Club (String clubName) {
		this.name = clubName;
	}
	
	public String toString() {
		return name;
	}

}