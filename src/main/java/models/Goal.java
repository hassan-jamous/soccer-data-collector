package models;

public class Goal {
	public KindOfGoal kind = KindOfGoal.Error;
	public String result ="";
	public String minute ="";
	public String player ="";
	public String information ="";
	public String assester ="";
	public Goal() {}
	public Goal(String result , String player , String information) {
		this.result = result;
		this.player = player;
		this.information = information;
		if(information.equals("0.")) {
			this.kind = KindOfGoal.OldGoal; 
		}
		
	}
	public Goal(String result , String minute , String player , String information) {
		this.result = result;
		this.minute = minute;
		this.player = player;
		this.information = information;
		if(information.contains("own")) {
			kind = KindOfGoal.Reverse;
		}
		else {
			kind = KindOfGoal.Individually;
		}
		
	}
	public Goal(String result , String minute , String player , String information , String assester) {
		this.result = result;
		this.minute = minute;
		this.player = player;
		this.information = information;
		this.assester = assester;
		this.kind = KindOfGoal.HasAssister;
	}
	public String toString() {
		
		String goal ="";
		goal = "(" + result + ")" + "  @  " + minute + " by " + player + "     " + information + ((kind == KindOfGoal.HasAssister) ?  "  Assisted by  " :  "" ) + assester ;
		return goal;
	}
}
