package org.tdd;

public abstract class Parrot {

    private ParrotTypeEnum type;
    protected int numberOfCoconuts = 0;
    protected double voltage;
    protected boolean isNailed;

    public Parrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = _type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public abstract double getSpeed();

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage*getBaseSpeed());
    }

    protected double getBaseSpeed() {
        return 12.0;
    }


}