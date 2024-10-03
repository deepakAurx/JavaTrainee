package com.aurx.main;

public class ChocolateProblem {

    public static void main(String[] args) {
        int price=1;
        int money=15;
        int wrap=3;
        countChoco(money,price,wrap);
    }

    private static void countChoco(int money, int price, int wrap) {
        int chocolate=money/price;
        int wrappers=chocolate;
        int totalChoco=chocolate+countChocoFromWrapers(wrappers,wrap);
        System.out.println(totalChoco);
    }

    private static int countChocoFromWrapers(int wrappers, int wrap) {
        if(wrappers<wrap){
            return  0;
        }
        int newChocolate=wrappers/wrap;
        int remainingChoco=wrappers%wrap;
        return newChocolate+countChocoFromWrapers(newChocolate+remainingChoco,wrap);
    }

  /*  private static void countChoco(int money, int price, int wrap) {
        int choclate=money/price;
//        money-=choclate;
        int totalChoco=choclate;
        int wrappers=choclate;
        while(wrappers>=wrap){
            int newChoclate=wrappers/wrap;
            totalChoco+=newChoclate;
            wrappers=newChoclate+wrappers%wrap;

        }
        System.out.println(totalChoco);
    }

    private static void countChoco2(int money, int price, int wrap) {
        int chocolates=money/price;
        int totalChoco=chocolates;
        int wrappers=chocolates;
        while (wrappers/wrap > 0) {
            int newChocolates=wrappers/wrap;
            int remainingWrappers = wrappers%wrap;
            totalChoco = totalChoco + newChocolates;
            wrappers = remainingWrappers + newChocolates;
        }
        /*while(wrappers>=wrap){
            int newChocolates=wrappers/wrap;
            totalChoco+=newChocolates;
            if(wrappers<10)
                wrappers=newChocolates+wrappers%wrap;
            else{
                wrappers=newChocolates;
            }
        }
        System.out.println(totalChoco);
    }*/
}
