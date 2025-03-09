package scoreboard;

import org.junit.jupiter.api.Test;
import scoreboard.model.Team;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FootballMatchTest {


    @Test
    void shouldGetNameTeams() {
        //given
        Team homeTeam = new Team("Uruguay");
        Team awayTeam = new Team("Italy");

        //when
        FootballMatch footballMatch = new FootballMatch(homeTeam, awayTeam);

        //then
        assertEquals("Uruguay", footballMatch.getHomeTeam().getName());
        assertEquals("Italy", footballMatch.getAwayTeam().getName());

    }

    @Test
    void shouldGetScorePerTeam() {
        //given
        Team homeTeam = new Team("Uruguay");
        Team awayTeam = new Team("Italy");

        //when
        FootballMatch footballMatch = new FootballMatch(homeTeam, awayTeam);
        homeTeam.setScore(6);
        awayTeam.setScore(6);

        //then
        assertEquals(6, footballMatch.getHomeTeam().getScore());
        assertEquals(6, footballMatch.getAwayTeam().getScore());
    }

    @Test
    void shouldGetMatchScore() {
        //given
        Team homeTeam = new Team("Uruguay");
        Team awayTeam = new Team("Italy");

        //when
        FootballMatch footballMatch = new FootballMatch(homeTeam, awayTeam);
        homeTeam.setScore(6);
        awayTeam.setScore(6);

        //then
        assertEquals(12, footballMatch.getScore());
    }

}