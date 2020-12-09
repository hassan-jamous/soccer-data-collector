package collector;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
public class Tools {

	
}
class Club{
	String name;
	String hisGoalsInLeague;
	String hisAgainstGoalsInLeague;
	String currentPositionInLeague;
	String lastPositionInLeage;
}
class TeamRankingTable{
	 
}

class TableOfLeague{
	String competitionName;
	String years;
	List <Round> rounds;
	
	TableOfLeague(){
		competitionName = "";
		years ="";
		rounds =  new ArrayList<>();
	}
	public int getRound(String roundName) {
		for(Round round : rounds) {
			if(round.numberOfRound.equals(roundName)) {
				return rounds.indexOf(round);
			}
		}
		return -1;
	}
	public void addRound (Round round) {
		rounds.add(rounds.size() , round);
	}
	
	
	public void printTable() {
		System.out.println(competitionName + "@" + years);
		for(int i = 0 ; i <rounds.size() ; i++) {
			rounds.get(i).printRound();
		}
			
	}
 }//end TableOfLeague
	
class Round{
	String numberOfRound ;
	List <Game> games;
	Round(){
		numberOfRound = "";
		games =  new ArrayList<>();
	}
	public void addGame(Game game) {
		games.add(game);
	}
	public void printRound() {
		System.out.println(numberOfRound);
		for(int i = 0 ; i<games.size() ;i++) {
			games.get(i).printGame();
		}
	}
}//end Round

class Game{
	String firstTeam;
	String secondTeam;
	String finalResult;
	String resultOfFirstHalf = "##";
	String date;
	public void printGame() {
		System.out.print(date);
		System.out.print("  #");
		System.out.print(firstTeam);
		System.out.print("  vs  ");
		System.out.print(secondTeam);
		System.out.print("    ");
		System.out.print(finalResult);
		System.out.println();
	}
}//end Game
enum Kind{
	Round,
	Date,
	Team,
	Result,
	Time,
	Error
};
enum KindOfGoal{
	HasAssister,
	Individually,//like shoot with out assisster
	Reverse,
	Error
	
}
class KindOfElement{
	Kind kindOfElement; 
	Element refrenceOfElement;
}//end KindOfElement
class Goal{
	KindOfGoal kind = KindOfGoal.Error;
	String result ="";
	String minute ="";
	String player ="";
	String information ="";
	String assest ="";
	
	public void printGoal() {
		System.out.print(result + "  ");
		System.out.print(" at minute " + minute + "  ");
		System.out.print("the player is " +player + "  ");
		System.out.print(information + "  ");
		if(kind.equals(KindOfGoal.HasAssister)) {
			System.out.print("assested by "+assest);
		}
		System.out.println();
	}
}
