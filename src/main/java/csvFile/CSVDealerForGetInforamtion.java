package csvFile;

import lombok.NoArgsConstructor;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.IncidentInGame;
import sofaScore.models.gameIecidents.IncidentInGameCard;
import sofaScore.models.gameIecidents.IncidentInGameGoal;
import sofaScore.models.gameIecidents.IncidentInGameInjuryTime;
import sofaScore.models.gameIecidents.IncidentInGamePenalty;
import sofaScore.models.gameIecidents.IncidentInGamePeriod;
import sofaScore.models.gameIecidents.IncidentInGameSubstitution;
import sofaScore.models.gameIecidents.IncidentInGameVarDecision;
import sofaScore.models.gameStatistics.GameStatistics;

/**
 * 
 * to get the information as string to be written in the file
 *
 */
@NoArgsConstructor
public class CSVDealerForGetInforamtion {

	public String getValuesStringForCSV(GameStatistics obj) {
		String result =String.valueOf(obj.hasFivePeriods)+",";
		for(int i = 0 ; i < obj.statistics.size() ; i++) {
			result +=obj.statistics.get(i).home+","+obj.statistics.get(i).away+((i==obj.statistics.size()-1)?"":",");
		}
		return result;
	}

	public String getHeaderStringForCSV(GameStatistics obj) {
		String result ="HasExtraTime,";
		for(int i = 0 ; i < obj.statistics.size() ; i++) {
			result += obj.statistics.get(i).period+obj.statistics.get(i).groupName+
					obj.statistics.get(i).name+"Home,"+
					obj.statistics.get(i).period+obj.statistics.get(i).groupName+
					obj.statistics.get(i).name+"Away"+((i==obj.statistics.size()-1)?"":",");
		}
		return result;
	}
	
	//ask hassan what we want to print
	//the different
	//https://api.sofascore.com/api/v1/event/7821318
	//https://api.sofascore.com/api/v1/event/7805352
	public String getValuesStringForCSV(GameBasicInformation obj) {
		String result ="";
		result = obj.event.tournament.uniqueTournament.name+","+obj.event.season.year+","+ obj.event.tournament.name+","+obj.event.roundInfo.round+","
		+obj.event.getDateToDataBase()+","+obj.event.homeTeam.shortName+","+obj.event.awayTeam.shortName +","+obj.event.homeScore.current+","+
				obj.event.awayScore.current;
		return result;
	}
	
	public String getHeaderStringForCSV(GameBasicInformation obj) {
		String result ="League,Years,TypeOfLeague,Round,Date,HomeTeam,AwayTeam,HomeScore,AwayScore";
		return result;
	}
	
	public String getHeaderStringForCSV(IncidentInGame incident) {
		String result="";
		if(incident instanceof IncidentInGameCard) {
			result ="PlayerName,FirstName,LastName,ShortName,Slug,Position,Reason,Time,AddedTime,IsHome,IncidentClass,IncidentType,GameID";
		}
		else if(incident instanceof IncidentInGameGoal) {
			result ="HomeScore,AwayScore,PlayerName,PlayerFirstName,PlayerLastName,PlayerShortName,PlayerSlug,PlayerPosition,"
				+"AssistName,AssistFirstName,AssistLastName,AssistShortName,AssistSlug,AssistPosition,"+
				"Time,AddedTime,IsHome,IncidentClass,IncidentType,GameID";
		}
		else if(incident instanceof IncidentInGameInjuryTime) {
			result = "Length,Time,AddedTime,IncidentType,GameID";
		}
		else if(incident instanceof IncidentInGamePenalty) {
			result = "Time,PlayerName,PlayerFirstName,PlayerLastName,PlayerShortName,PlayerSlug,PlayerPosition,Description,IsHome,IncidentClass,IncidentType,GameID";
		}
		else if(incident instanceof IncidentInGamePeriod) {
			result = "Text,HomeScore,AwayScore,IsLive,Time,AddedTime,IncidentType,GameID";
		}
		else if(incident instanceof IncidentInGameSubstitution) {
			result = "PlayerInFirstName,playerInLastName,PlayerInShortName,PlayerInSlug,playerInPosition,"+
					"PlayerOutFirstName,PlayerOutLastName,PlayerOutShortName,PlayerOutSlug,PlayerOutPosition,"+
					"Injury,Time,AddedTime,IsHome,IncidentClass,IncidentType,GameID";
		}
		else if(incident instanceof IncidentInGameVarDecision) {
			result ="Confirmed,PlayerFirstName,PlayerLastName,PlayerShortName,PlayerSlug,PlayerPosition,"+
					"Time,IsHome,IncidentClass,IncidentType,GameID";
		}
		return result;
	}
	
	public String getValuesStringForCSV(IncidentInGame incident) {
		String result="";
		if(incident instanceof IncidentInGameCard) {
			IncidentInGameCard card = 	(IncidentInGameCard)incident;
		 result = card.playerName+","+((card.player != null && card.player.firstName!= null && !card.player.firstName.isEmpty())?card.player.firstName :"null")+","+
			((card.player != null && card.player.lastName!= null && !card.player.lastName.isEmpty())?card.player.lastName:"null")+","+
				 ((card.player != null && card.player.shortName!= null && !card.player.shortName.isEmpty() )?card.player.shortName:"null")+","+
			((card.player != null && card.player.slug!= null && !card.player.slug.isEmpty() )?card.player.slug:"null")+","+
				((card.player != null && card.player.position!= null)? card.player.position:"null")+","+card.reason+","+card.time+","+card.addedTime+","+card.isHome+","+card.incidentClass+","+card.incidentType;
		}
		else if(incident instanceof IncidentInGameGoal) {
			IncidentInGameGoal goal = 	(IncidentInGameGoal)incident;
			result = goal.homeScore+","+goal.awayScore+","+
					goal.player.firstName+","+goal.player.lastName+","+goal.player.shortName+","+goal.player.slug+","+goal.player.position+","+
					((goal.assist1 != null)?
					goal.assist1.firstName+","+goal.assist1.lastName+","+goal.assist1.shortName+","+goal.assist1.slug+","+goal.assist1.position+","
					:"null,null,null,null,null,")+
					goal.time+","+goal.addedTime+","+goal.isHome+","+goal.incidentClass+","+goal.incidentType;
		}
		else if(incident instanceof IncidentInGameInjuryTime) {
			IncidentInGameInjuryTime injuryTime = 	(IncidentInGameInjuryTime)incident;
			result = injuryTime.length+","+injuryTime.time+","+injuryTime.addedTime+","+injuryTime.incidentType;
		}
		else if(incident instanceof IncidentInGamePenalty) {
			IncidentInGamePenalty penalty = 	(IncidentInGamePenalty)incident;
			result = penalty.time+",";
			if(penalty.player == null) {result+="null,null,null,null,null,";}
			else{
				result+=penalty.player.firstName +","+penalty.player.lastName+","+penalty.player.shortName+","+penalty.player.slug+","+penalty.player.position+",";
			}
			result+=penalty.description+","+penalty.isHome+","+penalty.incidentClass+","+penalty.incidentType;
		}
		else if(incident instanceof IncidentInGamePeriod) {
			IncidentInGamePeriod period = 	(IncidentInGamePeriod)incident;
			result = period.text+","+period.homeScore+","+period.awayScore+","+period.isLive+","+period.time+","+period.addedTime+","+
					period.incidentType;
		}
		else if(incident instanceof IncidentInGameSubstitution) {
			IncidentInGameSubstitution substitution = 	(IncidentInGameSubstitution)incident;
			result = ((substitution.playerIn.firstName==null || substitution.playerIn.firstName.isEmpty())?"null":substitution.playerIn.firstName)+","+
					((substitution.playerIn.lastName== null ||substitution.playerIn.lastName.isEmpty()?"null":substitution.playerIn.lastName))+","+
					substitution.playerIn.shortName+","+substitution.playerIn.slug+","+substitution.playerIn.position+","+
					substitution.playerOut.firstName+","+substitution.playerOut.lastName+","+substitution.playerOut.shortName+","+substitution.playerOut.slug+","+substitution.playerOut.position+","+
					substitution.injury+","+substitution.time+","+substitution.addedTime+","+substitution.isHome+","+substitution.incidentClass+","+
					substitution.incidentType;
		}
		else if(incident instanceof IncidentInGameVarDecision) {
			IncidentInGameVarDecision varDecision = 	(IncidentInGameVarDecision)incident;
			result =varDecision.confirmed+","+ varDecision.player.firstName+","+varDecision.player.lastName+","+varDecision.player.shortName+","+varDecision.player.slug+","+varDecision.player.position+","+
					varDecision.time+","+varDecision.isHome+","+varDecision.incidentClass+","+varDecision.incidentType;
		}
		return result;
	}
	
}
