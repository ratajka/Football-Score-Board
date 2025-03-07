package scoreboard;

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

        footballMatches.add(footballMatch);

    }

    @Override
    public List<Match> getMatches() {
        return footballMatches;
    }
}
