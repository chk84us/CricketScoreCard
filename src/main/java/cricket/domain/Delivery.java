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

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public enum DeliveryType {
        VALID,
        NO_BALL,
        WIDE_BALL;
    }

    public enum Event {
        DOT_BALL,
        WICKET,
        RUNS;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private DeliveryType deliveryType;
    private int runs;
    private Event event;

    public Delivery() {

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
