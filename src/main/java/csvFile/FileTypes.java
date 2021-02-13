package csvFile;

import sofaScore.models.gameIecidents.IncidentInGame;
import sofaScore.models.gameIecidents.IncidentInGameCard;
import sofaScore.models.gameIecidents.IncidentInGameGoal;
import sofaScore.models.gameIecidents.IncidentInGameInjuryTime;
import sofaScore.models.gameIecidents.IncidentInGamePenalty;
import sofaScore.models.gameIecidents.IncidentInGamePeriod;
import sofaScore.models.gameIecidents.IncidentInGameSubstitution;
import sofaScore.models.gameIecidents.IncidentInGameVarDecision;

public enum FileTypes {
	
	Statistics ("Statistics"),
	NoStatistics("NoTatistics"),
	NoInformation ("NoInformation"),
	Card("Card"),
	Goal("Goal"),
	InjuryTime("InjuryTime"),
	Penalty("Penalty"),
	Period("Period"),
	Substitution("Substitution"),
	VarDecision("VarDecision"),
	NoIncidents ("NoIncidents"),
	HeadToHead("H2H");
	
	private String value;
	
	private FileTypes (String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	public boolean isIncident() {
		if(this == Card || this == Goal || this == InjuryTime || this == Penalty || this == Period || this == Substitution || this == VarDecision) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static FileTypes getFileType(IncidentInGame incident) {
		
		if(incident instanceof IncidentInGameCard) {
			return FileTypes.Card;
		}
		else if(incident instanceof IncidentInGameGoal) {
			return FileTypes.Goal;
		}
		else if(incident instanceof IncidentInGameInjuryTime) {
			return FileTypes.InjuryTime;
		}
		else if(incident instanceof IncidentInGamePenalty) {
			return FileTypes.Penalty;
		}
		else if(incident instanceof IncidentInGamePeriod) {
			return FileTypes.Period;
		}
		else if(incident instanceof IncidentInGameSubstitution) {
			return FileTypes.Substitution;
		}
		else if(incident instanceof IncidentInGameVarDecision) {
			return FileTypes.VarDecision;
		}
		else {
			throw new RuntimeException("there is new incident type");
		}
	}
	
}
