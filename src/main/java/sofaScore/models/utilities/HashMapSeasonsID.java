package sofaScore.models.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//best to put every competition in one object
public class HashMapSeasonsID {

	public HashMap<SeasonIDObject, String> seasonsID ;

	public HashMapSeasonsID() {
		this.seasonsID = new HashMap<>();

		seasonsID.put(new SeasonIDObject("Premier League", "2020/2021"),"29415");
		seasonsID.put(new SeasonIDObject("Premier League", "2019/2020"),"23776");
		seasonsID.put(new SeasonIDObject("Premier League", "2018/2019"),"17359");
		seasonsID.put(new SeasonIDObject("Premier League", "2017/2018"),"13380");
		seasonsID.put(new SeasonIDObject("Premier League", "2016/2017"),"11733");
		seasonsID.put(new SeasonIDObject("Premier League", "2015/2016"),"10356");
		seasonsID.put(new SeasonIDObject("Premier League", "2014/2015"),"8186");
		seasonsID.put(new SeasonIDObject("Premier League", "2013/2014"),"6311");
		seasonsID.put(new SeasonIDObject("Premier League", "2012/2013"),"4710");
		seasonsID.put(new SeasonIDObject("Premier League", "2011/2012"),"3391");
		seasonsID.put(new SeasonIDObject("Premier League", "2010/2011"),"2746");
		seasonsID.put(new SeasonIDObject("Premier League", "2009/2010"),"2139");
		seasonsID.put(new SeasonIDObject("Premier League", "2008/2009"),"1544");
		seasonsID.put(new SeasonIDObject("Premier League", "2007/2008"),"581");
		seasonsID.put(new SeasonIDObject("Premier League", "2006/2007"),"4");
		seasonsID.put(new SeasonIDObject("Premier League", "2005/2006"),"3");
		seasonsID.put(new SeasonIDObject("Premier League", "2004/2005"),"2");
		seasonsID.put(new SeasonIDObject("Premier League", "2003/2004"),"1");
		seasonsID.put(new SeasonIDObject("Premier League", "2002/2003"),"46");
		seasonsID.put(new SeasonIDObject("Premier League", "2001/2002"),"47");
		seasonsID.put(new SeasonIDObject("Premier League", "2000/2001"),"48");
		seasonsID.put(new SeasonIDObject("Premier League", "1999/2000"),"49");
		seasonsID.put(new SeasonIDObject("Premier League", "1998/1999"),"50");
		seasonsID.put(new SeasonIDObject("Premier League", "1997/1998"),"51");
		seasonsID.put(new SeasonIDObject("Premier League", "1996/1997"),"25682");
		seasonsID.put(new SeasonIDObject("Premier League", "1995/1996"),"25681");
		seasonsID.put(new SeasonIDObject("Premier League", "1994/1995"),"29167");
		seasonsID.put(new SeasonIDObject("Premier League", "1993/1994"),"25680");
		seasonsID.put(new SeasonIDObject("LaLiga", "2020/2021"),"32501");
		seasonsID.put(new SeasonIDObject("LaLiga", "2019/2020"),"24127");
		seasonsID.put(new SeasonIDObject("LaLiga", "2018/2019"),"18020");
		seasonsID.put(new SeasonIDObject("LaLiga", "2017/2018"),"13662");
		seasonsID.put(new SeasonIDObject("LaLiga", "2016/2017"),"11906");
		seasonsID.put(new SeasonIDObject("LaLiga", "2015/2016"),"10495");
		seasonsID.put(new SeasonIDObject("LaLiga", "2014/2015"),"8578");
		seasonsID.put(new SeasonIDObject("LaLiga", "2013/2014"),"6559");
		seasonsID.put(new SeasonIDObject("LaLiga", "2012/2013"),"4959");
		seasonsID.put(new SeasonIDObject("LaLiga", "2011/2012"),"3502");
		seasonsID.put(new SeasonIDObject("LaLiga", "2010/2011"),"2896");
		seasonsID.put(new SeasonIDObject("LaLiga", "2009/2010"),"2252");
		seasonsID.put(new SeasonIDObject("LaLiga", "2008/2009"),"1587");
		seasonsID.put(new SeasonIDObject("LaLiga", "2007/2008"),"669");
		seasonsID.put(new SeasonIDObject("LaLiga", "2006/2007"),"102");
		seasonsID.put(new SeasonIDObject("LaLiga", "2005/2006"),"101");
		seasonsID.put(new SeasonIDObject("LaLiga", "2004/2005"),"100");
		seasonsID.put(new SeasonIDObject("LaLiga", "2003/2004"),"99");
		seasonsID.put(new SeasonIDObject("LaLiga", "2002/2003"),"70");
		seasonsID.put(new SeasonIDObject("LaLiga", "2001/2002"),"71");
		seasonsID.put(new SeasonIDObject("LaLiga", "2000/2001"),"72");
		seasonsID.put(new SeasonIDObject("LaLiga", "1999/2000"),"73");
		seasonsID.put(new SeasonIDObject("LaLiga", "1998/1999"),"74");
		seasonsID.put(new SeasonIDObject("LaLiga", "1997/1998"),"75");
		seasonsID.put(new SeasonIDObject("LaLiga", "1996/1997"),"25689");
		seasonsID.put(new SeasonIDObject("LaLiga", "1995/1996"),"25690");
		seasonsID.put(new SeasonIDObject("LaLiga", "1994/1995"),"25688");
		seasonsID.put(new SeasonIDObject("LaLiga", "1993/1994"),"25687");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2020/2021"),"28210");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2019/2020"),"23538");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2018/2019"),"17597");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2017/2018"),"13477");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2016/2017"),"11818");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2015/2016"),"10419");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2014/2015"),"8238");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2013/2014"),"6303");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2012/2013"),"4792");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2011/2012"),"3405");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2010/2011"),"2811");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2009/2010"),"2188");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2008/2009"),"1557");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2007/2008"),"525");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2006/2007"),"94");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2005/2006"),"93");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2004/2005"),"92");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2003/2004"),"91");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2002/2003"),"90");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2001/2002"),"103");
		seasonsID.put(new SeasonIDObject("Bundesliga", "2000/2001"),"104");
		seasonsID.put(new SeasonIDObject("Bundesliga", "1999/2000"),"105");
		seasonsID.put(new SeasonIDObject("Bundesliga", "1998/1999"),"106");
		seasonsID.put(new SeasonIDObject("Bundesliga", "1997/1998"),"107");
		seasonsID.put(new SeasonIDObject("Serie A", "2020/2021"),"32523");
		seasonsID.put(new SeasonIDObject("Serie A", "2019/2020"),"24644");
		seasonsID.put(new SeasonIDObject("Serie A", "2018/2019"),"17932");
		seasonsID.put(new SeasonIDObject("Serie A", "2017/2018"),"13768");
		seasonsID.put(new SeasonIDObject("Serie A", "2016/2017"),"11966");
		seasonsID.put(new SeasonIDObject("Serie A", "2015/2016"),"10596");
		seasonsID.put(new SeasonIDObject("Serie A", "2014/2015"),"8618");
		seasonsID.put(new SeasonIDObject("Serie A", "2013/2014"),"6797");
		seasonsID.put(new SeasonIDObject("Serie A", "2012/2013"),"5145");
		seasonsID.put(new SeasonIDObject("Serie A", "2011/2012"),"3639");
		seasonsID.put(new SeasonIDObject("Serie A", "2010/2011"),"2930");
		seasonsID.put(new SeasonIDObject("Serie A", "2009/2010"),"2324");
		seasonsID.put(new SeasonIDObject("Serie A", "2008/2009"),"1552");
		seasonsID.put(new SeasonIDObject("Serie A", "2007/2008"),"712");
		seasonsID.put(new SeasonIDObject("Serie A", "2006/2007"),"98");
		seasonsID.put(new SeasonIDObject("Serie A", "2005/2006"),"97");
		seasonsID.put(new SeasonIDObject("Serie A", "2004/2005"),"96");
		seasonsID.put(new SeasonIDObject("Serie A", "2003/2004"),"95");
		seasonsID.put(new SeasonIDObject("Serie A", "2002/2003"),"80");
		seasonsID.put(new SeasonIDObject("Serie A", "2001/2002"),"81");
		seasonsID.put(new SeasonIDObject("Serie A", "2000/2001"),"82");
		seasonsID.put(new SeasonIDObject("Serie A", "1999/2000"),"83");
		seasonsID.put(new SeasonIDObject("Serie A", "1998/1999"),"84");
		seasonsID.put(new SeasonIDObject("Serie A", "1997/1998"),"85");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2020/2021"),"28222");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2019/2020"),"23872");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2018/2019"),"17279");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2017/2018"),"13384");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2016/2017"),"11648");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2015/2016"),"10373");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2014/2015"),"8122");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2013/2014"),"6271");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2012/2013"),"4616");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2011/2012"),"3380");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2010/2011"),"2719");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2009/2010"),"2120");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2008/2009"),"1542");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2007/2008"),"534");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2006/2007"),"56");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2005/2006"),"57");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2004/2005"),"58");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2003/2004"),"59");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2002/2003"),"60");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2001/2002"),"61");
		seasonsID.put(new SeasonIDObject("Ligue 1", "2000/2001"),"62");
		seasonsID.put(new SeasonIDObject("Ligue 1", "1999/2000"),"63");
		seasonsID.put(new SeasonIDObject("Ligue 1", "1998/1999"),"64");
		seasonsID.put(new SeasonIDObject("Ligue 1", "1997/1998"),"65");

	}
	
	public String getSeasonID(String competitionName , String competitionYear) {
		
		for(SeasonIDObject key : seasonsID.keySet()) {
			if((key.competitionName.equals(competitionName)) && (key.years.equals(competitionYear))){
				return 	seasonsID.get( new SeasonIDObject(competitionName, competitionYear));
				
			}
		}
		throw new RuntimeException("no information about "+competitionName+"  at  "+competitionYear);
	}
	
	public List<String> getAllSeasonIDs(String competitionName, String startSeason) {
		
		List<String> result = Arrays.asList();
		for(SeasonIDObject key : seasonsID.keySet()) {
			if(key.competitionName.equals(competitionName)) {
				int keyYear =Integer.valueOf(key.years.substring(0,key.years.indexOf('/')));
				int startYear =Integer.valueOf(startSeason.substring(0,startSeason.indexOf('/')));
				if(keyYear >= startYear) {
					result.add(seasonsID.get(key));
				}
			}
		}
		if(result == null || result.isEmpty()) {return null;}
		Collections.sort(result);
		return result;
	}
	

	public List<String> getAllSeasonIDs(String competitionName , String startSeason , String endSeason) {
		
		List<String> result = Arrays.asList();
		for(SeasonIDObject key : seasonsID.keySet()) {
			if(key.competitionName.equals(competitionName)) {
				int keyYear =Integer.valueOf(key.years.substring(0,key.years.indexOf('/')));
				int startYear =Integer.valueOf(startSeason.substring(0,startSeason.indexOf('/')));
				int endYear =Integer.valueOf(endSeason.substring(0,endSeason.indexOf('/')));
				if((endYear >= keyYear) && (keyYear>= startYear)) {
					result.add(seasonsID.get(key));
				}
			}
		}
		if(result == null || result.isEmpty()) {return null;}
		Collections.sort(result);
		return result;
	}
		

	public List<SeasonIDObject> getAllSeasonInfo(String competitionName , String startSeason) {
		
		List<SeasonIDObject> result = new ArrayList<> (Arrays.asList());
		for(SeasonIDObject key : seasonsID.keySet()) {
			if(key.competitionName.equals(competitionName)) {
				int keyYear =Integer.valueOf(key.years.substring(0,key.years.indexOf('/')));
				int startYear =Integer.valueOf(startSeason.substring(0,startSeason.indexOf('/')));
				if (keyYear>= startYear) {
					result.add(key);
				}
			}
		}
		if(result == null || result.isEmpty()) {return null;}
		Collections.sort(result);
		return result;
	}

	public List<SeasonIDObject> getAllSeasonInfo(String competitionName , String startSeason , String endSeason) {
		
		List<SeasonIDObject> result = new ArrayList<>(Arrays.asList());
		for(SeasonIDObject key : seasonsID.keySet()) {
			if(key.competitionName.equals(competitionName)) {
				int keyYear =Integer.valueOf(key.years.substring(0,key.years.indexOf('/')));
				int startYear =Integer.valueOf(startSeason.substring(0,startSeason.indexOf('/')));
				int endYear =Integer.valueOf(endSeason.substring(0,endSeason.indexOf('/')));
				if((endYear >= keyYear) && (keyYear>= startYear)) {
					result.add(key);
				}
			}
		}
		if(result == null || result.isEmpty()) {return null;}
		Collections.sort(result);
		return result;
	}

}


