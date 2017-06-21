package org.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GossipsCheckerTest {

    GossipsChecker gossipsChecker;
    Driver driver1, driver2;

    @Before
    public void setUp(){
        gossipsChecker = new GossipsChecker();
        driver1 = new Driver(1);
        driver2 = new Driver(2);
    }

    @Test
    public void just_one_driver_initially_knows_all() {
        gossipsChecker.addDriver(driver1);
        boolean answer = gossipsChecker.doesDriverKnowAll(driver1);
        Assert.assertEquals(true, answer);
    }

    @Test
    public void two_drivers_initially_dont_know_all() {
        gossipsChecker.addDriver(driver1);
        gossipsChecker.addDriver(driver2);
        boolean answer1 = gossipsChecker.doesDriverKnowAll(driver1);
        Assert.assertEquals(false, answer1);
        boolean answer2 = gossipsChecker.doesDriverKnowAll(driver2);
        Assert.assertEquals(false, answer2);
    }


    @Test
    public void two_drivers_after_sharing_do_know_all() {
        gossipsChecker.addDriver(driver1);
        gossipsChecker.addDriver(driver2);
        Driver.shareGossips(driver1,driver2);
        boolean answer1 = gossipsChecker.doesDriverKnowAll(driver1);
        Assert.assertEquals(true, answer1);
        boolean answer2 = gossipsChecker.doesDriverKnowAll(driver2);
        Assert.assertEquals(true, answer2);
    }

}
