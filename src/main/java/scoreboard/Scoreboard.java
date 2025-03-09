package scoreboard;

import scoreboard.match.Match;
import scoreboard.model.Team;

import java.util.List;

public interface Scoreboard {

    void startMatch(Team homeTeam, Team awayTeam);

    List<Match> getMatches();

    void updateScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore);

    void finishMatch(Team homeTeam, Team awayTeam);

    List<Match> getSummary();
}
