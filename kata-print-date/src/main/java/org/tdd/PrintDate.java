package org.tdd;

interface OutInterface{
    void println(String input);
}

interface DateInterface{
    String toString();
}

class PrintDate {
    //out & date private properties are the usual console out and a current date objects
    private OutInterface out = new OutInterface() {
        @Override
        public void println(String input) {
            System.out.println(input);
        }
    };
    private DateInterface date = new DateInterface() {
        @Override
        public String toString() {
            return new java.util.Date().toString();
        }
    };

    //setter allowing to replace collaborators
    void setOut(OutInterface out) {
        this.out = out;
    }

    void setDate(DateInterface date) {
        this.date = date;
    }

    //code under test
    void printCurrentDate() {
        this.out.println(date.toString());
    }
}
