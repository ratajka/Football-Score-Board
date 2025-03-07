package scoreboard;

import org.junit.jupiter.api.Test;
import scoreboard.model.Team;

import static org.junit.jupiter.api.Assertions.*;

class FootballMatchTest {

    private FootballMatch footballMatch;

    @Test
    void itShouldGetNameTeams() {
        //given
        Team homeTeam = new Team("Uruguay");
        Team awayTeam = new Team("Italy");

        //when
        FootballMatch footballMatch1 = new FootballMatch(homeTeam, awayTeam);

        //then
        assertEquals("Uruguay", footballMatch1.getHomeTeam().getName());
        assertEquals("Italy", footballMatch1.getAwayTeam().getName());

    }

}