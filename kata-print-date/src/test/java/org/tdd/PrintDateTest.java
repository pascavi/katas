package org.tdd;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintDateTest {
    private class PrintStreamMock extends PrintStream {

        private String lastStringPrinted;

        PrintStreamMock(File dummy) throws FileNotFoundException {
            super(new OutputStream() {
                @Override
                public void write(int b) throws IOException {

                }
            });
        }

        public void println(String input) {
            // Manual stub
            lastStringPrinted = input;
        }

        public boolean verify(String input) {
            return input.equals(lastStringPrinted);
        }
    }

    private class DateMock extends Date {

        @Override
        public String toString() {
            return "Fri Nov 25 19:34:55 CET 2016";
        }
    }


    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void keepPrinting() throws Exception {
        PrintStreamMock outMock = new PrintStreamMock(null);
        PrintDate printDate = new PrintDate(outMock, new Date());

        printDate.printCurrentDate();
    }
    // Prints Fri Nov 25 19:34:55 CET 2016

    @Test
    public void testPrintlnIsCalled() throws Exception {

        PrintStreamMock outMock = new PrintStreamMock(null);
        PrintDate printDate = new PrintDate(outMock, new DateMock());

        printDate.printCurrentDate();
        assertThat(outMock.verify("Fri Nov 25 19:34:55 CET 2016"), is(true));
    }
}
