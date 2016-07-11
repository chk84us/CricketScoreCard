package cricket.web;

import cricket.domain.Cricket;
import cricket.domain.Innings;
import cricket.exceptions.InningsExceededException;
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

/**
 * @author Harish Chakravarthy
 */
@RestController
public class InningsController {

    private static final Logger log = LoggerFactory.getLogger(InningsController.class);

    @Autowired
    private CricketRepository cricketRepository;

    @Autowired
    private InningsRepository inningsRepository;

    @RequestMapping(value = "cricket/{id}/innings/{inningsNumber}", method = RequestMethod.GET)
    public ResponseEntity<Innings> getInnings(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber) throws InningsExceededException {
        Innings innings = null;

        try {
            innings = cricketRepository.findById(id).getInningsByNumber(inningsNumber);
        } catch (Exception e) {
            log.error("Error when getting innings " + e);
        }

        return new ResponseEntity<>(innings, HttpStatus.OK);
    }

    @RequestMapping(value = "cricket/{id}/innings/{inningsNumber}", method = RequestMethod.POST)
    public ResponseEntity<Innings> addInnings(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber, @RequestBody(required = true) Innings innings)
            throws InningsExceededException {
        Cricket cricketGame = null;

        try {
            cricketGame = cricketRepository.findById(id);
            inningsRepository.save(innings);
            cricketGame.setInningsByNumber(inningsNumber, innings);
        } catch (Exception e) {
            log.error("Error when saving innings " + e);
        }

        cricketRepository.save(cricketGame);
        return new ResponseEntity<>(innings, HttpStatus.OK);
    }
}
