package cricket.game;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class CricketGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String venue;

    @OneToOne(cascade = CascadeType.ALL)
    private Innings firstInnings;

    @OneToOne(cascade = CascadeType.ALL)
    private Innings secondInnings;

    protected CricketGame() {

    }

    public CricketGame(String venue) {
        this.venue = venue;
    }

    public CricketGame(long id) {
        this.id = id;
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

}
