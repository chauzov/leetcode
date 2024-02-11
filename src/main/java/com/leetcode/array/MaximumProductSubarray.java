package com.leetcode.array;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums1 = {0,8,3,0,4,-2,4,5,2};
        int[] nums2 = {-5};
        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int prod = 1;

        for (int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            max = Math.max(prod, max);
            if (prod == 0) prod = 1;
        }

        prod = 1;
        for (int i = nums.length - 1; i>=0; i--) {
            prod = prod * nums[i];
            max = Math.max(prod, max);
            if (prod == 0) prod = 1;
        }

        return max;
    }
}
