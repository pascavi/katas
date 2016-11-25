package org.tdd;

import java.io.PrintStream;
import java.util.Date;

/**
 * Created by Pascual on 28/05/2016.
 */
public class PrintDate {

    private PrintStream out;
    private Date date;

    PrintDate(PrintStream out, Date date) {
        this.out = out;
        this.date = date;
    }

    public void printCurrentDate() {
        this.out.println(date.toString());
    }
}
