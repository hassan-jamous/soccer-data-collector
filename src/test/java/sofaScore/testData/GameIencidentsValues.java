package sofaScore.testData;

import java.util.ArrayList;
import java.util.List;

import sofaScore.models.Iencident;
import sofaScore.models.IencidentInGameChangePlayers;
import sofaScore.models.IencidentInGameGoal;
import sofaScore.models.IencidentInGameHeader;
import sofaScore.models.IencidentInGameInjuryTime;
import sofaScore.models.IencidentInGamePlayer;
import sofaScore.models.IencidentInGameVarDecision;
import sofaScore.models.InncidentInGameCard;

public class GameIencidentsValues {

	public List<Iencident> getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted() {
		
		ArrayList<Iencident> gameIencidentsExpectedValueValue  = new ArrayList<>();
        
		gameIencidentsExpectedValueValue.add(new IencidentInGameHeader("FT","2","0","false","90","999","period"));
       
        gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
        		new IencidentInGamePlayer ("Jaïro Riedewald",null,null,"jairo-riedewald","J. Riedewald","M","339","285989"),
        		new IencidentInGamePlayer ("Luka Milivojević",null, null,"luka-milivojevic","L. Milivojević","M","1414","50294"),
        		  null ,"120002049","90", "5", "true", null,"substitution"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGameInjuryTime("4","90","0","injuryTime"));
        
        gameIencidentsExpectedValueValue.add(new InncidentInGameCard(        
        		new IencidentInGamePlayer ("John Fleck",null, null, "john-fleck","J. Fleck","M","402","27999"),
        		"John Fleck","Foul","119694657","89",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
        		new IencidentInGamePlayer ("Antwoine Hackford","","","antwoine-hackford","A. Hackford","F","72","1049860"),
        		new IencidentInGamePlayer ("Ben Osborn",null,null,"ben-osborn","B. Osborn","M","82","282665"),
        		 null,"120002051", "80", null, "false",null, "substitution" ));
        		
        gameIencidentsExpectedValueValue.add(new InncidentInGameCard( 
        		new IencidentInGamePlayer ("Eberechi Eze",null, null, "eberechi-eze","E. Eze","M","2133","864921"),
        		"Eberechi Eze","Foul","119694654","67",null,"true","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new InncidentInGameCard( 
        		new IencidentInGamePlayer ("Oliver Norwood","", "", "oliver-norwood","O. Norwood","M","311","100637"),
        		"Oliver Norwood","Foul","119694656","63",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
        		new IencidentInGamePlayer ("Rhian Brewster","","","rhian-brewster","R. Brewster","F","2762","878705"),
        		new IencidentInGamePlayer ("Lys Mousset","","","lys-mousset","L. Mousset","F","715","377108"),
        		null,"120002050", "61", null, "false", null, "substitution"  ));
                     
        gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
        		new IencidentInGamePlayer ("Jordan Ayew",null,null,"jordan-ayew","J. Ayew","F","7129","103045"),
        		new IencidentInGamePlayer ("Christian Benteke","","","christian-benteke","C. Benteke","F","1799","45970"),
        		"true","120002048", "48",null,  "true","injury", "substitution"));
        
		gameIencidentsExpectedValueValue.add(new IencidentInGameHeader("HT","2","0","false","45","999","period"));
        
		gameIencidentsExpectedValueValue.add(new IencidentInGameGoal ("2","0",
        		new IencidentInGamePlayer ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2133","864921"),
        		new IencidentInGamePlayer ("James McArthur",null,null,"james-mcarthur","J. McArthur","M","238","39282"),
        		"139577802","45","6","true","regular","goal"));
		
		gameIencidentsExpectedValueValue.add(
				new InncidentInGameCard(
						new IencidentInGamePlayer ("Jayden Bogle",null,null,"bogle-jayden","J. Bogle","D","298","929132"),
						"Jayden Bogle","Foul","119694655","45","1","false","yellow","card"));

		 gameIencidentsExpectedValueValue.add(new IencidentInGameInjuryTime("5","45","0","injuryTime"));
		 
	     gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
	        		new IencidentInGamePlayer ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2133","864921"),
	        		new IencidentInGamePlayer ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","555","148710"),
	        		"true","120002047","40",null,"true","injury","substitution"));
	        
		 gameIencidentsExpectedValueValue.add(new IencidentInGameGoal ("1","0",
	        		new IencidentInGamePlayer ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","555","148710"),
	        		null,
	        		"139577801","4",null,"true","regular","goal"));
		 
        return gameIencidentsExpectedValueValue;
	}
	
	public List<Iencident> getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted() {
		
		ArrayList<Iencident> gameIencidentsExpectedValueValue  = new ArrayList<>();
		
		gameIencidentsExpectedValueValue.add(new IencidentInGameHeader("FT","0","1","false","90","999","period"));
		
		gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
        		new IencidentInGamePlayer ("Axel Tuanzebe","","","axel-tuanzebe","A. Tuanzebe","D","2187","817979"),
        		new IencidentInGamePlayer ("Anthony Martial","","","anthony-martial","A. Martial","F","28348","191176"),
        		null,"120012870","90","5","false",null,"substitution"));
		
        gameIencidentsExpectedValueValue.add(new IencidentInGameInjuryTime("4","90","0","injuryTime"));

        gameIencidentsExpectedValueValue.add(new IencidentInGameChangePlayers(
        		new IencidentInGamePlayer ("Scott McTominay","","","scott-mctominay","S. McTominay","M","5543","879346"),
        		new IencidentInGamePlayer ("Bruno Fernandes","","","bruno-fernandes","B. Fernandes","M","50761","288205"),
        		null,"120012869","89",null,"false",null,"substitution"));

        gameIencidentsExpectedValueValue.add(new IencidentInGameVarDecision(
        		"true",
        		new IencidentInGamePlayer ("Matěj Vydra","","","matej-vydra","M. Vydra","F","330","58488"),
        		"true","4575","88","penaltyNotAwarded","varDecision"));

		
        return gameIencidentsExpectedValueValue;


	}
}
