package org.tdd;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class PrintDateTest {

    private class PrintStreamStub extends PrintStream {
        PrintStreamStub(File dummy) throws FileNotFoundException {
            super(new OutputStream() {
                @Override
                public void write(int b) throws IOException {

                }
            });
        }

        public void println(Object input) {
            // Manual stub
        }
    }

    PrintDate printDate;
    @Before
    public void setUp() throws Exception {
        printDate = new PrintDate(new PrintStreamStub(null));
    }


    @Test
    public void keepPrinting() throws Exception {
        printDate.printCurrentDate();
    }
    // Prints Fri Nov 25 19:34:55 CET 2016

}
