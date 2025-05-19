package com.leetcode.dynamic;

public class MinCostForTickets {
    public static void main(String[] args) {
        MinCostForTickets solution = new MinCostForTickets();
        int[] costs = {2, 7, 15};
        int[] days = {1,4,6,7,8,20};
        System.out.println(solution.mincostTickets(days, costs));
    }
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travelDays = new boolean[366]; // День 1..365
        for (int day : days) {
            travelDays[day] = true;
        }

        int[] dp = new int[366];

        for (int i = 1; i <= 365; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1]; // в этот день поездки нет
            } else {
                dp[i] = Math.min(
                        dp[Math.max(0, i - 1)] + costs[0],   // билет на 1 день
                        Math.min(
                                dp[Math.max(0, i - 7)] + costs[1], // билет на 7 дней
                                dp[Math.max(0, i - 30)] + costs[2] // билет на 30 дней
                        )
                );
            }
        }

        return dp[days[days.length - 1]]; // стоимость до последнего дня поездки
    }

}
