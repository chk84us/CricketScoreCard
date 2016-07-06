package game;

/**
 * @author Harish Chakravarthy
 */
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

    private final long id;
    private DeliveryType deliveryType;
    private int runs;
    private Event event;

    public Delivery(long id, DeliveryType deliveryType) {
        this.id = id;
        this.deliveryType = deliveryType;
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
