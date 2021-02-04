package worldfootball;

import java.util.TreeSet;

public class CompetitionCollector {

	HistoryCollector historyCollector = new HistoryCollector();
	ClubsCollector clubsCollector = new ClubsCollector();
	
	public void writeHeadToHead(String competitionName,String startSeason ,String endSeason) {
		
		TreeSet<String> clubsInCompetition = clubsCollector.getAllClubsInCompetition(competitionName, startSeason, endSeason);
		String[] arrayClubsInCompetition = clubsInCompetition.toArray(new String[clubsInCompetition.size()]);
		for(int i = 0 ; i < arrayClubsInCompetition.length; i++) {		
			for(int j = i+1 ; j < arrayClubsInCompetition.length ; j++) {
				String firstClub = arrayClubsInCompetition[i];
				String secondClub = arrayClubsInCompetition[j];
				firstClub = firstClub.toLowerCase().replaceAll("&", "").replaceAll("\\s+", "-");
				secondClub = secondClub.toLowerCase().replaceAll("&", "").replaceAll("\\s+", "-");
				historyCollector.writeHeadToHeadInCSV(competitionName, firstClub, secondClub, startSeason);
			}
		}
	}
}
