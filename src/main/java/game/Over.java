package game;

import java.util.List;

/**
 * @author Harish Chakravarthy
 */
public class Over {

    private static final int MAX_DELIVERIES = 6;
    private final long id;
    private final Player bowler;
    private final int overNumber;
    private List<Delivery> deliveries;

    public Over(long id, Player bowler, int overNumber, List<Delivery> deliveries) {
        this.id = id;
        this.bowler = bowler;
        this.overNumber = overNumber;
        this.deliveries = deliveries;
    }

    public long getId() {
        return id;
    }

    public Player getBowler() {
        return bowler;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void addDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }
}
