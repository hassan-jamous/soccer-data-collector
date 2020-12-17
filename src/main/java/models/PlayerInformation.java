package models;

import java.util.ArrayList;

public class PlayerInformation {
	ArrayList <PlayerClubCareer> clubs;
	
	
	public PlayerInformation() {
		clubs = new ArrayList<>();
	}
	public String toString() {
		String result="";
		for(int i =0; i<clubs.size() ;i++) {
			result = result + clubs.get(i).toString();
		}
		return result;
	}
}
