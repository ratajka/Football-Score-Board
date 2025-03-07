package scoreboard;

import scoreboard.model.Team;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o ) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballMatch footballMatch = (FootballMatch) o;
        return Objects.equals(homeTeam.getName(), footballMatch.homeTeam.getName())
                && Objects.equals(awayTeam.getName(), footballMatch.awayTeam.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }
}
