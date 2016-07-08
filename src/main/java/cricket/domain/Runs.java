package cricket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Runs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int totalRuns;

    protected Runs() {

    }

    public Runs(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }
}
