package worldfootball.models;

public enum StatisticsRequestKind {

    RecordWins(3),
    MostGoalInGame(4);

    int value;

    StatisticsRequestKind(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
