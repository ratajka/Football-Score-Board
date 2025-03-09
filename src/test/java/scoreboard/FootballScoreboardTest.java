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
        scoreboard.updateScore(homeTeam, awayTeam, 0, 5);

        //then
        assertEquals(0, homeTeam.getScore());
        assertEquals(5, awayTeam.getScore());

    }

    @Test
    void shouldRemoveMatchFromScoreboard() {
        //given
        Team homeTeam = new Team("Germany");
        Team awayTeam = new Team("France");

        scoreboard.addMatch(homeTeam, awayTeam);
        //when
        scoreboard.removeMatch(homeTeam, awayTeam);
        //then
        assertTrue(scoreboard.getMatches().isEmpty());
    }

    @Test
    void shouldNotRemoveMatchWhenIsNotExist() {
        //given
        Team homeTeam = new Team("USA");
        Team awayTeam = new Team("Poland");

        //then
        assertThrows(ScoreboardException.class, () -> scoreboard.removeMatch(homeTeam, awayTeam));
    }

    @Test
    void shouldReturnSummary(){
        //given
        Team homeTeam1 = new Team("Mexico");
        Team awayTeam1 = new Team("Canada");

        Team homeTeam2 = new Team("Spain");
        Team awayTeam2 = new Team("Brazil");

        Team homeTeam3 = new Team("Germany");
        Team awayTeam3 = new Team("France");

        Team homeTeam4 = new Team("Uruguay");
        Team awayTeam4 = new Team("Italy");

        Team homeTeam5 = new Team("Argentina");
        Team awayTeam5 = new Team("Australia");

        scoreboard.addMatch(homeTeam1, awayTeam1);
        scoreboard.updateScore(homeTeam1, awayTeam1, 0,5);

        scoreboard.addMatch(homeTeam2, awayTeam2);
        scoreboard.updateScore(homeTeam2, awayTeam2, 10,2);

        scoreboard.addMatch(homeTeam3, awayTeam3);
        scoreboard.updateScore(homeTeam3, awayTeam3, 2,2);

        scoreboard.addMatch(homeTeam4, awayTeam4);
        scoreboard.updateScore(homeTeam4, awayTeam4, 6,6);

        scoreboard.addMatch(homeTeam5, awayTeam5);
        scoreboard.updateScore(homeTeam5, awayTeam5, 3,1);

        //when
        List <Match> orderedFootballMatches = scoreboard.getSummary();

        //then
        assertFalse(orderedFootballMatches.isEmpty());

        assertEquals(new FootballMatch(homeTeam4, awayTeam4), orderedFootballMatches.get(0));
        assertEquals(new FootballMatch(homeTeam2, awayTeam2), orderedFootballMatches.get(1));
        assertEquals(new FootballMatch(homeTeam1, awayTeam1), orderedFootballMatches.get(2));
        assertEquals(new FootballMatch(homeTeam5, awayTeam5), orderedFootballMatches.get(3));
        assertEquals(new FootballMatch(homeTeam3, awayTeam3), orderedFootballMatches.get(4));

    }

}