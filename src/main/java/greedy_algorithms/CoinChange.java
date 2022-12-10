package greedy_algorithms;

import java.util.Arrays;

public class CoinChange {

    public static void coinChange(int[] coins, int N) {
        Arrays.sort(coins);
        int index = coins.length;

        while (true) {
            int coinValue = coins[index - 1];
            index--;
            int maxAmount = (N / coinValue) * coinValue;

            if (maxAmount > 0) {
                System.out.println("Coin value: " + coinValue + " taken count: " + (N / coinValue));
                N = N - maxAmount;
            }

            if (N == 0) break;
        }
    }
}
