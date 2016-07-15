package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class AfricanParrot extends Parrot {
    protected int numberOfCoconuts = 0;

    public AfricanParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.AFRICAN, voltage, isNailed);
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * this.numberOfCoconuts);
    }

    protected double getLoadFactor() {
        return 9.0;
    }
}
