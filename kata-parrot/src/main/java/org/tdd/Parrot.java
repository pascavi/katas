package org.tdd;

public abstract class Parrot {

    protected double voltage;
    protected boolean isNailed;

    public Parrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public abstract double getSpeed();

    protected double getBaseSpeed() {
        return 12.0;
    }


}
