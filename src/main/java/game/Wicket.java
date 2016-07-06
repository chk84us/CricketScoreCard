package game;

/**
 * @author Harish Chakravarthy
 */
public class Wicket {

    private enum WicketType {
        bowled,
        caught,
        hitout,
        lbw,
        runout;
    }

    private Player batter;
    private Player bowler;
    private Player fielder;
    private WicketType wicketType;

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
