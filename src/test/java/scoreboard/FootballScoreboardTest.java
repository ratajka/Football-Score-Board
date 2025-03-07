package scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scoreboard.model.Team;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    void setup() {
        List<Match> footballMatches = new ArrayList<>();
        scoreboard = new FootballScoreboard(footballMatches);
    }

    @Test
    void shouldAddNewMatch() {
        //given
        Team homeTeam = new Team("Spain");
        Team awayTeam = new Team("Brazil");

        //when
        scoreboard.addMatch(homeTeam, awayTeam);

        //then
        assertFalse(scoreboard.getMatches().isEmpty());
        assertTrue(scoreboard.getMatches().stream().anyMatch(match -> "Spain".equals(match.getHomeTeam().getName())));
        assertTrue(scoreboard.getMatches().stream().anyMatch(match -> "Brazil".equals(match.getAwayTeam().getName())));

    }

}