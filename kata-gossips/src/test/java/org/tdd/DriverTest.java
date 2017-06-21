package org.tdd;

import org.junit.Assert;
import org.junit.Test;

public class DriverTest {

    @Test
    public void one_station_route_driver_stays_there() {
        int[] route = {1};
        Driver driver = new Driver(route);
        Assert.assertEquals(1, driver.whereAreYou(100));
    }

    @Test
    public void three_stations_route_driver_is_at_second_position_by_5() {
        int[] route = {1,2,3};
        Driver driver = new Driver(route);
        Assert.assertEquals(2, driver.whereAreYou(5));
    }

    @Test
    public void if_both_routes_dont_match_at_3_then_both_drivers_dont_meet_at_3() {
        int[] route1 = {1,2,3};
        int[] route2 = {3,2,1};
        Driver driver1 = new Driver(route1);
        Driver driver2 = new Driver(route2);
        Assert.assertEquals(false, Driver.areYouInTheSameStation(driver1,driver2,3));
    }

    @Test
    public void if_both_routes_match_at_3_then_both_drivers_meet_at_3() {
        int[] route1 = {1,3,2};
        int[] route2 = {3,1,2};
        Driver driver1 = new Driver(route1);
        Driver driver2 = new Driver(route2);
        Assert.assertEquals(true, Driver.areYouInTheSameStation(driver1,driver2,3));
    }

}
