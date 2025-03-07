package scoreboard;

import scoreboard.model.Team;

import java.util.List;

public interface Scoreboard {

    void addMatch(Team homeTeam, Team awayTeam);

    List<Match> getMatches();
}
