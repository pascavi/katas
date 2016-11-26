package org.tdd;

interface OutInterface{
    void println(String input);
}

interface DateInterface{
    String toString();
}


class PrintDate {

    private OutInterface out;
    private DateInterface date;

    PrintDate(OutInterface out, DateInterface date) {
        this.out = out;
        this.date = date;
    }

    void printCurrentDate() {
        this.out.println(date.toString());
    }
}
