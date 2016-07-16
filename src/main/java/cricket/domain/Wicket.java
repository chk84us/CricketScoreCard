package cricket.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Wicket {

    private enum WicketType {
        BOWLED,
        CAUGHT,
        HIT_OUT,
        LBW,
        RUN_OUT;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Player batter;

    @OneToOne(cascade = CascadeType.ALL)
    private Player bowler;

    @OneToOne(cascade = CascadeType.ALL)
    private Player fielder;

    private WicketType wicketType;

    public Wicket() {

    }

    public Player getBatter() {
        return batter;
    }

    public void setBatter(Player batter) {
        this.batter = batter;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public Player getFielder() {
        return fielder;
    }

    public void setFielder(Player fielder) {
        this.fielder = fielder;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

}
