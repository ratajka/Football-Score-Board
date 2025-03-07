package scoreboard;

import scoreboard.model.Team;

import java.util.List;

public interface Scoreboard {

    void addMatch(Team hometeam, Team awayTeam);

    List<Match> getMatches();
}
