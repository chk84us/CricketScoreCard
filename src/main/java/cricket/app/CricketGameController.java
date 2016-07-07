package cricket.app;

import cricket.exceptions.InningsExceededException;
import cricket.game.CricketGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Harish Chakravarthy
 */
@RestController
public class CricketGameController {

    private static final String CRICKET_RESOURCE_PATH = "/cricket";
    private static final Logger log = LoggerFactory.getLogger(CricketGameController.class);

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CricketRepository repository;

    @RequestMapping(value = CRICKET_RESOURCE_PATH, method = RequestMethod.GET)
    public CricketGame cricketGame(@RequestParam(name = "id") long id) throws InningsExceededException {
        CricketGame cricketGame = null;
        try {
            cricketGame = repository.findById(id);
        } catch (Exception e) {
            log.error("Error during get " + e);
        }
        return cricketGame;
    }

    @RequestMapping(value = CRICKET_RESOURCE_PATH, method = RequestMethod.POST)
    public CricketGame addCricketGame(@RequestBody(required = true) CricketGame cricketGame) {
        try {
            repository.save(cricketGame);

        } catch (Exception e) {
            log.error("Error during post : " + e);
        }
        return repository.findById(cricketGame.getId());
    }
}
