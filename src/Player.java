import java.util.Objects;

public class Player {
    private String name;
    private int playerPuntuation;

    public Player(String name) {
        this.name = name;
        this.playerPuntuation = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlayerPuntuation() {
        return playerPuntuation;
    }

    public void setPlayerPuntuation(int playerPuntuation) {
        this.playerPuntuation = playerPuntuation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerPuntuation == player.playerPuntuation && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, playerPuntuation);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerPuntuation=" + playerPuntuation +
                '}';
    }
}