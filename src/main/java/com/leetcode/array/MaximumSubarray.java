package com.leetcode.array;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        int[] nums2 = {1}; // 1
        int[] nums3 = {5,4,-1,7,8}; // 23
        int[] nums4 = {-1,0,-2}; // 0
        int[] nums5 = {-2, -1}; // -1
        int[] nums6 = {-2, 1};
        int[] nums7 = {-1, -2};

        System.out.println(getMaxSubarray(nums1));
        System.out.println(getMaxSubarray(nums2));
        System.out.println(getMaxSubarray(nums3));
        System.out.println(getMaxSubarray(nums4));
        System.out.println(getMaxSubarray(nums5));
        System.out.println(getMaxSubarray(nums6));
        System.out.println(getMaxSubarray(nums7));
    }

    private static int getMaxSubarray(int[] nums) {
        if (nums.length < 1 || nums.length > Math.pow(10, 5)) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max = nums[0];
                continue;
            }

            if (sum < nums[i] && sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
