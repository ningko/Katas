package bowling;

import java.util.ArrayList;
import java.util.List;

/*
Need a way to check:
- Score so far without it being overwritten with each roll
- Is it spare
- Is it a strike
- Is the frame completed (either depending on score (strike) or on rolls (spare/open frame)
- How should the next frame be used (for a possible bonus)
 */

public class Frame {

    int firstRoll ;
    int secondRoll;
    boolean isSpare;
    boolean isStrike;

    public Frame(int firstRoll) {
        this.firstRoll = firstRoll;
    }
}



