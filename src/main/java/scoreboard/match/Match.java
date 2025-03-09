package scoreboard.match;

import scoreboard.model.Team;

import java.time.LocalDateTime;

public interface Match {

    int getScore();

    Team getHomeTeam();

    Team getAwayTeam();

    LocalDateTime getStartTime();

}
