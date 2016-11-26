package org.tdd;

/**
 * Created by Pascual on 26/11/2016.
 */
class PrintStreamMock implements OutInterface {

    private String lastStringPrinted;

    public void println(String input) {
        lastStringPrinted = input;
    }

    boolean verifyPrintlnWasCalled() {
        return lastStringPrinted!=null;
    }

    boolean verifyPrintlnLastCall(String input) {
        return input.equals(lastStringPrinted);
    }
}