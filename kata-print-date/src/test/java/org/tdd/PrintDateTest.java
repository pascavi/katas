package org.tdd;

import org.junit.Test;
import java.util.Date;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintDateTest {

    @Test
    public void keepPrinting()  {
        PrintDate printDate = new PrintDate(System.out, new Date());
        printDate.printCurrentDate();
    }

    @Test
    public void pPrintlnIsCalled() throws Exception {
        PrintStreamMock outMock = new PrintStreamMock(null);
        PrintDate printDate = new PrintDate(outMock, new Date());
        printDate.printCurrentDate();
        assertThat(outMock.verifyPrintlnWasCalled(), is(true));
    }

    @Test
    public void printlnPrintsCorrectValue() throws Exception {
        PrintStreamMock outMock = new PrintStreamMock(null);
        PrintDate printDate = new PrintDate(outMock, new DateMock());
        printDate.printCurrentDate();
        assertThat(outMock.verifyPrintlnLastCall("Fri Nov 25 19:34:55 CET 2016"), is(true));
    }
}
