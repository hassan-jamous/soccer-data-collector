package collector.testData;

import java.util.ArrayList;
import java.util.List;

import sofaScoreModels.Iencident;
import sofaScoreModels.IencidentInGame_ChangePlayers;
import sofaScoreModels.IencidentInGame_Goal;
import sofaScoreModels.IencidentInGame_Header;
import sofaScoreModels.IencidentInGame_InjuryTime;
import sofaScoreModels.IencidentInGame_Player;
import sofaScoreModels.InncidentInGame_Card;

public class SofaScoreGameIencidentsValues {

	public List<Iencident> getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted() {
		
		ArrayList<Iencident> gameIencidentsExpectedValueValue  = new ArrayList<>();
        
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Header("FT","2","0","false","90","999","period"));
       
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Jaïro Riedewald",null,null,"jairo-riedewald","J. Riedewald","M","340","285989"),
        		new IencidentInGame_Player ("Luka Milivojević",null, null,"luka-milivojevic","L. Milivojević","M","1414","50294"),
        		  null ,"120002049","90", "5", "true", null,"substitution"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGame_InjuryTime("4","90","0","injuryTime"));
        
        gameIencidentsExpectedValueValue.add(new InncidentInGame_Card(        
        		new IencidentInGame_Player ("John Fleck",null, null, "john-fleck","J. Fleck","M","402","27999"),
        		"John Fleck","Foul","119694657","89",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Antwoine Hackford","","","antwoine-hackford","A. Hackford","F","70","1049860"),
        		new IencidentInGame_Player ("Ben Osborn",null,null,"ben-osborn","B. Osborn","M","81","282665"),
        		 null,"120002051", "80", null, "false",null, "substitution" ));
        		
        gameIencidentsExpectedValueValue.add(new InncidentInGame_Card( 
        		new IencidentInGame_Player ("Eberechi Eze",null, null, "eberechi-eze","E. Eze","M","2086","864921"),
        		"Eberechi Eze","Foul","119694654","67",null,"true","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new InncidentInGame_Card( 
        		new IencidentInGame_Player ("Oliver Norwood","", "", "oliver-norwood","O. Norwood","M","310","100637"),
        		"Oliver Norwood","Foul","119694656","63",null,"false","yellow","card"));
        
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Rhian Brewster","","","rhian-brewster","R. Brewster","F","2758","878705"),
        		new IencidentInGame_Player ("Lys Mousset","","","lys-mousset","L. Mousset","F","714","377108"),
        		null,"120002050", "61", null, "false", null, "substitution"  ));
                     
        gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
        		new IencidentInGame_Player ("Jordan Ayew",null,null,"jordan-ayew","J. Ayew","F","7131","103045"),
        		new IencidentInGame_Player ("Christian Benteke","","","christian-benteke","C. Benteke","F","1787","45970"),
        		"true","120002048", "48",null,  "true","injury", "substitution"));
        
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Header("HT","2","0","false","45","999","period"));
        
		gameIencidentsExpectedValueValue.add(new IencidentInGame_Goal ("2","0",
        		new IencidentInGame_Player ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2086","864921"),
        		new IencidentInGame_Player ("James McArthur",null,null,"james-mcarthur","J. McArthur","M","231","39282"),
        		"139577802","45","6","true","regular","goal"));
		
		gameIencidentsExpectedValueValue.add(
				new InncidentInGame_Card(
						new IencidentInGame_Player ("Jayden Bogle",null,null,"bogle-jayden","J. Bogle","D","292","929132"),
						"Jayden Bogle","Foul","119694655","45","1","false","yellow","card"));

		 gameIencidentsExpectedValueValue.add(new IencidentInGame_InjuryTime("5","45","0","injuryTime"));
		 
	     gameIencidentsExpectedValueValue.add(new IencidentInGame_ChangePlayers(
	        		new IencidentInGame_Player ("Eberechi Eze",null,null,"eberechi-eze","E. Eze","M","2086","864921"),
	        		new IencidentInGame_Player ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","556","148710"),
	        		"true","120002047","40",null,"true","injury","substitution"));
	        
		 gameIencidentsExpectedValueValue.add(new IencidentInGame_Goal ("1","0",
	        		new IencidentInGame_Player ("Jeffrey Schlupp",null,null,"jeffrey-schlupp","J. Schlupp","M","556","148710"),
	        		null,
	        		"139577801","4",null,"true","regular","goal"));


		 
        return gameIencidentsExpectedValueValue;
	}
}
