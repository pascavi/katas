package org.tdd;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PrintDateTest {
    private PrintDate printDate;
    private PrintStreamMock outMock;
    private DateMock dateMock;
    private PrintStream printStreamMockito;
    private java.util.Date dateMockito;

    @Before
    public void setUp(){
        printDate = new PrintDate();
        outMock = new PrintStreamMock();
        dateMock = new DateMock();
        printStreamMockito = mock(PrintStream.class);
        dateMockito = mock(java.util.Date.class);
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

    @Test
    public void printlnIsCalledViaMockito() throws Exception {
        printDate.setOut(printStreamMockito);
        printDate.setDate(dateMockito);
        when(dateMockito.toString()).thenReturn("Fri Nov 25 19:34:55 CET 2016");
        printDate.printCurrentDate();
        verify(printStreamMockito).println("Fri Nov 25 19:34:55 CET 2016");
    }
}
