package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.ClubTransferTable;
import models.TransferDestination;
import models.TransferPlayerInformation;

public class TransferCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_TRANSFER_URL = "https://www.worldfootball.net/transfers/";


    public ArrayList<ClubTransferTable> getClubsTransferTableAtSeason(String competitionName, String competiotionYears) {
        String url = WORLD_FOOTBALL_TRANSFER_URL + competitionName + "-" + competiotionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);

        Document doc = Jsoup.parse(htmlPage);
        Elements divs1 = doc.select("div:has(div:has(h2))");
        ArrayList<Element> divs = getTransferDivs(divs1);
        ArrayList<ClubTransferTable> result = new ArrayList<>();
        for (Element div : divs) {
            ClubTransferTable clubTransferTable = new ClubTransferTable();
            clubTransferTable.clubBasicInfo.name = div.child(0).child(0).text().substring(0, div.child(0).child(0).text().indexOf("» ") - 1);
            clubTransferTable.season = competiotionYears;
            Elements trs = div.child(1).getElementsByTag("tr");

            for (int i = 0; i < trs.size(); i++) {
                if (trs.get(i).text().equals("In")) {
                    int j = i + 1;
                    while ((j < trs.size()) && (!(trs.get(j).text().equals("Out")))) {
                        clubTransferTable.intable.add(getPlayerTransferInformation(trs.get(j) ,clubTransferTable.clubBasicInfo.name ,TransferDestination.In) );
                        j++;
                    }
                } else if (trs.get(i).text().equals("Out")) {
                    int j = i + 1;
                    while ((j < trs.size())) {
                        clubTransferTable.outtable.add(getPlayerTransferInformation(trs.get(j) ,clubTransferTable.clubBasicInfo.name ,TransferDestination.Out));
                        j++;
                    }
                }
            }
            result.add(clubTransferTable);
        }
        return result;
    }

    //may we change TransferPlayerInformation to contain one club, table in the destination club is the same club , table out out from is the same club
    private TransferPlayerInformation getPlayerTransferInformation(Element tr ,String clubName ,TransferDestination kindOfTransfer) {
    	TransferPlayerInformation player = new TransferPlayerInformation();

    	player.date =                 tr.child(0).text();
        player.playerBasicInfo.name = tr.child(1).text();
        player.playerNation =         tr.child(2).child(0).attr("title");
        player.playerPosition =       tr.child(3).text();
        if(kindOfTransfer == TransferDestination.In) {
	        player.fromClub.name = tr.child(5).text();
	        player.toClub.name   = clubName;
        }
        else {
        	player.toClub.name   = tr.child(5).text();
            player.fromClub.name = clubName;
        }
        return player;
    }
    private ArrayList<Element> getTransferDivs(Elements divs) {
        ArrayList<Element> result = new ArrayList<>();
        for (Element div : divs) {
            if (div.childrenSize() >= 2) {
                if (div.child(0).tagName().equals("div") && (div.child(1).tagName().equals("div"))) {
                    if (div.child(0).childrenSize() > 0) {
                        if ((div.child(0).child(0).tagName().equals("h2")) &&
                                (div.child(0).child(0).ownText().contains("Transfers"))) {
                            result.add(div);
                        }
                    }
                }
            }
        }
        return result;
    }

    public ClubTransferTable getTransferTableByClubName(ArrayList<ClubTransferTable> table, String ClubName) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).clubBasicInfo.name.contains(ClubName)) {
                return table.get(i);
            }
        }
        throw new RuntimeException("Club Transfer Not Found");
    }
}
