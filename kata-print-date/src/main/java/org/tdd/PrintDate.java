package org.tdd;

import java.io.PrintStream;

interface OutInterface{
    void println(String input);
}

interface DateInterface{
    String toString();
}

class PrintDate {
        private OutInterface out;
    private DateInterface date;

    PrintDate(){
        //out & date private properties are the usual console out and a current date objects
        setOut(System.out);
        setDate(new java.util.Date());
    }

    //setter allowing to replace collaborators
    void setOut(OutInterface out) {
        this.out = out;
    }

    void setDate(DateInterface date) {
        this.date = date;
    }

    void setOut(PrintStream out) {
        final PrintStream _out = out;
        this.out = new OutInterface() {
            @Override
            public void println(String input) {
                _out.println(input);
            }
        };
    }

    void setDate(java.util.Date date) {
        final java.util.Date _date = date;
        this.date =  new DateInterface() {
            @Override
            public String toString() {
                return _date.toString();
            }
        };
    }

    //code under test
    void printCurrentDate() {
        this.out.println(date.toString());
    }
}
