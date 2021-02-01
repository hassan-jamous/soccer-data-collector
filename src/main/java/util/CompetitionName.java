package util;

public enum CompetitionName {

	EnglishPreimerLeague_WorldFootBall("eng-premier-league"),
	EnglishPreimerLeague_SofaScore("Premier League");
	
	private String value;
	
	private CompetitionName(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
	public static CompetitionName getValue(String competitionName , String site) {
		String  enumName = competitionName+"_"+site;
		System.out.println(CompetitionName.valueOf(enumName));
		return CompetitionName.valueOf(enumName); 
	}
}
