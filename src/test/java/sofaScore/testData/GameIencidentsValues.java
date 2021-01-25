package sofaScore.testData;

import java.util.ArrayList;
import java.util.List;

import sofaScore.models.gameIecidents.IncidentInGame;
import sofaScore.models.gameIecidents.IncidentInGameSubstitution;
import sofaScore.models.gameIecidents.IncidentInGameGoal;
import sofaScore.models.gameIecidents.IncidentInGamePeriod;
import sofaScore.models.gameIecidents.IncidentInGameInjuryTime;
import sofaScore.models.gameIecidents.IncidentInGamePlayer;
import sofaScore.models.gameIecidents.IncidentInGameVarDecision;
import sofaScore.models.gameIecidents.IncidentInGameCard;

public class GameIencidentsValues {

	public List<IncidentInGame> getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted() {
		
		ArrayList<IncidentInGame> gameIencidentsExpectedValueValue  = new ArrayList<>();
        
		gameIencidentsExpectedValueValue.add(new IncidentInGamePeriod("FT","2","0","false","90","999","period"));
       
        gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
        		new IncidentInGamePlayer ("Jaïro Riedewald",null,null,"jairo-riedewald","J. Riedewald","M","338","285989"),
        		new IncidentInGamePlayer ("Luka Milivojević",null, null,"luka-milivojevic","L. Milivojević","M","1425","50294"),
        		  null ,"120002049","90", "5", "true", null,"substitution"));
        
        gameIencidentsExpectedValueValue.add(new IncidentInGameInjuryTime("4","90","0","injuryTime"));
        
        gameIencidentsExpectedValueValue.add(new IncidentInGameCard(        
        		new IncidentInGamePlayer ("John Fleck",null, null, "john-fleck","J. Fleck","M","405","27999"),
        		"John Fleck","Foul","119694657","89",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
        		new IncidentInGamePlayer ("Antwoine Hackford","","","antwoine-hackford","A. Hackford","F","71","1049860"),
        		new IncidentInGamePlayer ("Ben Osborn",null,null,"ben-osborn","B. Osborn","M","82","282665"),
        		 null,"120002051", "80", null, "false",null, "substitution" ));
        		
        gameIencidentsExpectedValueValue.add(new IncidentInGameCard( 
        		new IncidentInGamePlayer ("Eberechi Eze",null, null, "eberechi-eze","E. Eze","M","2152","864921"),
        		"Eberechi Eze","Foul","119694654","67",null,"true","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IncidentInGameCard( 
        		new IncidentInGamePlayer ("Oliver Norwood","", "", "oliver-norwood","O. Norwood","M","315","100637"),
        		"Oliver Norwood","Foul","119694656","63",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
        		new IncidentInGamePlayer ("Rhian Brewster","","","rhian-brewster","R. Brewster","F","2751","878705"),
        		new IncidentInGamePlayer ("Lys Mousset","","","lys-mousset","L. Mousset","F","718","377108"),
        		null,"120002050", "61", null, "false", null, "substitution"  ));
                     
        gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
        		new IncidentInGamePlayer ("Jordan Ayew",null,null,"jordan-ayew","J. Ayew","F","7126","103045"),
        		new IncidentInGamePlayer ("Christian Benteke","","","christian-benteke","C. Benteke","F","1807","45970"),
        		"true","120002048", "48",null,  "true","injury", "substitution"));
        
		gameIencidentsExpectedValueValue.add(new IncidentInGamePeriod("HT","2","0","false","45","999","period"));
        
		gameIencidentsExpectedValueValue.add(new IncidentInGameGoal ("2","0",
        		new IncidentInGamePlayer ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2152","864921"),
        		new IncidentInGamePlayer ("James McArthur",null,null,"james-mcarthur","J. McArthur","M","241","39282"),
        		"139577802","45","6","true","regular","goal"));
		
		gameIencidentsExpectedValueValue.add(
				new IncidentInGameCard(
						new IncidentInGamePlayer ("Jayden Bogle",null,null,"bogle-jayden","J. Bogle","D","294","929132"),
						"Jayden Bogle","Foul","119694655","45","1","false","yellow","card"));

		 gameIencidentsExpectedValueValue.add(new IncidentInGameInjuryTime("5","45","0","injuryTime"));
		 
	     gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
	        		new IncidentInGamePlayer ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2152","864921"),
	        		new IncidentInGamePlayer ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","550","148710"),
	        		"true","120002047","40",null,"true","injury","substitution"));
	        
		 gameIencidentsExpectedValueValue.add(new IncidentInGameGoal ("1","0",
	        		new IncidentInGamePlayer ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","550","148710"),
	        		null,
	        		"139577801","4",null,"true","regular","goal"));
		 
        return gameIencidentsExpectedValueValue;
	}
	
	public List<IncidentInGame> getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted() {
		
		ArrayList<IncidentInGame> gameIencidentsExpectedValueValue  = new ArrayList<>();
		
		gameIencidentsExpectedValueValue.add(new IncidentInGamePeriod("FT","0","1","false","90","999","period"));
		
		gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
        		new IncidentInGamePlayer ("Axel Tuanzebe","","","axel-tuanzebe","A. Tuanzebe","D","2209","817979"),
        		new IncidentInGamePlayer ("Anthony Martial","","","anthony-martial","A. Martial","F","28413","191176"),
        		null,"120012870","90","5","false",null,"substitution"));
		
        gameIencidentsExpectedValueValue.add(new IncidentInGameInjuryTime("4","90","0","injuryTime"));

        gameIencidentsExpectedValueValue.add(new IncidentInGameSubstitution(
        		new IncidentInGamePlayer ("Scott McTominay","","","scott-mctominay","S. McTominay","M","5614","879346"),
        		new IncidentInGamePlayer ("Bruno Fernandes","","","bruno-fernandes","B. Fernandes","M","51111","288205"),
        		null,"120012869","89",null,"false",null,"substitution"));

        gameIencidentsExpectedValueValue.add(new IncidentInGameVarDecision(
        		"true",
        		new IncidentInGamePlayer ("Matěj Vydra","","","matej-vydra","M. Vydra","F","331","58488"),
        		"true","4575","88","penaltyNotAwarded","varDecision"));

		
        return gameIencidentsExpectedValueValue;


	}
}
