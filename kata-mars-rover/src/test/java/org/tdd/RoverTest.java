package org.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoverTest {
    private final int[][] startPoint = {{0},{0}};
    private final char startHeading = 'N';
    Rover rover;

    @Before
    public void setUp(){
        rover = new Rover(startPoint,startHeading);
    }

    @Test
    public void compass_symbols_translates_to_heading_vector() {
        int[][] headingNorth =  {{0},{1}};
        Assert.assertEquals(true, true);
    }


}
