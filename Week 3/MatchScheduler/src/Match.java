public class Match {
    private String homeTeam;
    private String opponentTeam;

    public Match(String homeTeam, String opponentTeam) {
        this.homeTeam = homeTeam;
        this.opponentTeam = opponentTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    @Override
    public String toString() {
        return homeTeam + " vs " + opponentTeam;
    }
}
