package cricket.web;

import cricket.domain.Cricket;
import cricket.exceptions.NoIdException;
import cricket.exceptions.ResourceIdMismatchException;
import cricket.web.persistence.CricketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Harish Chakravarthy
 */
@RestController
@RequestMapping(value = "/cricket")
public class CricketController {

    private static final Logger log = LoggerFactory.getLogger(CricketController.class);

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CricketRepository repository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Cricket> getCricketGame(@PathVariable(value = "id") long id) {
        Cricket cricket = null;

        try {
            cricket = repository.findById(id);
        } catch (Exception e) {
            log.error("Error during get " + e);
        }

        return new ResponseEntity<Cricket>(cricket, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cricket addCricketGame(@RequestBody(required = true) Cricket cricket) {
        try {
            repository.save(cricket);
        } catch (Exception e) {
            log.error("Error during post : " + e);
        }

        return repository.findById(cricket.getId());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cricket> updateCricketGame(@PathVariable(value = "id") long id,
            @RequestBody(required = true) Cricket cricket) throws NoIdException, ResourceIdMismatchException {
        if (cricket.getId() == 0) {
            throw new NoIdException();
        }
        else if (id != cricket.getId()) {
            throw new ResourceIdMismatchException();
        }

        repository.save(cricket);

        return new ResponseEntity<>(repository.findById(cricket.getId()), HttpStatus.OK);
    }
}
