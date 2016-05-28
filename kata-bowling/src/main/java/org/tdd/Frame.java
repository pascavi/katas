package org.tdd;


public class Frame {
    String[] rolls;
    int position = 0;

    Frame(String scoring) {
        rolls = scoring.split("");
    }

    Frame(String scoring,int position) {
        rolls = scoring.split("");
        this.position = position;
    }

    int getBasePoints() {
        int firstRoll, secondRoll;
        if (rolls.length == 0) return 0;

        firstRoll = translate(rolls[0]);
        if (rolls.length == 1) return firstRoll;

        secondRoll = translate(rolls[1]);
        if (secondRoll == 10) return 10;
        else return firstRoll + secondRoll;
    }

    int getBonus(String nextRollsString) {
        String[] nextRolls = nextRollsString.split("");

        //if this frame it's a spare then returns points from first next roll
        if (isSpare() && nextRolls.length > 0) return translate(nextRolls[0]);

        //if this frame it's a strike then returns points from next two rolls
        if (isStrike() && nextRolls.length > 1)
            return translate(nextRolls[0]) + translate(nextRolls[1]);

        return 0;
    }

    private int translate(String symbol) {
        int points;
        switch (symbol) {
            case "-":
                points = 0;
                break;
            case "X":
            case "/":
                points = 10;
                break;
            default:
                points = Integer.parseInt(symbol);
                break;
        }
        return points;
    }

    public boolean isSpare() {
        return rolls.length > 1 && rolls[1].equals("/");
    }

    public boolean isStrike() {
        return rolls.length > 0 && rolls[0].equals("X");
    }

    public int getPosition() {
        return position;
    }

    public String[] getRolls() {
        return rolls;
    }

}
