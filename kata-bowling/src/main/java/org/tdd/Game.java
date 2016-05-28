package org.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pascual on 28/05/2016.
 */
public class Game {
    String scoring;
    List<Frame> frames;

    Game(String scoring) {
        this.scoring = scoring;
        frames = parseFrames();
    }

    String getScoring() {
        return scoring;
    }

    List<Frame> parseFrames() {
        String scoringWithoutExtraRolls = getScoringWithoutExtraRolls();

        Pattern pattern = Pattern.compile("X|[-1-9/]{2}");
        Matcher matcher = pattern.matcher(scoringWithoutExtraRolls);

        List<Frame> frames = new ArrayList<>();
        while (matcher.find()) {
            Frame frame = new Frame(matcher.group(), matcher.start());
            frames.add(frame);
        }
        return frames;
    }

    String getScoringWithoutExtraRolls() {
        int length = scoring.length();
        int extraRollsCount = 0;

        if (scoring.substring(length - 2, length - 1).equals("/")) extraRollsCount = 1;
        if (scoring.substring(length - 3, length - 2).equals("X")) extraRollsCount = 2;

        return scoring.substring(0, length - extraRollsCount);
    }

    int getPoints() {
        int points = 0;
        for (Frame frame : frames) {
            points += frame.getBasePoints();
            if (frame.isSpare()) {
                String nextRoll = scoring.substring(frame.getPosition() + 2, frame.getPosition() + 3);
                points += frame.getBonus(nextRoll);
            } else if (frame.isStrike()) {
                String nextRolls = scoring.substring(frame.getPosition() + 1, frame.getPosition() + 3);
                points += frame.getBonus(nextRolls);
            }
        }
        return points;
    }


}
