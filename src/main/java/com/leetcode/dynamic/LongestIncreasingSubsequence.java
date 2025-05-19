package com.leetcode.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int right = nums[i];
                int left = nums[j];
                if (left < right) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }

        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int low = 0;
            int high = size;

            while (low < high) {
                int mid = (low + high) / 2;

                if (tails[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            tails[low] = num;
            if (low == size) size++;
        }
        return size;
    }
}
