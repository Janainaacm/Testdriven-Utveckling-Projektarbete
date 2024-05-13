package se.reky.janaina;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.janaina.model.Player;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Scanner;
public class PlayerInteractionTest {
    Player player;
    private PlayerInteraction createPlayerInteraction(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        return new SimplePlayerInteraction(new IOHandler(scanner));
    }

    @BeforeEach
    public void setUpPlayer() {
        player = new Player();
    }


    @Test
    public void testPlayerSetupMethod() {
        PlayerInteraction interaction = createPlayerInteraction("Test Player");
        interaction.setupPlayer(player);

        assertEquals("Test Player", player.getName());
    }

    @Test
    public void testUpdatePlayerHealth() {
        PlayerInteraction interaction = createPlayerInteraction("100");
        player.setHp(50);

        interaction.updatePlayerHealth(player, 30);

        assertEquals(80, player.getHp());
    }



}
