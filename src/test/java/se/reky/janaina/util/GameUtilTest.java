package se.reky.janaina.util;

import org.junit.jupiter.api.Test;
import se.reky.janaina.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameUtilTest {

    @Test
    public void testToLowerCaseButFirstLetterCapitalizedWithNullInput() {
        GameUtil gameUtil = new GameUtil();

        assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized(null);
        });
    }

}
