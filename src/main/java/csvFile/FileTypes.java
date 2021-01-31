package csvFile;

public enum FileTypes {
	
	Statistics ("Statistics"),
	NoInformation ("NoInformation"),
	Incidents ("Incidents");
	
	private String value;
	
	private FileTypes (String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
