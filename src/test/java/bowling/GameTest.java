package bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void firstRoll() {
        var game = new Game();
        game.roll(5);
        game.roll(3);

        var expectedScore = 8;
        var actualScore = game.score();

        assertEquals(expectedScore, actualScore);
    }
}