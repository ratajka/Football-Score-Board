package scoreboard;

import scoreboard.model.Team;

public class FootballMatch implements Match {

    private final Team homeTeam;
    private final Team awayTeam;


    public FootballMatch(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public Team getHomeTeam() {
        return null;
    }

    @Override
    public Team getAwayTeam() {
        return null;
    }
}
