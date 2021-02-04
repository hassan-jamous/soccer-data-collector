package worldfootball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import worldfootball.models.Club;
import worldfootball.models.Game;
import worldfootball.models.HistoyGame;

public class HistoryCollectorTest {

	@Test 
    public void itShouldGetHistoryOFMatch() {
    /*
    	HistoryCollector historyCollector = new HistoryCollector();
    	ArrayList<HistoyGame> historyGame1ActualValue = historyCollector.getAllHeadToHeadBetween("liverpool-fc", "manchester-united");
        assertThat(historyGame1ActualValue.get(0)).usingRecursiveComparison().isEqualTo(new HistoyGame("FA Cup","2020/2021","4. Round", new Game("24/01/2021","17:00",new Club("Manchester United"), new Club("Liverpool FC"),"3:2 (1:1)")));
    	assertThat(historyGame1ActualValue.get(1)).usingRecursiveComparison().isEqualTo(new HistoyGame("Premier League","2020/2021","19. Round", new Game("17/01/2021","16:30",new Club("Liverpool FC"), new Club("Manchester United"),"0:0 (0:0)")));

        
        for(int i =0 ; i <historyGame1ActualValue.size(); i++) {
        	System.out.println(historyGame1ActualValue.get(i).competitionName+"   "+
        			historyGame1ActualValue.get(i).year+"  "+
        			historyGame1ActualValue.get(i).roundInfo+"  "+
        			historyGame1ActualValue.get(i).gameInfo.date+"  "+
        			historyGame1ActualValue.get(i).gameInfo.time+"  "+
        			historyGame1ActualValue.get(i).gameInfo.firstTeamBasicInfo.name+"  "+
        			historyGame1ActualValue.get(i).gameInfo.secondTeamBasicInfo.name+"  "+
        			historyGame1ActualValue.get(i).gameInfo.finalResult+"  "+
        			historyGame1ActualValue.get(i).gameInfo.resultOfFirstHalf);
        }
        */
    }
	

	@Test 
    public void itShouldGetHistoryOFMatchUntil() {
    
    	HistoryCollector historyCollector = new HistoryCollector();
    	ArrayList<HistoyGame> historyGame1ActualValue = historyCollector.getHeadToHeadUntil("liverpool-fc", "manchester-united","2000/2001");
        assertThat(historyGame1ActualValue.get(0)).usingRecursiveComparison().isEqualTo(new HistoyGame("FA Cup","2020/2021","4. Round", new Game("24/01/2021","17:00",new Club("Manchester United"), new Club("Liverpool FC"),"3:2 (1:1)")));
    	assertThat(historyGame1ActualValue.get(1)).usingRecursiveComparison().isEqualTo(new HistoyGame("Premier League","2020/2021","19. Round", new Game("17/01/2021","16:30",new Club("Liverpool FC"), new Club("Manchester United"),"0:0 (0:0)")));
    	historyCollector.writeHeadToHeadInCSV("PreimerLeague", "liverpool-fc", "manchester-united", "2000/2001");
    }
}
