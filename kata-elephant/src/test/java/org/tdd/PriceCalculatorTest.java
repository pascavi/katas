package org.tdd;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PriceCalculatorTest {
    PriceCalculator priceCalculator;


    @Before
    public void setUp(){
        priceCalculator = new PriceCalculator();
    }


    @Test
    public void if_price_is_1_total_is_items()
    {
        int numberOfItems = 2;
        Float price = 1f;
        Float total = PriceCalculator.multiply(numberOfItems, price);
        assertEquals(true, 2f==total);
    }

    @Test
    public void for_price_2_and_items_3_total_is_6()
    {
        int numberOfItems = 3;
        Float price = 2f;
        Float total = PriceCalculator.multiply(numberOfItems, price);
        assertEquals(true, 6f==total);
    }





}
