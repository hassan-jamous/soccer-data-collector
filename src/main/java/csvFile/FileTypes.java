package csvFile;

public enum FileTypes {
	
	Statistics ("Statistics"),
	NoInformation ("NoInformation"),
	Incidents ("Incidents"),
	HeadToHead("H2H");
	
	private String value;
	
	private FileTypes (String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
