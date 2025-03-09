package scoreboard;

import scoreboard.model.Team;

import java.util.List;

public interface Scoreboard {

    void addMatch(Team homeTeam, Team awayTeam);

    List<Match> getMatches();

    void updateScore(Team homeTeam, Team awayTeam, int homeScore, int awayScore);

    void removeMatch(Team homeTeam, Team awayTeam);

    List<Match> getSummary();
}
