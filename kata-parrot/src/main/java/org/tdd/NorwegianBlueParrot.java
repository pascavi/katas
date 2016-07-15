package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class NorwegianBlueParrot extends Parrot {
    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        super(voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }
}
