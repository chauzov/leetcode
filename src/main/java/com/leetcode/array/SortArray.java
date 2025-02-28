package com.leetcode.array;


public class SortArray {
    public static void main(String[] args) {
        int[] nums1 = {5,2,3,1};
        quickSort(nums1, 0, nums1.length - 1);
        System.out.println(nums1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pi = partition(nums, left, right);

            quickSort(nums, left, pi - 1);
            quickSort(nums, pi + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = 0;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        int tmp = nums[i + 1];
        nums[i + 1] = nums[right];
        nums[right] = tmp;

        return i + 1;
    }
}
