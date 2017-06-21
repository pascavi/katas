package org.tdd;

import java.util.ArrayList;

/**
 * Created by Pascual on 21/06/2017.
 */
 class GossipingDrivers {
    public static final int DAY_LENGTH = 480;
    ArrayList<Driver> drivers = new ArrayList<>();

    GossipingDrivers(){}

    GossipingDrivers(int[][] routes){
        for(int i=0;i<routes.length;i++){
            drivers.add(new Driver(routes[i],i));
        }
    }

    String run() {
        if(drivers.size() ==1) return "0";
        GossipsChecker gossipsChecker = new GossipsChecker(drivers);
        for(Integer t=1;t<=DAY_LENGTH;t++){
            for(int i=0;i<drivers.size();i++){
                for(int j=0;j<i;j++){
                    Driver driver1 = drivers.get(i);
                    Driver driver2 = drivers.get(j);
                    if(!Driver.areYouInTheSameStation(driver1, driver2,t)) continue;
                    else Driver.shareGossips(driver1, driver2);
                    if(gossipsChecker.doAllDriversKnowAll()) return t.toString();
                }
            }
        }
        return "never";
    }

}
