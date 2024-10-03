package com.aurx.main.printer;

public class Printer3 implements Printer{
    boolean busy;
    @Override
    public void printPages(int pages) {
            System.out.println("Printer3 is printing: "+pages);
        busy=false;
        }

    @Override
    public boolean isAvailable() {
        return !busy;
    }
}

