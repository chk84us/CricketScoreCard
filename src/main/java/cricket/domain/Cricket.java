package cricket.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Cricket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String venue;

    @OneToOne(cascade = CascadeType.ALL)
    private Innings firstInnings;

    @OneToOne(cascade = CascadeType.ALL)
    private Innings secondInnings;

    protected Cricket() {

    }

    public long getId() {
        return id;
    }

    public String getVenue() {
        return venue;
    }

    public Innings getFirstInnings() {
        return firstInnings;
    }

    public void setFirstInnings(Innings firstInnings) {
        this.firstInnings = firstInnings;
    }

    public Innings getSecondInnings() {
        return secondInnings;
    }

    public void setSecondInnings(Innings secondInnings) {
        this.secondInnings = secondInnings;
    }

    @Override
    public String toString() {
        return "CricketGameString";
    }

    public void setId(long id) {
        this.id = id;
    }
}
