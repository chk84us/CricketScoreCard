package cricket.web;

import cricket.domain.Cricket;
import cricket.domain.Delivery;
import cricket.domain.Innings;
import cricket.domain.Over;
import cricket.domain.Player;
import cricket.exceptions.InningsExceededException;
import cricket.exceptions.OversExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Harish Chakravarthy
 */
@RestController
public class OverController {

    @Autowired
    private CricketRepository cricketRepository;

    @Autowired
    private InningsRepository inningsRepository;

    @Autowired
    private OverRepository overRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @RequestMapping(value = "/cricket/{id}/innings/{inningsNumber}/overs/{overNumber}", method = RequestMethod.GET)
    public ResponseEntity<Over> getOver(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber, @PathVariable(value = "overNumber") int overNumber)
            throws InningsExceededException {

        Cricket cricketGame = cricketRepository.findById(id);
        Innings innings = cricketGame.getInningsByNumber(inningsNumber);

        Over over = innings.getOverByNumber(overNumber);

        return new ResponseEntity<>(over, HttpStatus.OK);
    }

    @RequestMapping(value = "/cricket/{id}/innings/{inningsNumber}/overs", method = RequestMethod.POST)
    public ResponseEntity<Over> addOver(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber, @RequestBody(required = true) Over over)
            throws InningsExceededException, OversExceededException {

        saveDeliveries(over);
        overRepository.save(over);
        Cricket cricketGame = cricketRepository.findById(id);
        Innings innings = cricketGame.getInningsByNumber(inningsNumber);
        innings.addOver(over);
        inningsRepository.save(innings);
        cricketRepository.save(cricketGame);

        return new ResponseEntity<>(over, HttpStatus.OK);
    }

    @RequestMapping(value = "/cricket/{id}/innings/{inningsNumber}/overs", method = RequestMethod.GET)
    public ResponseEntity<List<Over>> getOvers(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber) throws InningsExceededException {
        return new ResponseEntity<List<Over>>(cricketRepository.findById(id).getInningsByNumber(inningsNumber)
                .getOvers(), HttpStatus.OK);
    }

    private void saveDeliveries(@RequestBody(required = true) Over over) {
        for (Delivery delivery : over.getDeliveries()) {
            deliveryRepository.save(delivery);
        }
    }

    @RequestMapping(value = "/oversample", method = RequestMethod.GET)
    public ResponseEntity<Over> getSampleOver() {
        Over over = new Over();

        Delivery delivery1 = new Delivery();
        delivery1.setEvent(Delivery.Event.RUNS);
        delivery1.setRuns(2);
        delivery1.setDeliveryType(Delivery.DeliveryType.VALID);

        Delivery delivery2 = new Delivery();
        delivery2.setEvent(Delivery.Event.DOT_BALL);
        delivery2.setRuns(0);
        delivery2.setDeliveryType(Delivery.DeliveryType.VALID);

        Delivery delivery3 = new Delivery();
        delivery3.setEvent(Delivery.Event.RUNS);
        delivery3.setRuns(1);
        delivery3.setDeliveryType(Delivery.DeliveryType.WIDE_BALL);

        Player player = new Player();
        player.setName("Harish");

        over.addDelivery(delivery1);
        over.addDelivery(delivery2);
        over.addDelivery(delivery3);

        over.setBowler(player);

        return new ResponseEntity<>(over, HttpStatus.OK);
    }

}
