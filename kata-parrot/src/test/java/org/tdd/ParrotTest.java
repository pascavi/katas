package org.tdd;

import org.junit.Assert;
import org.junit.Test;


public class ParrotTest {

    @Test
    public void getSpeedOfEuropeanParrot() {
        Parrot parrot = new EuropeanParrot();
        Assert.assertEquals(parrot.getSpeed(), 12.0,0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_One_Coconut() {
        Parrot parrot = new AfricanParrot(1);
        Assert.assertEquals(parrot.getSpeed(), 3.0,0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_Two_Coconuts() {
        Parrot parrot = new AfricanParrot(2);
        Assert.assertEquals(parrot.getSpeed(), 0.0,0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_No_Coconuts() {
        Parrot parrot = new AfricanParrot(0);
        Assert.assertEquals(parrot.getSpeed(), 12.0,0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_nailed() {
        Parrot parrot = new NorwegianBlueParrot(0, true);
        Assert.assertEquals(parrot.getSpeed(), 0.0,0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed() {
        Parrot parrot = new NorwegianBlueParrot(1.5, false);
        Assert.assertEquals(parrot.getSpeed(), 18.0,0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed_high_voltage() {
        Parrot parrot = new NorwegianBlueParrot(4, false);
        Assert.assertEquals(parrot.getSpeed(), 24.0,0);
    }
}
