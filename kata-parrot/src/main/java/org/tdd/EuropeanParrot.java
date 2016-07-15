package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class EuropeanParrot extends Parrot {
    public EuropeanParrot(double voltage, boolean isNailed) {
        super(voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }
}
