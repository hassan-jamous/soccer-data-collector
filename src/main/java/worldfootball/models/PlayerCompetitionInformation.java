package worldfootball.models;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class PlayerCompetitionInformation {
   
	public String competitionNation;
    public String competitionName;
    public String matchesNumber;
    public String goalsNumber;
    public String startingLineUp;
    public String substitueIn;
    public String substitueOut;
    public String yellowCards;
    public String secondYellowCards;
    public String redCards;

    public PlayerCompetitionInformation( String competitionNation,String competitionName, String matchesNumber, String goalsNumber
            , String startingLineUp, String substitueIn, String subtitueOut, String yellowCard, String secondYellowCard, String redCards) {
        this();
    	this.competitionName = competitionName;
        if (competitionName.contains("∑")) {
            this.competitionNation = null;

        } else {
            this.competitionNation = competitionNation;
        }
        this.matchesNumber = matchesNumber;
        this.goalsNumber = goalsNumber;
        this.startingLineUp = startingLineUp;
        this.substitueIn = substitueIn;
        this.substitueOut = subtitueOut;
        this.yellowCards = yellowCard;
        this.secondYellowCards = secondYellowCard;
        this.redCards = redCards;

    }
 }
