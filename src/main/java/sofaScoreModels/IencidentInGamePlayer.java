package sofaScoreModels;

//remove _Goal from the name
public class IencidentInGamePlayer {
	public String name;
	public String slug;
	public String shortName;
	public String position;
	public String userCount;//
	public String id;
	
	public IencidentInGamePlayer() {}
	public String toString() {
		String result ="";
		result = name + "    at (" + position + ")";
		return result;
	}

}
