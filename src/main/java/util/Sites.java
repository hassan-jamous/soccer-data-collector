package util;

public enum Sites {

	SofaScore_Com ("SofaScore"),
	WorldFootBall_Net ("WorldFootball");
	
	private String value;
	
	private Sites(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
