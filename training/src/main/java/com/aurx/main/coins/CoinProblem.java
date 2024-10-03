package com.aurx.main.coins;

import java.util.Arrays;

public class CoinProblem {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        Arrays.sort(coins);
        int count = 0;
       /* for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
//                System.out.println(amount);
            }
        }*/
        int i = coins.length - 1;
        while (amount >= 0 && i >= 0) {
            count += amount / coins[i];
            amount = amount % coins[i];
            i--;
        }
        if (amount == 0) {
            return count;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
        int[] coins = {5, 2};
        int amount = 13;
        System.out.println(coinChange(coins, amount));
    }
}
