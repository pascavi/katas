package org.tdd;

import java.io.PrintStream;
import java.util.Date;

/**
 * Created by Pascual on 28/05/2016.
 */
public class PrintDate {

    private PrintStream out;

    PrintDate(PrintStream out) {
        this.out = out;
    }

    public void printCurrentDate() {
        this.out.println(new Date());
    }
}
