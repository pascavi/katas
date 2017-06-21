package org.tdd;

import java.util.ArrayList;

/**
 * Created by Pascual on 20/06/2017.
 */
class GossipsChecker {

    ArrayList<Driver> drivers;

    GossipsChecker() {
        drivers = new ArrayList<>();
    }

    GossipsChecker(ArrayList<Driver> drivers){
        this.drivers = drivers;
    }

    void addDriver(Driver driver){
        drivers.add(driver);
    }

    boolean doesDriverKnowAll(Driver driver) {
        return driver.getGossips().size() == drivers.size();
    }

    boolean doAllDriversKnowAll() {
        boolean answer = true;
        for(Driver driver:drivers) answer&=doesDriverKnowAll(driver);
        return answer;
    }
}
