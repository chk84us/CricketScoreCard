package cricket.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private BowlingType bowlingType;
    private BattingHand battingHand;

    public enum BattingHand {
        Right,
        Left;
    }


    public enum BowlingType {
        RIGHT_ARM_MEDIUM,
        RIGHT_ARM_FAST,
        RIGHT_ARM_OFF_SPIN,
        RIGHT_ARM_LEG_SPIN,
        LEFT_ARM_MEDIUM,
        LEFT_ARM_FAST,
        LEFT_ARM_ORTHODOX,
        LEFT_ARM_CHINAMAN;
    }
    public Player() {

    }
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public BowlingType getBowlingType() {
        return bowlingType;
    }

    public void setBowlingType(BowlingType bowlingType) {
        this.bowlingType = bowlingType;
    }

    public BattingHand getBattingHand() {
        return battingHand;
    }

    public void setBattingHand(BattingHand battingHand) {
        this.battingHand = battingHand;
    }
}
