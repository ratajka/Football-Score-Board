package scoreboard;

import scoreboard.model.Team;

public interface Match {

    int getScore();

    Team getHomeTeam();

    Team getAwayTeam();

}
