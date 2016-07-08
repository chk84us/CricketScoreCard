package cricket.web;

import cricket.domain.Innings;
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

/**
 * @author Harish Chakravarthy
 */
@RestController
public class InningsController {

    private static final String INNINGS_RESOURCE_PATH = "cricket/innings";
    private static final Logger log = LoggerFactory.getLogger(InningsController.class);

    @Autowired
    private CricketRepository cricketRepository;

    @RequestMapping(value = INNINGS_RESOURCE_PATH, method = RequestMethod.GET)
    public ResponseEntity<Innings> getInnings(@RequestParam(name = "id") long id) {
        Innings innings = null;
        try {
            innings = cricketRepository.findById(id).getFirstInnings();
        } catch (Exception e) {
            log.error("Error when getting innings " + e);
        }
        return new ResponseEntity<>(innings, HttpStatus.OK);
    }

    @RequestMapping(value = INNINGS_RESOURCE_PATH, method = RequestMethod.POST)
    public ResponseEntity<Innings> addInnings(@RequestParam(name = "id") long id, @RequestBody(required = true)
                                              Innings innings) {
        try {
            cricketRepository.findById(id).setFirstInnings(innings);
        } catch (Exception e) {
            log.error("Error when saving innings " + e);
        }

        return new ResponseEntity<>(innings, HttpStatus.OK);
    }
}
