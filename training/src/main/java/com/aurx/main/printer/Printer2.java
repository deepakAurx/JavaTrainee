package com.aurx.main.printer;

public class Printer2 implements Printer{
    boolean busy;
    @Override
    public void printPages(int pages) {
            System.out.println("Printer2 is printing: "+pages);
        busy=false;
    }

    @Override
    public boolean isAvailable() {
        return !busy;
    }
}
