package se.reky.janaina;
import se.reky.janaina.model.Player;

public interface PlayerInteraction {
    void setupPlayer(Player player);
    void updatePlayerHealth(Player player, int hp);
    void greetPlayer(Player player);

}