package org.tdd;

public abstract class Parrot {

    private ParrotTypeEnum type;
    protected double voltage;
    protected boolean isNailed;

    public Parrot(ParrotTypeEnum _type, double voltage, boolean isNailed) {
        this.type = _type;
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
