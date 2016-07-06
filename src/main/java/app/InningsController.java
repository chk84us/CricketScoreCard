package app;

import game.Innings;
import game.Team;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harish Chakravarthy
 */
@RestController
public class InningsController {

    @RequestMapping(path = "/cricket/innings")
    public Innings getInnings() {
        return new Innings(20, new Team("team1"), new Team("team2"));
    }
}
