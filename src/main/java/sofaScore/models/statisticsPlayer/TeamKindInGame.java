package sofaScore.models.statisticsPlayer;

public enum TeamKindInGame {

	Home ("home"),
	Away ("away");
	
	private String value;
	
	private TeamKindInGame(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
