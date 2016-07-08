package cricket.web;

import cricket.domain.Innings;
import cricket.exceptions.InningsExceededException;
import cricket.domain.Cricket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class CricketController {

    private static final String CRICKET_RESOURCE_PATH = "/cricket";
    private static final String INNINGS_RESOURCE_PATH = "/cricket/innings";
    private static final Logger log = LoggerFactory.getLogger(CricketController.class);

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CricketRepository repository;

    @RequestMapping(value = CRICKET_RESOURCE_PATH, method = RequestMethod.GET)
    public ResponseEntity<Cricket> getCricketGame(@RequestParam(name = "id") long id) {
        Cricket cricket = null;
        try {
            cricket = repository.findById(id);
        } catch (Exception e) {
            log.error("Error during get " + e);
        }
        return new ResponseEntity<Cricket>(cricket, HttpStatus.OK);
    }

    @RequestMapping(value = CRICKET_RESOURCE_PATH, method = RequestMethod.POST)
    public Cricket addCricketGame(@RequestBody(required = true) Cricket cricket) {
        try {
            repository.save(cricket);
        } catch (Exception e) {
            log.error("Error during post : " + e);
        }
        return repository.findById(cricket.getId());
    }
}
