package cricket.web;

import cricket.domain.Player;
import cricket.domain.Team;
import cricket.exceptions.PlayersExceededException;
import cricket.web.persistence.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeam(@PathVariable long id) throws PlayersExceededException {
        Team team = teamRepository.findById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(value = "sample", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeamSample() throws PlayersExceededException {
        Team team = new Team();
        team.setName("testName");
        team.setId(1);

        Player player1 = new Player();
        player1.setName("samplePlayer1");
        player1.setBattingHand(Player.BattingHand.Right);
        player1.setBowlingType(Player.BowlingType.LEFT_ARM_FAST);
        team.addPlayer(player1);

        Player player2 = new Player();
        player2.setName("samplePlayer2");
        player2.setBattingHand(Player.BattingHand.Right);
        player2.setBowlingType(Player.BowlingType.RIGHT_ARM_MEDIUM);
        team.addPlayer(player2);

        team.setCaptain(player1);

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(teamRepository.findById(team.getId()), HttpStatus.OK);
    }
}
