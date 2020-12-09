package collector;

import collector.Game;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class ScreenScraper {
	
//###############################################################################################
	//season example 1888-1889 
	public String buildURL(String season) {
		
		String url = null;
		url =  "https://www.worldfootball.net/all_matches/eng-premier-league-"+season+"/";
		return url;
	}
//###############################################################################################
//###############################################################################################
	//cometitionName example eng-premier-league-
	//season example 1888-1889 
	public String buildURL(String competitionName ,String season) {
			
		String url = null;
		url =  "https://www.worldfootball.net/all_matches/"+competitionName+season+"/";
		return url;
	}
//###############################################################################################	
//###############################################################################################
	public String sendGetHttpRequest(String url) {
				
		String htmlPage = null;
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder()
		         .uri(URI.create(url))
		         .build();
	       try {
			HttpResponse<String> httpResponse = client.send(httpRequest , HttpResponse.BodyHandlers.ofString());
			htmlPage = httpResponse.body();

	       } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return htmlPage;
	}
//###############################################################################################
//###############################################################################################
	public TableOfLeague getResultOfCompetition(String competition) {
		
		TableOfLeague table = new TableOfLeague ();//to save the result
		table.years = competition;
		table.competitionName = "Primer League";
		Round round ;
		String roundName ="";
		String date ="";
		String firstTeam ="";
		String secondTeam ="";
		String resultOfGame ="";
		Game game ;
		int numberOfTeamsInGame = 0;		
		String url = buildURL(competition);
		
		String htmlPage ;
		htmlPage = sendGetHttpRequest(url);
		
		Document doc;
		doc = Jsoup.parse(htmlPage);
		Elements tableOfLeague = doc.getElementsByClass("standard_tabelle");
		Elements rows = tableOfLeague.select("tr");

		for(Element row : rows) {//for1
			if(kindOfElement(row).kindOfElement.equals(Kind.Round)) {//if round
				System.out.println(row.text());//the text is in child of row not in row!!!!!
				
				roundName = row.text();
				
				round = new Round();
				round.numberOfRound = roundName;
				
				table.addRound(round);
				
				//go to next row 
				//i.e the next <tr>
				row = row.nextElementSibling();
				while((row != null)  && ((kindOfElement(row).kindOfElement.equals(Kind.Round)) == false)) {//while all games in the round (i.e next round)
					if((row.childrenSize() > 0)) {//iff
						Elements childrenOfRow = row.children();
						for(Element child : childrenOfRow) {//for (next game)
					
							//date
							if(kindOfElement(child).kindOfElement.equals(Kind.Date)) {
								date = kindOfElement(child).refrenceOfElement.text();
							}//end date
							
							//first team
							else if((kindOfElement(child).kindOfElement.equals(Kind.Team)) && (numberOfTeamsInGame == 0)) {
								numberOfTeamsInGame = 1;
								firstTeam = kindOfElement(child).refrenceOfElement.text();
							}//end first team
					
							//second team
							else if( (kindOfElement(child).kindOfElement.equals(Kind.Team)) && (numberOfTeamsInGame == 1)){
								numberOfTeamsInGame = 0;
								secondTeam = kindOfElement(child).refrenceOfElement.text();
							}//end second team
					
							//result of game
							else if(kindOfElement(child).kindOfElement.equals(Kind.Result)){
								
								if(child.childrenSize() > 0 ) { resultOfGame = kindOfElement(child).refrenceOfElement.text();}
								else {resultOfGame = child.text();}//old leagues
								
								game = new Game();
								game.date = date;
								game.firstTeam = firstTeam;
								game.secondTeam = secondTeam;
								if( (hasFirstHalf(resultOfGame))) {
									game.resultOfFirstHalf = resultOfGame.substring(resultOfGame.indexOf("("), resultOfGame.indexOf(")"));
									game.finalResult = resultOfGame.substring(0, resultOfGame.indexOf(")")-1);
								}
								else {
									game.finalResult = resultOfGame;
								}
								round.addGame(game);
								
								System.out.print("   ");
								System.out.print(game.date);
								System.out.print("   ");
								System.out.print(game.firstTeam);
								System.out.print("  vs  ");
								System.out.print(game.secondTeam);
								System.out.print("         ");
								if( (hasFirstHalf(resultOfGame))) {
									game.resultOfFirstHalf = resultOfGame.substring(resultOfGame.indexOf("("), resultOfGame.indexOf(")")+1);//to search for it !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
									game.finalResult = resultOfGame.substring(0, resultOfGame.indexOf("(")-1);
									System.out.print(game.finalResult);
									System.out.print(" ## ");																				
									System.out.print(game.resultOfFirstHalf);
									System.out.print(" ##");
								}
								else {
									
									System.out.print(game.finalResult);
								}
								
								System.out.println();
							}//end result of game
						}//end for next game
					}//end iff
				row = row.nextElementSibling();
				}//while all games in the round (i.e next round)				}
			}//end if round
		}//end for1
		return table;
	}
//###############################################################################################
//###############################################################################################
	public KindOfElement kindOfElement(Element element) {
			KindOfElement result = new KindOfElement() ;//bulid it or no????????????????????????
			result.kindOfElement = Kind.Error;
			if((element != null)&&(element.childrenSize() > 0)) {//if element.childrenSize() > 0
				Elements children = element.children();
				for(Element child : children) {//for all children
					//round
					if(child.text().contains("Round")) {
						result.refrenceOfElement = child;
						result.kindOfElement = Kind.Round;
						return result;
					}//end round
					
					//date
					if(child.attr("href").contains("matches_today")) {
						result.refrenceOfElement = child;
						result.kindOfElement = Kind.Date;
						return result;
					}//end date
					
					//team
					if(child.attr("href").contains("teams")) {
						result.refrenceOfElement = child;
						result.kindOfElement = Kind.Team;
						return result;
					}//end team
					
					//result of match
					if(child.text().contains(":"))  {
						result.refrenceOfElement = child;
						result.kindOfElement = Kind.Result;
						return result;
					}//end result of match
					
				}//for all children
			}//end if element.childrenSize() > 0
			
			//result for old league
			if(element.text().contains(":") && (element.childrenSize() == 0) ) {
				if((element.nextElementSibling() != null) && (element.nextElementSibling().childrenSize()> 0)//to distinguish  between time (hour) in new league
						&& (element.nextElementSibling().children().hasAttr("href"))){
					return result;
				}
				else {
				result.refrenceOfElement = element;
				result.kindOfElement = Kind.Result;
				return result;
				}
			}////result for old league
			return result;
		}
//###############################################################################################
//###############################################################################################
	void getLastTable(String competition , String years) {
			//build url
			competition = "eng-premier-league-";
			String url = "https://www.worldfootball.net/schedule/" + competition + years + "/";
			
			String htmlPage ;
			htmlPage = sendGetHttpRequest(url);
			
			Document doc;
			doc = Jsoup.parse(htmlPage);
			Elements tables = doc.getElementsByClass("standard_tabelle");
			for(Element table : tables){//for to select table of league
				if(table.childrenSize() > 0) {//if has children $$$$$
					if(table.children().text().contains("#")) {//if #
						Elements rows = table.select("td");
						int position = 1;
						for(Element row : rows) {
							if(kindOfElement(row).kindOfElement.equals(Kind.Team)) {
								
								System.out.print("# ");
								System.out.print(position + "  ");
								System.out.print(row.text() + "    ");
								
								Element information = row.nextElementSibling();
								int informationID = 0;
								while((information != null) && !(kindOfElement(information).kindOfElement.equals(Kind.Team)) ) {
									//played matches
									if(informationID == 0) {
										System.out.print(  "  Played Matches ");
										System.out.print(  information.text());
									}//end played matches
									
									//played win 
									else if(informationID == 1) {
										System.out.print(  "  Win Matches ");
										System.out.print(  information.text());
									}//end win 
									
									//draw
									else if(informationID == 2) {
										System.out.print(  "  Draw Matches ");
										System.out.print(  information.text());
									}//end draw
									
									//lost
									else if(informationID == 3) {
										System.out.print(  "  Lost Matches ");
										System.out.print(  information.text());
									}//end lost
									
									//goals
									else if(informationID == 4) {
										System.out.print(  "  Goals ");
										System.out.print(  information.text());
									}//end goals
									
									//difference
									else if(informationID == 5) {
										System.out.print(  "  Dif ");
										System.out.print(  information.text());
									}//end  difference
									
									//points
									else if(informationID == 6) {
										System.out.print(  "  Points ");
										System.out.print(  information.text());
									}//end  points
								    information = information.nextElementSibling();
									informationID++;
								}
								
								System.out.println();
								//next position
								position++;
							}
						}
					}//end if #
				}//end if has children $$$$$
			}//end for to select table of league
			
				
			
		}
//###############################################################################################
//###############################################################################################
	void getTableByRound(String competition , String years , String round) {
			//build url
			competition = "eng-premier-league-";
			String url = "https://www.worldfootball.net/schedule/" + competition + years +"-spieltag/" + round + "/";
			
			String htmlPage ;
			htmlPage = sendGetHttpRequest(url);
			
			Document doc;
			doc = Jsoup.parse(htmlPage);
			
			Elements tables = doc.getElementsByClass("standard_tabelle");
			for(Element table : tables){//for to select table of league
				if(table.childrenSize() > 0) {//if has children $$$$$
					if(table.children().text().contains("#")) {//if #
						Elements rows = table.select("td");
						int position = 1;
						for(Element row : rows) {
							if(kindOfElement(row).kindOfElement.equals(Kind.Team)) {
								
								System.out.print("# ");
								System.out.print(position + "  ");
								System.out.print(row.text() + "    ");
								
								Element information = row.nextElementSibling();
								int informationID = 0;
								while((information != null) && !(kindOfElement(information).kindOfElement.equals(Kind.Team)) ) {
									//played matches
									if(informationID == 0) {
										System.out.print(  "  Played Matches ");
										System.out.print(  information.text());
									}//end played matches
									
									//played win 
									else if(informationID == 1) {
										System.out.print(  "  Win Matches ");
										System.out.print(  information.text());
									}//end win 
									
									//draw
									else if(informationID == 2) {
										System.out.print(  "  Draw Matches ");
										System.out.print(  information.text());
									}//end draw
									
									//lost
									else if(informationID == 3) {
										System.out.print(  "  Lost Matches ");
										System.out.print(  information.text());
									}//end lost
									
									//goals
									else if(informationID == 4) {
										System.out.print(  "  Goals ");
										System.out.print(  information.text());
									}//end goals
									
									//difference
									else if(informationID == 5) {
										System.out.print(  "  Dif ");
										System.out.print(  information.text());
									}//end  difference
									
									//points
									else if(informationID == 6) {
										System.out.print(  "  Points ");
										System.out.print(  information.text());
									}//end  points
								    information = information.nextElementSibling();
									informationID++;
								}
								
								System.out.println();
								//next position
								position++;
							}
						}
					}//end if #
				}//end if has children $$$$$
			}//end for to select table of league
			
		}
//###############################################################################################
//###############################################################################################
	boolean hasFirstHalf(String result) {
			if(result.contains("(")) {
				return true;
			}
			return false;			
		}
//###############################################################################################
//##############################################################################################
	void getAllGamesOfLeague(String competition , String years) {
		String numberOfRound;
		String dateOfGame ="";
		String timeOfGame ="";
		String firstTeam ="";
		String secondTeam = "";
		String resultOfGame = "";
		String url;
		competition = "eng-premier-league-";
		url = "https://www.worldfootball.net/all_matches/" + competition + years + "/" ;
		
		String htmlPage ;
		htmlPage = sendGetHttpRequest(url);
		
		Document doc;
		doc = Jsoup.parse(htmlPage);
		Elements resultTable = doc.getElementsByClass("standard_tabelle");
		Elements rows = resultTable.select("tr");
		for(Element row : rows) {
			
			if(kindOfElement(row).kindOfElement.equals(Kind.Round)) {//round
				//the round
				numberOfRound = row.text();
				System.out.println(numberOfRound);

				int i = 0;
				row = row.nextElementSibling();
				while((row != null)
						&& (kindOfElement(row).kindOfElement.equals(Kind.Round) == false)
						&& (row.childrenSize() == 7 )
						
						)
				{
					
						//date child(0)
						if(kindOfElement(row.child(0)).kindOfElement.equals(Kind.Date)) {
							dateOfGame = row.child(0).text();
							
						}//end date
					 
						//time child(1)
						if(row.child(1).hasText()) {
							timeOfGame = row.child(1).text();
							
						}
						//end time
					
						//first team child 2
						if(kindOfElement(row.child(2)).kindOfElement.equals(Kind.Team)) {
							firstTeam = row.child(2).text();
							
						}//end first team
					
						//second team  child 4
						if(kindOfElement(row.child(4)).kindOfElement.equals(Kind.Team)) {
							secondTeam = row.child(4).text();
							
						}//end second team
					
						//result child 5
						if(kindOfElement(row.child(5)).kindOfElement.equals(Kind.Result)) {
							resultOfGame = row.child(5).text();
							
							if(hasFirstHalf(resultOfGame)) {
								if(row.child(5).attr("href").contains("/report/premier-league-" + years)) {
									getEventsOfGame(row.child(5));								
								}
							}
							System.out.print(dateOfGame + "  ");
							System.out.print(timeOfGame + "  ");
							System.out.print(firstTeam + "  vs  ");
							System.out.print(secondTeam + "  ");
							System.out.println(resultOfGame + "  ");
						}//end result
						
					i++;
					row = row.nextElementSibling();
				}//end while
				
			}//end round
		}	
	}
//###############################################################################################
//##############################################################################################	
void getEventsOfGame(Element game) {

		String gameURL ;
		gameURL ="https://www.worldfootball.net" + game.attr("href");
		String htmlPage ;
		htmlPage = sendGetHttpRequest(gameURL);
		
		Document doc;//select("td[text()*=goals]");
		doc = Jsoup.parse(htmlPage);
		Elements tables = doc.getElementsByClass("standard_tabelle");
		Element goals = getTable(tables); 
		
		System.out.println(goals);
		
			}
void getEventsOfGame(String game) {

	String gameURL ;
	Goal goal;
	List <Goal> goals = new ArrayList<>();
	gameURL = game;
	String htmlPage ;
	htmlPage = sendGetHttpRequest(gameURL);
	
	Document doc;//select("td[text()*=goals]");
	doc = Jsoup.parse(htmlPage);
	Elements tables = doc.getElementsByClass("standard_tabelle");
	Element tableOfGoals = getTable(tables); 
	Elements rowOfGoals = tableOfGoals.select("tr");
	for (Element rowOfGoal : rowOfGoals) {
		if (rowOfGoal.text().contains("goals")) {//if the header
			System.out.println("GOALS");
		}//if end the header
		else if (rowOfGoal.text().contains(":")) {//it is goal
			goal = new Goal();
			if(kindOfGoal(rowOfGoal).equals(KindOfGoal.HasAssister)) {
				goal.kind = KindOfGoal.HasAssister;
				goal.result = rowOfGoal.child(0).text();
				goal.player = rowOfGoal.child(1).child(0).attr("title");
				goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
				goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/")+1, rowOfGoal.child(1).ownText().indexOf("("));
				goal.assest = rowOfGoal.child(1).child(1).attr("title");
				goal.printGoal();
			}
			else if(kindOfGoal(rowOfGoal).equals(KindOfGoal.Individually)){
				goal.kind = KindOfGoal.Individually;
				goal.result = rowOfGoal.child(0).text();
				goal.player = rowOfGoal.child(1).child(0).attr("title");
				goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
				goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/")+1);
				goal.printGoal();
			}
			else if(kindOfGoal(rowOfGoal).equals(KindOfGoal.Reverse)) {
				goal.kind = KindOfGoal.Reverse;
				goal.result = rowOfGoal.child(0).text();
				goal.player = rowOfGoal.child(1).child(0).attr("title");
				goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
				goal.information = "Own Goal";
				goal.printGoal();
				//goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/")+1);
			}
		}//end it is goal
	} 
	
		}
//###############################################################################################
//##############################################################################################
Element getTable(Elements tables) {
	Element tableOfGoals = null;
	for(Element table : tables) {
		if(table.text().contains("goals")) {
			return table;
		}
	}
	return tableOfGoals;
}
//###############################################################################################
//##############################################################################################
KindOfGoal kindOfGoal(Element goal) {
	int numberOfPlayer= 0;
	
	if(goal.childrenSize() ==2) {
		
		for (Element grandson : goal.child(1).children()) {
			if(grandson.hasAttr("href")) {
				numberOfPlayer++;				
			}
		}
		if(numberOfPlayer == 2) {//to do
			return  KindOfGoal.HasAssister;
		}
		
			if(goal.text().contains("own")) {
				return KindOfGoal.Reverse;
			}
			else {
				return KindOfGoal.Individually;
			
		}
		
	}
	return KindOfGoal.Error;
	
}
//###############################################################################################
//##############################################################################################

}//end ScreenScraper

