package com.leetcode.binary;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 3, 1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber2(nums));
    }

    public int missingNumber(int[] nums) {
        boolean[] found = new boolean[nums.length + 1];
        for (int num : nums) {
            found[num] = true;
        }

        for (int i = 0; i < found.length; i++) {
            if (!found[i]) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber2(int[] nums) {
        int sumReal = 0;
        int sumFull;
        int n = nums.length;

        for (int num : nums) {
            sumReal += num;
        }
        sumFull = n * (n + 1) / 2;
        return sumFull - sumReal;
    }
}
