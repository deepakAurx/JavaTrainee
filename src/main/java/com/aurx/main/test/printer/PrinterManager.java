package com.aurx.main.test.printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterManager {
    private final List<Printer> printers = new ArrayList<>();

    public void addPrinter(Printer printer) {
        System.out.println("Adding " + printer.getName());
        printers.add(printer);
    }

    public void printPages(int pages) {
            for (Printer printer : printers) {
                if (printer.isAvailable()) {
                    System.out.println(printer.getName() + " is available, assigning job with " + pages + " pages");
                    new Thread(() -> {
                        printer.printPages(pages);
                        System.out.println(printer.getName() + " has finished printing " + pages + " pages.");
                    }).start();
                    break;
                }
            }
    }

    public static void main(String[] args) {
        System.out.println("Starting Printer Manager test");
        PrinterManager manager = new PrinterManager();
        manager.addPrinter(new PrinterImpl("Printer 1"));
        manager.addPrinter(new PrinterImpl("Printer 2"));
        manager.addPrinter(new PrinterImpl("Printer 3"));
        manager.addPrinter(new PrinterImpl("Printer 4"));


        manager.printPages(10);
        manager.printPages(20);
        manager.printPages(30);
        manager.printPages(40);
        manager.printPages(50);
        manager.printPages(60);
    }
}
