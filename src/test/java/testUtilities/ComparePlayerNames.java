package testUtilities;

import java.util.Comparator;

import worldfootball.models.PlayerAtMatch;

public class ComparePlayerNames implements Comparator<PlayerAtMatch> {
    @Override
    public int compare(PlayerAtMatch player1, PlayerAtMatch player2) {
        if (player1.playerBasicInfo.name.compareTo(player2.playerBasicInfo.name) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
