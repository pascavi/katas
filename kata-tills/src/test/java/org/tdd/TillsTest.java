package org.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TillsTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testNormalCondition() {
        assertThat(Tills.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2),is(9));
    }

    @Test
    public void testEmptyArray() {
        assertThat(Tills.solveSuperMarketQueue(new int[]{}, 2),is(0));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertThat(Tills.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1),is(15));
    }


}
