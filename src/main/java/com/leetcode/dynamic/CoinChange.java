package com.leetcode.dynamic;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount = 6;

        CoinChange solution = new CoinChange();
        System.out.println("Coins count: " + solution.coinChange(coins, amount));
    }


    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // "бесконечность"
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
