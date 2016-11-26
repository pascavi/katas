package org.tdd;

import java.io.*;

/**
 * Created by Pascual on 26/11/2016.
 */
class PrintStreamMock extends PrintStream {

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

    public boolean verifyPrintlnWasCalled() {
        return lastStringPrinted!=null;
    }

    public boolean verifyPrintlnLastCall(String input) {
        return input.equals(lastStringPrinted);
    }
}