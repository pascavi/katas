package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class NorwegianBlueParrot extends Parrot {
    private double voltage;
    private boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage *getBaseSpeed());
    }
}
