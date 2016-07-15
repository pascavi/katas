package org.tdd;

public class Parrot {

    private ParrotTypeEnum type;
    protected int numberOfCoconuts = 0;
    private double voltage;
    private boolean isNailed;


    public Parrot(ParrotTypeEnum _type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = _type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        switch(type) {
            case EUROPEAN:
                return getBaseSpeed();
            case AFRICAN:
                return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
            case NORWEGIAN_BLUE:
                return (isNailed) ? 0 : getBaseSpeed(voltage);
        }
        throw new RuntimeException("Should be unreachable");
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage*getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }


}
