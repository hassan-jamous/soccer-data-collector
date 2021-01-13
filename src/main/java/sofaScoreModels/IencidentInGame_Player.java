package sofaScoreModels;

//remove _Goal from the name
public class IencidentInGame_Player {

	public String firstName;
	public String id;
	public String lastName;
	public String name;
	public String position;
	public String slug;
	public String shortName;
	public String userCount;//
	
	public IencidentInGame_Player() {}
	public IencidentInGame_Player(String playerName ,String playerFirstName,String playerLastName , String playerSlug , String playerShortName , String  playerPosition ,
			String playerUserCount , String playerId) {
		this.id = playerId;
		this.name = playerName;
		this.firstName = playerFirstName;
		this.position = playerPosition;
		this.shortName = playerShortName;
		this.slug = playerSlug;
		this.userCount = playerUserCount;
		this.lastName = playerLastName;
	}

	public String toString() {
		String result ="";
		result = name + "    at (" + position + ")";
		return result;
	}

}
