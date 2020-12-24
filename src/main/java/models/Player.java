package models;


public class Player {

	public String name;

	public Player() {}
	public Player(String playerName) {
		this.name = playerName;
	}
	public String toString() {
		String result ="";
		result = name;
		return result;
	}
}
