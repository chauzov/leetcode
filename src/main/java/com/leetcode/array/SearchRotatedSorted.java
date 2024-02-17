package com.leetcode.array;

/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is:
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).

For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
*/

import java.util.Arrays;

public class SearchRotatedSorted {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 50));
    }

    public static int search(int[] nums, int target) {
        return searchRecurs(nums, target, 0);
    }

    private static int searchRecurs(int[] nums, int target, int startIdx) {
        if (nums.length == 1) {
            return nums[0] == target ? startIdx : -1;
        }

        if (nums[0] < nums[nums.length - 1] && nums[nums.length - 1] < target) {
            return -1;
        }

        int mid = nums.length / 2;
        int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid, nums.length);

        int leftResult = searchRecurs(leftArr, target, startIdx);
        int rightResult = searchRecurs(rightArr, target, startIdx + mid);
        if (leftResult != -1) {
            return leftResult;
        }
        return rightResult;
    }
}
