package bowling;

import org.junit.jupiter.api.Disabled;
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
    @Test
    public void strikeShouldCountBonus() {
        var game = new Game();
        game.roll(2);
        game.roll(7);
        game.roll(10); //strike
        game.roll(4); //bonus
        game.roll(3); //bonus

        var expectedScore = 33;
        var actualScore = game.score();

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void twoStrikesShouldCountBonus() {
        var game = new Game();
        game.roll(2);
        game.roll(7);
        game.roll(10); //strike
        game.roll(10); //bonus
        game.roll(3); //bonus
        game.roll(4);

        var expectedScore = 56;
        var actualScore = game.score();

        assertEquals(expectedScore, actualScore);
    }

    @Disabled
    @Test
    public void perfectGame() {
        var game = new Game();
        game.roll(10); // 10
        game.roll(10); // 10 + 30 = 40
        game.roll(10); // 40 + 30 = 60
        game.roll(10); // 60 + 30 = 90
        game.roll(10); // 90 + 30 = 100
        game.roll(10); // 100 + 30 = 120
        game.roll(10); // 120 + 30 = 150
        game.roll(10); // 150 + 30 = 180
        game.roll(10); // 180 + 30 = 210
        game.roll(10); //get two more rolls 210 + 30 = 240
        game.roll(10); // 240 + 30 = 270
        game.roll(10); // 270 + 30 = 300

        var expectedScore = 300;
        var actualScore = game.score();

        assertEquals(expectedScore, actualScore);
    }
}

