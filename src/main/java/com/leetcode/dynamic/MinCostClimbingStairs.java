package com.leetcode.dynamic;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] costs = {10, 15, 20, 25};

        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        System.out.println(solution.minCostClimbingStairs(costs));
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;

        int a = cost[0];
        int b = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int c = b;
            b = cost[i] + Math.min(a, b);
            a = c;
        }
        return Math.min(a, b);
    }
}
