
package models;

public class Goal {
	public KindOfGoal kind;
	public String result ;
	public String minute ;
	public Player playerBasicInfo ;
	public String information ;
	public Player assesterBasicInfo ;
	public Goal() {
		playerBasicInfo = new Player();
		assesterBasicInfo =new Player();
		
	}
	public Goal(String result , String player , String information) {
		playerBasicInfo = new Player();
		assesterBasicInfo =new Player();
		this.result = result;
		this.playerBasicInfo.name = player;
		
		if(information.equals("0.")) {
			this.kind = KindOfGoal.OldGoal;
			this.information = null;
		}
		else {
			this.information = information;
		}
		
	}
	public Goal(String result , String minute , String player , String information) {
		playerBasicInfo = new Player();
		assesterBasicInfo =new Player();
		this.result = result;
		this.minute = minute;
		this.playerBasicInfo.name = player;
		this.information = information;
		if(information.contains("own")) {
			kind = KindOfGoal.Reverse;
		}
		else {
			kind = KindOfGoal.Individually;
		}
		
	}
	public Goal(String result , String minute , String player , String information , String assester) {
		playerBasicInfo = new Player();
		assesterBasicInfo =new Player();
		this.result = result;
		this.minute = minute;
		this.playerBasicInfo.name = player;
		this.information = information;
		this.assesterBasicInfo.name = assester;
		this.kind = KindOfGoal.HasAssister;
	}
	public String toString() {
		
		String goal ="";
		goal = "(" + result + ")" + "  @  " + minute + " by " + playerBasicInfo.name +
				"   " + information +
				((kind == KindOfGoal.HasAssister) ?  "  Assisted by  "+ assesterBasicInfo.name :  "" ) ;
		return goal;
	}
}
