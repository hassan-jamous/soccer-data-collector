package sofaScore.models;

public class IencidentInGame_VarDecision implements Iencident {

    public String confirmed;
    public IencidentInGame_Player player;
    public String isHome;
    public String id;
    public String time;
    public String incidentClass;
    public String incidentType;

    public IencidentInGame_VarDecision() {
        player = new IencidentInGame_Player();
    }

    public IencidentInGame_VarDecision(String confirmed, IencidentInGame_Player player, String isHome, String id, String time,
                                       String incidentClass, String incidentType) {
        this();
        this.confirmed = confirmed;
        this.id = id;
        this.incidentClass = incidentClass;
        this.incidentType = incidentType;
        this.isHome = isHome;
        this.player = player;
        this.time = time;
    }
}
