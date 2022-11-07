package com.leetcode.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // Other solutions: https://www.enjoyalgorithms.com/blog/product-of-array-except-self
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,4};
        // before : {1, 1, 2, 6}
        // after :  {24, 12, 4, 1}
        int[] res = productExceptSelf(array1);
        System.out.println(Arrays.toString(res));

        int[] array2 = new int[]{0, 1};
        res = productExceptSelf(array2);
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
}
