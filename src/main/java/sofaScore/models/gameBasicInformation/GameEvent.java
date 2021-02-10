package sofaScore.models.gameBasicInformation;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
public class GameEvent {

	public TournamentInGame tournament;
	public SeasonInGame season;
	public RoundInGame roundInfo;
	public TeamInGame homeTeam;
	public TeamInGame awayTeam;
	public ScoreTeamInGame homeScore;
	public ScoreTeamInGame awayScore;
	public Stauts status;
	//public Date currentPeriodStartTimestamp;
	//public Long startTimestamp;
	public Timestamp startTimestamp;
	/*public Date getDate() {	
		return new Date(this.startTimestamp*1000L);
	}*/
	public Date getDate() {	
		
	return new Date(this.startTimestamp.getTime());
    }
	public String getDateToPrint() {
		SimpleDateFormat simpleDateoFormat = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		return  simpleDateoFormat.format(getDate());
	}
	public String getDateToDataBase() {
		SimpleDateFormat simpleDateoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  simpleDateoFormat.format(getDate());
	}
	
	
}
