package worldfootball.models;

public enum RankingTableRequest {

	Home ("/heim"),
	Away ("/auswaerts"),
	Normal ("");
	
	private String value;
	
	RankingTableRequest(String value){
		this.value =  value;
	}
	public String value() {
		return this.value;
	}
}
