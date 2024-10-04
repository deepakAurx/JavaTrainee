package com.aurx.main.printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterManager {
    List<Printer> printers=new ArrayList<>();
    void addPrinter(Printer printer){
        printers.add(printer);
    }
    private void printPages(int i) {
    for (Printer p:printers){
        if(p.isAvailable()) {
            p.printPages(i);
            break;
        }
    }
    }

    public static void main(String[] args) {
        PrinterManager manager=new PrinterManager();
        manager.addPrinter(new Printer1());
        manager.addPrinter(new Printer2());
        manager.addPrinter(new Printer3());
        manager.printPages(10);
        manager.printPages(20);
        manager.printPages(30);
        manager.printPages(40);
    }


}
