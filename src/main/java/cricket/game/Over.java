package cricket.game;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Over {

    private static final int MAX_DELIVERIES = 6;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Player bowler;
    private int overNumber;

    @OneToMany
    private List<Delivery> deliveries;

    protected Over() {

    }

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
