package cricket.web;

import cricket.domain.Cricket;
import cricket.domain.Delivery;
import cricket.domain.Innings;
import cricket.domain.Over;
import cricket.exceptions.InningsExceededException;
import cricket.exceptions.OversExceededException;
import cricket.web.persistence.CricketRepository;
import cricket.web.persistence.DeliveryRepository;
import cricket.web.persistence.InningsRepository;
import cricket.web.persistence.OverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Harish Chakravarthy
 */
@RestController
@RequestMapping(value = "/cricket/{id}/innings/{inningsNumber}/overs/{overNumber}/deliveries")
public class DeliveryController {

    @Autowired
    private CricketRepository cricketRepository;

    @Autowired
    private InningsRepository inningsRepository;

    @Autowired
    private OverRepository overRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Delivery>> getDeliveries(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber, @PathVariable(value = "overNumber") int overNumber)
            throws InningsExceededException {

        List<Delivery> deliveries = cricketRepository.findById(id).getInningsByNumber(inningsNumber)
                .getOverByNumber(overNumber).getDeliveries();

        return new ResponseEntity<>(deliveries, HttpStatus.OK);

    }

    @RequestMapping(value = "{deliveryNumber}", method = RequestMethod.GET)
    public ResponseEntity<Delivery> getDelivery(@PathVariable(value = "id") long id,
            @PathVariable(value = "inningsNumber") int inningsNumber,
            @PathVariable(value = "overNumber") int overNumber,
            @PathVariable(value = "deliveryNumber") int deliveryNumber) throws InningsExceededException {

        Delivery delivery = cricketRepository.findById(id).getInningsByNumber(inningsNumber)
                .getOverByNumber(overNumber).getDelivery(deliveryNumber);

        return new ResponseEntity<>(delivery, HttpStatus.OK);

    }

    public ResponseEntity<Delivery> addDelivery(long id, int inningsNumber, int overNumber, Delivery delivery)
            throws InningsExceededException, OversExceededException {

        deliveryRepository.save(delivery);

        Cricket cricketGame = cricketRepository.findById(id);
        Innings innings = cricketGame.getInningsByNumber(inningsNumber);
        Over over = innings.getOverByNumber(overNumber);

        over.addDelivery(delivery);
        overRepository.save(over);

        innings.addOver(over);
        inningsRepository.save(innings);

        cricketGame.setInningsByNumber(inningsNumber, innings);
        cricketRepository.save(cricketGame);

        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }
}
