package org.tdd;

import org.junit.Before;
import org.junit.Test;

public class PrintDateTest {
    PrintDate printDate;
    @Before
    public void setUp() {
        printDate = new PrintDate(System.out);
    }


    @Test
    public void keepPrinting() throws Exception {
        printDate.printCurrentDate();
    }
    // Prints Fri Nov 25 19:34:55 CET 2016

}
