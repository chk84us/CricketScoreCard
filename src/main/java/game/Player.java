package game;

/**
 * @author Harish Chakravarthy
 */
public class Player {

    private final long id;
    private final String name;

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
