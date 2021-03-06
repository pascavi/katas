package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class AfricanParrot extends Parrot {
    protected int numberOfCoconuts = 0;

    public AfricanParrot(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

    private double getLoadFactor() {
        return 9.0;
    }
}
