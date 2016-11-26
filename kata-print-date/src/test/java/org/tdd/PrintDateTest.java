package org.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintDateTest {
    private PrintDate printDate;
    private PrintStreamMock outMock;
    private DateMock dateMock;

    @Before
    public void setUp(){
        printDate = new PrintDate();
        outMock = new PrintStreamMock();
        dateMock = new DateMock();
    }

    @Test
    public void keepPrinting()  {
        printDate.printCurrentDate();
    }

    @Test
    public void printlnIsCalled() throws Exception {
        printDate.setOut(outMock);
        printDate.printCurrentDate();
        assertThat(outMock.verifyPrintlnWasCalled(), is(true));
    }

    @Test
    public void printlnPrintsCorrectValue() throws Exception {
        printDate.setOut(outMock);
        printDate.setDate(dateMock);
        printDate.printCurrentDate();
        assertThat(outMock.verifyPrintlnLastCall("Fri Nov 25 19:34:55 CET 2016"), is(true));
    }
}
