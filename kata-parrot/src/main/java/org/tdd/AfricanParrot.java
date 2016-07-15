package org.tdd;

/**
 * Created by Pascual on 15/07/2016.
 */
public class AfricanParrot extends Parrot {
    public AfricanParrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super(ParrotTypeEnum.AFRICAN, numberOfCoconuts, voltage, isNailed);
    }
}
