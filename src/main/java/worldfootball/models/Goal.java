
package worldfootball.models;

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
	public Goal(String result, String player ) {
		this();
		
	}
	//old goal just takes three parameters , and the minutes take one of three value 0,45,90
	public Goal(String result , String minutes , String player) {
		this();
		this.result = result;
		this.playerBasicInfo.name = player;
		this.minute = minutes;
		this.information = null;
		this.assesterBasicInfo =null;
		this.kind = KindOfGoal.OldGoal;
				
	}
	public Goal(String result , String minute , String player , String information) {
		this();
		this.result = result;
		this.minute = minute;
		this.playerBasicInfo.name = player;
		this.information = information;
		if(information.contains("own goal")) {
			kind = KindOfGoal.Reverse;
		}
		else {
			kind = KindOfGoal.Individually;
		}
		this.assesterBasicInfo =null;
	
	}
	public Goal(String result , String minute , String player , String information , String assester) {
		this();
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
