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
        return homeTeam.getScore() + awayTeam.getScore();
    }

    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }
}
