package com.leetcode.array;

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,1};
        System.out.println("Contains: " + containsDuplicate(array1));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numsMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                return true;
            }
            numsMap.put(nums[i], i);
        }
        return false;
    }
}
