package app;

import exceptions.InningsExceededException;
import game.CricketGame;
import game.Innings;
import game.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Harish Chakravarthy
 */
@RestController
public class CricketGameController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/cricket")
    public CricketGame cricketGame(@RequestParam(name = "id") long id) throws InningsExceededException {
        CricketGame game = new CricketGame(counter.incrementAndGet(), "test venue");
        game.setFirstInnings(new InningsController().getInnings());
        game.setSecondInnings(new InningsController().getInnings());

        return game;
    }
}
