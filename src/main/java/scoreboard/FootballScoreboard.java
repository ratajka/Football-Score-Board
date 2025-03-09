package scoreboard;

import scoreboard.exception.ScoreboardException;
import scoreboard.model.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FootballScoreboard implements Scoreboard {

    private final List<Match> footballMatches;
    private final List<Match> summary = new ArrayList<>();

    public FootballScoreboard(List<Match> footballMatches) {
        this.footballMatches = footballMatches;
    }

    @Override
    public void startMatch(Team homeTeam, Team awayTeam) {
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

    @Override
    public void updateScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore) {
        for (Match match : footballMatches) {
            if (match.getHomeTeam().getName().equals(homeTeam.getName()) && match.getAwayTeam().getName().equals(awayTeam.getName())) {
                homeTeam.setScore(homeScore);
                awayTeam.setScore(awayScore);
            }
        }
    }

    @Override
    public void finishMatch(Team homeTeam, Team awayTeam) {
        FootballMatch footballMatch = new FootballMatch(homeTeam, awayTeam);
        if (!footballMatches.contains(footballMatch)) {
            throw new ScoreboardException("This Match does not exist");
        }
        summary.add(footballMatch);
        footballMatches.remove(footballMatch);
    }

    @Override
    public List<Match> getSummary() {
        summary.sort(
                Comparator.comparing(Match::getScore)
                        .thenComparing(Match::getStartTime)
                        .reversed()
        );
        return summary;
    }
}
