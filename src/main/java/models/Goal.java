package models;

public class Goal {
	public KindOfGoal kind = KindOfGoal.Error;
	public String result ="";
	public String minute ="";
	public String player ="";
	public String information ="";
	public String assest ="";
	public Goal() {}
	
	public String toString() {
		
		String goal ="";
		goal = "(" + result + ")" + "  @  " + minute + " by " + player + "     " + information + "    " + assest ;
		return goal;
	}
}
