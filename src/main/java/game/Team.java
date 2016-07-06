package game;

import exceptions.PlayersExceededException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Chakravarthy
 */
public class Team {

    private static final int MAX_PLAYERS = 11;

    private final String name;
    private List<Player> players;
    private Player captain;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<Player>(MAX_PLAYERS);
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
}
