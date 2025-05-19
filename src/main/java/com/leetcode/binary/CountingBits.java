package com.leetcode.binary;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int[] ans = countBits(5);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
