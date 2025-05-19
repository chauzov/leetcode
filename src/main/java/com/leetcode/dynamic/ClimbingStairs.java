package com.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.countWays2(10));
    }

    private int countWays(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return countWays(n, cache);
    }

    private int countWays(int n, Map<Integer, Integer> cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        int result = countWays(n - 1, cache) + countWays(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    private int countWays2(int n) {
        int s0 = 1;
        int s1 = 1;

        if (n < 2) return 1;

        int sN = 0;
        for (int i = 2; i < n + 1; i++) {
            sN = s0 + s1;
            s0 = s1;
            s1 = sN;
            System.out.println("sN: " + sN);
        }
        return sN;
    }
}
