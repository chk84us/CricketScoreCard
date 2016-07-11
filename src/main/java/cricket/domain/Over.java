package cricket.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
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

    public Over() {

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
        if(deliveries == null) {
            deliveries = new ArrayList<Delivery>(MAX_DELIVERIES);
        }
        deliveries.add(delivery);
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public Delivery getDelivery(int deliveryNumber) {
        return deliveries.get(deliveryNumber);
    }
}
