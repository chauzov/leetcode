package com.leetcode.array;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array
[a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.
*/

import java.util.Arrays;

public class MinimumRotatedSorted {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums1 = {6,7,9,11,13,18,3,5};
        System.out.println(findMin(nums));
        System.out.println(findMin(nums1));
    }

    public static int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) { // starts from minimal
            return nums[0];
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int mid = nums.length / 2;
        int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid, nums.length);
        int minLeft = findMin(leftArr);
        int minRight = findMin(rightArr);
        return Math.min(minLeft, minRight);
    }
}
