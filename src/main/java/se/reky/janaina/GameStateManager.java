package se.reky.janaina;
import se.reky.janaina.model.Actor;
import se.reky.janaina.model.Player;

public interface GameStateManager {
    void executeTownGate();
    void executeFight(Actor opponent);
    void executeCrossRoad();
    void executeNorth();
    void executeEast();
    void executeWest();
    Player getPlayer();
    void setPlayer(Player player);
}

