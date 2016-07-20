package cricket.domain;

import cricket.exceptions.PlayersExceededException;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Chakravarthy
 */
@Entity
public class Team {

    private static final int MAX_PLAYERS = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ElementCollection
    private List<Player> players;

    @OneToOne(cascade = CascadeType.ALL)
    private Player captain;

    public Team() {

    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) throws PlayersExceededException {
        if (canAddPlayer()) {
            players.add(player);
        } else {
            throw new PlayersExceededException();
        }
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    private boolean canAddPlayer() {
        if (players == null) {
            players = new ArrayList<>(MAX_PLAYERS);
            return true;
        }
        return !(players.size() >= MAX_PLAYERS);
    }

    private boolean canRemovePlayer() {
        return !players.isEmpty();
    }

    public void addPlayers(List<Player> players) {
        this.players.addAll(players);
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
