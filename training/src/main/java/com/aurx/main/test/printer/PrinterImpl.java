package com.aurx.main.test.printer;

public class PrinterImpl implements Printer {

    String name;
    boolean available = true;
    public PrinterImpl(String name) {
        this.name = name;
    }


    @Override
    public void printPages(int pages) {
        synchronized (this) {
            available = false;
            for (int i = 1; i <= pages; i++) {
//        System.out.println(name + " printing pages " + i + " of " + pages);
                try {
                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            available = true;
        }
    }



    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
