package org.tdd;

import org.junit.Assert;
import org.junit.Test;

public class GossipingDriversTest {


    @Test
    public void no_routes_says_never() {
        GossipingDrivers gossipingDrivers = new GossipingDrivers();
        String answer = gossipingDrivers.run();
        Assert.assertEquals("never", answer);
    }

    @Test
    public void one_route_says_0() {
        int[][] routes = {
                {1,2,3}
        };
        GossipingDrivers gossipingDrivers = new GossipingDrivers(routes);
        String answer = gossipingDrivers.run();
        Assert.assertEquals("0", answer);
    }

    @Test
    public void two_disconnected_routes_says_never() {
        int[][] routes = {
                {1, 2, 3},
                {2, 3, 1}
        };
        GossipingDrivers gossipingDrivers = new GossipingDrivers(routes);
        String answer = gossipingDrivers.run();
        Assert.assertEquals("never", answer);
    }

    @Test
    public void two_routes_starting_at_same_point_says_1() {
        int[][] routes = {
                {1, 2, 3},
                {1, 3, 2}
        };
        GossipingDrivers gossipingDrivers = new GossipingDrivers(routes);
        String answer = gossipingDrivers.run();
        Assert.assertEquals("1", answer);
    }

    @Test
    public void two_routes_meeting_after_some_cycles_says_t() {
        int[][] routes = {
                {1, 2},
                {3, 4, 2}
        };
        GossipingDrivers gossipingDrivers = new GossipingDrivers(routes);
        String answer = gossipingDrivers.run();
        Assert.assertEquals("6", answer);
    }

    @Test
    public void kata_example_1_says_5() {
        int[][] routes = {
                {3, 1, 2, 3},
                {3, 2, 3, 1},
                {4, 2, 3, 4, 5}
        };
        GossipingDrivers gossipingDrivers = new GossipingDrivers(routes);
        String answer = gossipingDrivers.run();
        Assert.assertEquals("5", answer);
    }

    @Test
    public void kata_example_2_says_never() {
        int[][] routes = {
                {2, 1, 2},
                {5, 2, 8}
        };
        GossipingDrivers gossipingDrivers = new GossipingDrivers(routes);
        String answer = gossipingDrivers.run();
        Assert.assertEquals("never", answer);
    }

}
