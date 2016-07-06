package game;

import exceptions.InningsExceededException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Chakravarthy
 */
public class CricketGame {

    private final long id;
    private final String venue;
    private Innings firstInnings;
    private Innings secondInnings;

    public CricketGame(long id, String venue) {
        this.id = id;
        this.venue = venue;
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
}
