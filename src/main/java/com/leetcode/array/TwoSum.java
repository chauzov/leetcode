package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] array1 = {2,7,11,15};

        System.out.println("Array 1: " + Arrays.toString(twoSum(array1, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer index = diffMap.get(diff);

            if (index != null) {
                return new int[]{index, i};
            }
            diffMap.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
