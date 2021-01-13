package worldfootball.models;

import java.util.ArrayList;

public class RankingTable {
    public ArrayList<ClubForRankingTable> table;

    public RankingTable() {
        table = new ArrayList<>();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < table.size(); i++) {
            result = result + table.get(i).toString();
        }
        return result;
    }

}
