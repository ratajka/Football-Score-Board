package scoreboard;

import scoreboard.exception.ScoreboardException;
import scoreboard.model.Team;

import java.util.List;

public class FootballScoreboard implements Scoreboard {

    private final List<Match> footballMatches;

    public FootballScoreboard(List<Match> footballMatches) {
        this.footballMatches = footballMatches;
    }

    @Override
    public void addMatch(Team homeTeam, Team awayTeam) {
        FootballMatch footballMatch = new FootballMatch(homeTeam, awayTeam);
        if (footballMatches.contains(footballMatch)) {
            throw new ScoreboardException(
                    "It is not possible to add the same match"
            );
        }

        footballMatches.add(new FootballMatch(homeTeam, awayTeam));

    }

    @Override
    public List<Match> getMatches() {
        return footballMatches;
    }
}
