package org.tdd;

import org.junit.Before;
import org.junit.Test;

public class PrintDateTest {
    PrintDate printDate;
    @Before
    public void setUp() {
        printDate = new PrintDate();
    }


    @Test
    public void keepPrinting() throws Exception {
        printDate.printCurrentDate();
    }


}
