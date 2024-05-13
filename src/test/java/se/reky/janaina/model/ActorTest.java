package se.reky.janaina.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    @Test
    public void testAttackMethod() {
        Player player = new Player("Player1", 100, 20);
        Goblin goblin = new Goblin("Goblin1", 50, 10);

        player.attack(goblin);

        assertEquals(30, goblin.getHp());
    }
}
