package com.aurx.main.printer;

public class Printer1 implements  Printer{
boolean busy;
    @Override
    public void printPages(int pages) {
        busy=true;
            System.out.println("Printer1 is printing: "+pages);
            busy=false;
    }

    @Override
    public boolean isAvailable() {
        return !busy;
    }

}
