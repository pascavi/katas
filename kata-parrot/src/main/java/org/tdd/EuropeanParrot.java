package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class EuropeanParrot extends Parrot {
    public EuropeanParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.EUROPEAN, numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }
}
