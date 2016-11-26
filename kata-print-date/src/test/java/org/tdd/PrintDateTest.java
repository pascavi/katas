package org.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintDateTest {
    private OutInterface out;
    private DateInterface date;
    private PrintStreamMock outMock;
    private DateMock dateMock;

    @Before
    public void setUp(){
        out = new OutInterface() {
            @Override
            public void println(String input) {
                System.out.println(input);
            }
        };
        date = new DateInterface() {
            @Override
            public String toString(){
             return new java.util.Date().toString();
            }
        };
        outMock = new PrintStreamMock();
        dateMock = new DateMock();
    }

    @Test
    public void keepPrinting()  {
        PrintDate printDate = new PrintDate(out, date);
        printDate.printCurrentDate();
    }

    @Test
    public void printlnIsCalled() throws Exception {
        PrintDate printDate = new PrintDate(outMock, date);
        printDate.printCurrentDate();
        assertThat(outMock.verifyPrintlnWasCalled(), is(true));
    }

    @Test
    public void printlnPrintsCorrectValue() throws Exception {
        PrintDate printDate = new PrintDate(outMock, dateMock);
        printDate.printCurrentDate();
        assertThat(outMock.verifyPrintlnLastCall("Fri Nov 25 19:34:55 CET 2016"), is(true));
    }
}
