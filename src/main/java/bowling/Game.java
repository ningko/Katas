package bowling;

public class Game {
    Frame[] frameList = new Frame[10];
    int currentPosition = 0;

    void roll(int pins) {
      var frame = frameList[currentPosition];

      if (frame == null) {
          Frame newFrame = new Frame(pins);
          frameList[currentPosition] = newFrame;
      } else {
          frame.secondRoll = pins;
          // set if it's a spare
          frame.isSpare = frame.firstRoll + frame.secondRoll == 10;
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
                // TODO: add spare bonus if previous frame is spare and current positions is not 0
            }
        }
        return totalScore;
    }
}
