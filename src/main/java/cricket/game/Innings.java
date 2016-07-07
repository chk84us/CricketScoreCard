package cricket.game;

import cricket.exceptions.OversExceededException;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Map;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Innings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int maxOvers;
    private int oversBowled;
    private int ballsBowled;
    private int runsScored;

    @OneToOne(cascade = CascadeType.ALL)
    private Over currentOver;

    @OneToMany
    private List<Over> overs;

    @OneToMany
    private List<Delivery> deliveries;

    @OneToOne(cascade = CascadeType.ALL)
    private Team battingTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private Team fieldingTeam;

    @ElementCollection
    private Map<Player, Integer> playerRunsMap;

    @OneToOne(cascade = CascadeType.ALL)
    private Player striker;

    @OneToOne(cascade = CascadeType.ALL)
    private Player nonStriker;

    @OneToOne(cascade = CascadeType.ALL)
    private Player bowler;

    protected Innings() {

    }

    public Innings(int maxOvers, Team battingTeam, Team fieldingTeam) {
        this.maxOvers = maxOvers;
        this.battingTeam = battingTeam;
        this.fieldingTeam = fieldingTeam;
    }

    public int getMaxOvers() {
        return maxOvers;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getFieldingTeam() {
        return fieldingTeam;
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }

    public void addOver(Over over) throws OversExceededException {
        if (canAddOver()) {
            overs.add(over);
        } else {
            throw new OversExceededException();
        }
    }

    private boolean canAddOver() {
        return overs.size() < maxOvers;
    }

    private void endInnings() {
        swapBattingAndFieldingTeams();
    }

    private void swapBattingAndFieldingTeams() {
        Team targetSetter = battingTeam;
        battingTeam = fieldingTeam;
        fieldingTeam = targetSetter;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public void setBallsBowled(int ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
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

    private boolean isOverUp() {
        return false;
    }

    public Over getCurrentOver() {
        return currentOver;
    }

    public void setCurrentOver(Over currentOver) {
        this.currentOver = currentOver;
    }

    @Override
    public String toString() {
        return "InningsString";
    }
}
