package collector.testData;

import java.util.ArrayList;
import java.util.List;

import sofaScoreModels.Iencident;
import sofaScoreModels.IencidentInGame_ChangePlayers;
import sofaScoreModels.IencidentInGame_Goal;
import sofaScoreModels.IencidentInGame_Header;
import sofaScoreModels.IencidentInGame_InjuryTime;
import sofaScoreModels.IencidentInGame_Player;
import sofaScoreModels.IencidentInGame_VarDecision;
import sofaScoreModels.InncidentInGame_Card;

public class SofaScoreGameIencidentsValues {

	public List<Iencident> getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted() {
		
		ArrayList<Iencident> gameIencidentsExpectedValueValue  = new ArrayList<>();
        
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Header("FT","2","0","false","90","999","period"));
       
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Jaïro Riedewald",null,null,"jairo-riedewald","J. Riedewald","M","339","285989"),
        		new IencidentInGame_Player ("Luka Milivojević",null, null,"luka-milivojevic","L. Milivojević","M","1408","50294"),
        		  null ,"120002049","90", "5", "true", null,"substitution"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGame_InjuryTime("4","90","0","injuryTime"));
        
        gameIencidentsExpectedValueValue.add(new InncidentInGame_Card(        
        		new IencidentInGame_Player ("John Fleck",null, null, "john-fleck","J. Fleck","M","405","27999"),
        		"John Fleck","Foul","119694657","89",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Antwoine Hackford","","","antwoine-hackford","A. Hackford","F","72","1049860"),
        		new IencidentInGame_Player ("Ben Osborn",null,null,"ben-osborn","B. Osborn","M","81","282665"),
        		 null,"120002051", "80", null, "false",null, "substitution" ));
        		
        gameIencidentsExpectedValueValue.add(new InncidentInGame_Card( 
        		new IencidentInGame_Player ("Eberechi Eze",null, null, "eberechi-eze","E. Eze","M","2092","864921"),
        		"Eberechi Eze","Foul","119694654","67",null,"true","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new InncidentInGame_Card( 
        		new IencidentInGame_Player ("Oliver Norwood","", "", "oliver-norwood","O. Norwood","M","311","100637"),
        		"Oliver Norwood","Foul","119694656","63",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Rhian Brewster","","","rhian-brewster","R. Brewster","F","2766","878705"),
        		new IencidentInGame_Player ("Lys Mousset","","","lys-mousset","L. Mousset","F","718","377108"),
        		null,"120002050", "61", null, "false", null, "substitution"  ));
                     
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Jordan Ayew",null,null,"jordan-ayew","J. Ayew","F","7115","103045"),
        		new IencidentInGame_Player ("Christian Benteke","","","christian-benteke","C. Benteke","F","1785","45970"),
        		"true","120002048", "48",null,  "true","injury", "substitution"));
        
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Header("HT","2","0","false","45","999","period"));
        
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Goal ("2","0",
        		new IencidentInGame_Player ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2092","864921"),
        		new IencidentInGame_Player ("James McArthur",null,null,"james-mcarthur","J. McArthur","M","230","39282"),
        		"139577802","45","6","true","regular","goal"));
		
		gameIencidentsExpectedValueValue.add(
				new InncidentInGame_Card(
						new IencidentInGame_Player ("Jayden Bogle",null,null,"bogle-jayden","J. Bogle","D","299","929132"),
						"Jayden Bogle","Foul","119694655","45","1","false","yellow","card"));

		 gameIencidentsExpectedValueValue.add(new IencidentInGame_InjuryTime("5","45","0","injuryTime"));
		 
	     gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
	        		new IencidentInGame_Player ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2092","864921"),
	        		new IencidentInGame_Player ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","552","148710"),
	        		"true","120002047","40",null,"true","injury","substitution"));
	        
		 gameIencidentsExpectedValueValue.add(new IencidentInGame_Goal ("1","0",
	        		new IencidentInGame_Player ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","556","148710"),
	        		null,
	        		"139577801","4",null,"true","regular","goal"));
		 
        return gameIencidentsExpectedValueValue;
	}
	
	public List<Iencident> getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted() {
		
		ArrayList<Iencident> gameIencidentsExpectedValueValue  = new ArrayList<>();
		
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Header("FT","0","1","false","90","999","period"));
		
		gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Axel Tuanzebe","","","axel-tuanzebe","A. Tuanzebe","D","2189","817979"),
        		new IencidentInGame_Player ("Anthony Martial","","","anthony-martial","A. Martial","F","28321","191176"),
        		null,"120012870","90","5","false",null,"substitution"));
		
        gameIencidentsExpectedValueValue.add(new IencidentInGame_InjuryTime("4","90","0","injuryTime"));

        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Scott McTominay","","","scott-mctominay","S. McTominay","M","5527","879346"),
        		new IencidentInGame_Player ("Bruno Fernandes","","","bruno-fernandes","B. Fernandes","M","50464","288205"),
        		null,"120012869","89",null,"false",null,"substitution"));

        gameIencidentsExpectedValueValue.add(new IencidentInGame_VarDecision(
        		"true",
        		new IencidentInGame_Player ("Matěj Vydra","","","matej-vydra","M. Vydra","F","335","58488"),
        		"true","4575","88","penaltyNotAwarded","varDecision"));

		
        return gameIencidentsExpectedValueValue;


	}
}
