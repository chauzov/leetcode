package com.leetcode.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // Other solutions: https://www.enjoyalgorithms.com/blog/product-of-array-except-self
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,4};
        // after :  {24, 12, 8, 6}
        // left : {1, 1, 2, 6}
        // right : {24, 12, 4, 1}
        int[] res = productExceptSelf2(array1);
        System.out.println(Arrays.toString(res));

        int[] array2 = new int[]{0, 1};
        res = productExceptSelf2(array2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int lastIndex = size - 1;

        int productBefore = nums[0];
        int[] before = new int[size];
        before[0] = 1;
        for (int i = 1; i < size; i++) {
            before[i] = productBefore;
            productBefore *= nums[i];
        }

        int productAfter = nums[lastIndex];
        int[] after = new int[size];
        after[lastIndex] = 1;
        for (int i = lastIndex - 1; i >= 0; i--) {
            after[i] = productAfter;
            productAfter *= nums[i];
        }

        for (int i = 0; i < size; i++) {
            nums[i] = before[i] * after[i];
        }

        return nums;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];

        rightArray[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] * nums[i + 1];
        }

        leftArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftArray[i] = leftArray[i - 1] * nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftArray[i] * rightArray[i];
        }
        return nums;
    }
}
