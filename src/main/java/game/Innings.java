package game;

import exceptions.OversExceededException;

import java.util.List;
import java.util.Map;

/**
 * @author Harish Chakravarthy
 */
public class Innings {

    public Over getCurrentOver() {
        return currentOver;
    }

    public void setCurrentOver(Over currentOver) {
        this.currentOver = currentOver;
    }

    private final int maxOvers;

    private int oversBowled;
    private Over currentOver;
    private int ballsBowled;
    private int runsScored;
    private List<Over> overs;
    private List<Delivery> deliveries;
    private Team battingTeam;
    private Team fieldingTeam;
    private Map<Player, Integer> playerRunsMap;
    private Player striker;
    private Player nonStriker;
    private Player bowler;

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
}
