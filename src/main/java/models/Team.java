package models;

import java.util.ArrayList;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//to ask hassan can we put the team class as an attribute in class club
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Team {

	String name;
	ArrayList<Player> players; 
	
	public Team(){}
	public Team(String name){
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String team="";
		team = name;//to do11111111111111111111111111111111111111111111111111111111111111111111111111111111111
		return team;
	}
}
