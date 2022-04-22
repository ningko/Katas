package bowling;

public class Game {
    Frame[] frameList = new Frame[10];
    int currentPosition = 0;

    void roll(int pins) {
      var currentFrame = frameList[currentPosition];

      if (currentFrame == null) {
          Frame newFrame = new Frame(pins);
          frameList[currentPosition] = newFrame;
          // set if it's a strike
          newFrame.isStrike = newFrame.firstRoll == 10;
          if (newFrame.isStrike) {
              currentPosition++;
          }
      } else {
          currentFrame.secondRoll = pins;
          // set if it's a spare
          currentFrame.isSpare = currentFrame.firstRoll + currentFrame.secondRoll == 10;
          // set currentPosition to next available position
          currentPosition++;
      }
    }

    int score() {
        int totalScore = 0;
        for (int i = 0; i < frameList.length; i++) {
            var frame = frameList[i];
            if (frame == null) {
                break;
            } else {
                totalScore += frame.firstRoll + frame.secondRoll;
            }
            if (isSpare(i)) {
                totalScore += frame.firstRoll;
            } else {
                totalScore += calculateStrikeBonus(i);
            }
        }
        return totalScore;
    }

    private int calculateStrikeBonus(int currentPosition) {
        int bonus = 0;
        if (frameList[currentPosition].isStrike) {
            var nextFrame = frameList[currentPosition + 1];
            if (nextFrame == null) {
                return bonus;
            }
            // case 1: next frame is not a strike
            if (!nextFrame.isStrike) {
                bonus += nextFrame.firstRoll + nextFrame.secondRoll;
            } else {
                // case 2: next frame is a strike
                bonus += 10;
                var nextNextFrame = frameList[currentPosition + 2];
                if (nextNextFrame == null) {
                    return bonus;
                }
                bonus += nextNextFrame.firstRoll;
            }
        }
        return bonus;
    }

    private boolean isSpare(int position) {
        return position > 0 && frameList[position - 1].isSpare;
    }
}
