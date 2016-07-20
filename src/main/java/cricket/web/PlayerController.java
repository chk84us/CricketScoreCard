package cricket.web;

import cricket.domain.Player;
import cricket.web.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Chakravarthy
 */
@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Player> getPlayer(@PathVariable long id) {
        Player player = playerRepository.findById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "sample", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getSamplePlayer() {

        List<Player> playerList = new ArrayList<>(2);

        Player player1 = new Player();
        player1.setName("samplePlayer1");
        player1.setBattingHand(Player.BattingHand.Right);
        player1.setBowlingType(Player.BowlingType.LEFT_ARM_FAST);
        playerList.add(player1);

        Player player2 = new Player();
        player2.setName("samplePlayer2");
        player2.setBattingHand(Player.BattingHand.Right);
        player2.setBowlingType(Player.BowlingType.RIGHT_ARM_MEDIUM);
        playerList.add(player2);

        return new ResponseEntity<>(playerList, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
//        playerRepository.save(player);
//        return new ResponseEntity<Player>(playerRepository.findById(player.getId()), HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<Player>> addPlayers(@RequestBody List<Player> players) {
        playerRepository.save(players);

        List<Player> playerList = new ArrayList<>(players.size());

        for (Player player:players) {
            playerList.add(playerRepository.findById(player.getId()));
        }

        return new ResponseEntity<List<Player>>(playerList, HttpStatus.OK);
    }
}
