package org.tdd;

import java.util.HashSet;

/**
 * Created by Pascual on 24/12/2016.
 */
class Driver {
    private int[] route;
    private HashSet<Integer> gossips = new HashSet<>();

    Driver(int[] route) {
        this.route = route;
    }

    Driver(int gossip) {
        gossips.add(gossip);
    }

    Driver(int[] route, int gossip) {
        this.route = route;
        gossips.add(gossip);
    }

    //getter and setters
    int[] getRoute() {
        return route;
    }

    HashSet<Integer> getGossips() {
        return gossips;
    }

    void setGossips(HashSet<Integer> gossips) {
        this.gossips = gossips;
    }


    //route related methods

    int whereAreYou(int time) {
        int routeSize = route.length;
        int pos = (time - 1) % routeSize;
        return route[pos];
    }

    static boolean areYouInTheSameStation(Driver driver1, Driver driver2, int time) {
        int station1 = driver1.whereAreYou(time);
        int station2 = driver2.whereAreYou(time);
        return station1 == station2;
    }

    //share gossips
    static void shareGossips(Driver driver1, Driver driver2) {
        HashSet<Integer> gossips1 = driver1.getGossips();
        HashSet<Integer> gossips2 = driver2.getGossips();
        HashSet<Integer> shared = new HashSet<>();
        shared.addAll(gossips1);
        shared.addAll(gossips2);
        driver1.setGossips(shared);
        driver2.setGossips(shared);
    }

}
