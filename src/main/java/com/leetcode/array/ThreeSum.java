package com.leetcode.array;

// https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultArr = new ArrayList<>();

        if (nums.length < 3 || nums.length > 3000) {
            return resultArr;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            Map<Integer, Integer> diffMap = new HashMap<>();

            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i]; // nums[i] + nums[j] + nums[k] = 0, тогда nums[j] + nums[k] = -nums[i]
                int diff = target - nums[j];
                Integer index = diffMap.get(diff);

                if (index != null && index != i && index != j) {
                    resultArr.add(List.of(nums[i], nums[j], nums[j]));
                } else {
                    diffMap.put(nums[j], j);
                }
            }
        }
        return resultArr;
    }
}
