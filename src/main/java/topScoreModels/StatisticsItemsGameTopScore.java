package topScoreModels;

public class StatisticsItemsGameTopScore {

	public String name;
	public String home;
	public String away;

	public StatisticsItemsGameTopScore(){}
	public StatisticsItemsGameTopScore(String name , String home , String away){
		this.away = away;
		this.home = home;
		this.name = name;
	}
	public String toString() {
		String result ="";
		result = name + "  " + "(home  =" + home + ")   " +"(away =  " + away+")" ;
		return result;
	}
}
