package cricket.web;

import cricket.domain.Player;
import cricket.domain.Team;
import cricket.exceptions.PlayersExceededException;
import cricket.web.persistence.PlayerRepository;
import cricket.web.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harish Chakravarthy
 */
@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Team> getTeam() throws PlayersExceededException {

        Team team = new Team();
        Player player;

        for (int i = 0; i <= 11; i++) {
            player = new Player();
            player.setName("player " + i++);
            playerRepository.save(player);
            team.addPlayer(player);
        }

        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
