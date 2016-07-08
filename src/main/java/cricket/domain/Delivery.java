package cricket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Delivery {

    private enum DeliveryType {
        valid,
        noBall,
        wideBall;
    }

    private enum Event {
        dotBall,
        wicket,
        runs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private DeliveryType deliveryType;
    private int runs;
    private Event event;

    protected Delivery() {

    }

    public long getId() {
        return id;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
