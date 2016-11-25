package org.tdd;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrintDateTest {
    private class PrintStreamMock extends PrintStream {
        private boolean isPrintlnCalled = false;

        PrintStreamMock(File dummy) throws FileNotFoundException {
            super(new OutputStream() {
                @Override
                public void write(int b) throws IOException {

                }
            });
        }

        public void println(Object input) {
            // Manual stub
            isPrintlnCalled = true;
        }

        public boolean verify() {
            return isPrintlnCalled;
        }
    }

    PrintStreamMock outMock;
    PrintDate printDate;
    @Before
    public void setUp() throws Exception {
        outMock = new PrintStreamMock(null);
        printDate = new PrintDate(outMock);
    }


    @Test
    public void keepPrinting() throws Exception {
        printDate.printCurrentDate();
    }
    // Prints Fri Nov 25 19:34:55 CET 2016

    @Test
    public void testPrintlnIsCalled() {
        printDate.printCurrentDate();
        assertThat(outMock.verify(), is(true));
    }
}
