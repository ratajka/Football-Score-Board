package scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scoreboard.exception.ScoreboardException;
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

    @Test
    void shouldNotAddNewMatchWhenSameMatchExists() {
        //given
        Team homeTeam = new Team("Spain");
        Team awayTeam = new Team("Brazil");

        Team homeTeam1 = new Team("Spain");
        Team awayTeam1 = new Team("Brazil");

        //when
        scoreboard.addMatch(homeTeam, awayTeam);

        //then
        assertThrows(ScoreboardException.class, () -> scoreboard.addMatch(homeTeam1, awayTeam1));
    }

    @Test
    void shouldUpdateScore() {
        //given
        Team homeTeam = new Team("Mexico");
        Team awayTeam = new Team("Canada");

        scoreboard.addMatch(homeTeam, awayTeam);

        homeTeam.setScore(0);
        awayTeam.setScore(5);
        //when
        scoreboard.updateScore(homeTeam, awayTeam);

        //then
        assertEquals(0, homeTeam.getScore());
        assertEquals(5, awayTeam.getScore());

    }

    @Test
    void shouldRemoveMatchFromScoreboard() {
        //then
        Team homeTeam = new Team("Germany");
        Team awayTeam = new Team("France");

        scoreboard.addMatch(homeTeam, awayTeam);
        //when
        scoreboard.removeMatch(homeTeam, awayTeam);
        //then
        assertTrue(scoreboard.getMatches().isEmpty());
    }

}