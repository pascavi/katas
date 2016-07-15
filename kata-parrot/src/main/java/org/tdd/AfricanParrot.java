package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class AfricanParrot extends Parrot {
    public AfricanParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.AFRICAN, numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }
}
