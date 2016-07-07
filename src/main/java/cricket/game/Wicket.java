package cricket.game;

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
        bowled,
        caught,
        hitout,
        lbw,
        runout;
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

    protected Wicket() {

    }

    public Wicket(Player batter, WicketType type) {
        this.wicketType = type;
        this.batter = batter;

        if (type == WicketType.runout) {
            setFielder(fielder);
        } else if (type == WicketType.bowled) {
            setBowler(bowler);
        } else if (type == WicketType.caught) {
            setFielder(fielder);
        }
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
