package models;

import java.util.ArrayList;

public class RankingTable {
ArrayList <Club> table = new ArrayList<>();

public String toString() {
	String result ="";
	for(int i =0 ; i<table.size() ; i++) {
		result = result + table.get(i).toString();
	}
	return result;
}
public void addClub(Club club) {
	table.add(club);
}
}
