package scoreboard.match;

import scoreboard.model.Team;

import java.time.LocalDateTime;
import java.util.Objects;

public class FootballMatch implements Match {

    private final Team homeTeam;
    private final Team awayTeam;
    private final LocalDateTime startTime;


    public FootballMatch(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = LocalDateTime.now();
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
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballMatch footballMatch = (FootballMatch) o;
        return Objects.equals(homeTeam.getName(), footballMatch.homeTeam.getName())
                && Objects.equals(awayTeam.getName(), footballMatch.awayTeam.getName());
    }
}
