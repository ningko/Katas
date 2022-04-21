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

    @Test
    public void spareShouldCountBonus() {
        var game = new Game();
        game.roll(4);
        game.roll(6);
        game.roll(3);

        var expectedScore = 16;
        var actualScore = game.score();

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void spareShouldCountBonusWhenRollsMultipleTimes() {
        var game = new Game();
        game.roll(4);
        game.roll(5);
        game.roll(3); //spare
        game.roll(7); //spare
        game.roll(4);

        var expectedScore = 27;
        var actualScore = game.score();

        assertEquals(expectedScore, actualScore);
    }
}

