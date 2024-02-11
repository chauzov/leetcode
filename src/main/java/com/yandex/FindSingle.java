package com.yandex;

import java.util.*;

public class FindSingle {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1, 3, 2, 4, 5, 4, 5};
        System.out.println(getSingle(nums));
        System.out.println(getSingleBySet(nums));
    }

    private static int getSingle(int[] nums) {
        Arrays.sort(nums); // {1, 1, 2, 2, 3, 3, 4, 4, 5}
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1) {
                return nums[i];
            }

            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }

        }
        return -1;
    }

    private static int getSingleBySet(int[] nums) {
        Set<Integer> intSet = new HashSet<>();

        for (int num : nums) {
            if (intSet.contains(num)) {
                intSet.remove(num);
            } else {
                intSet.add(num);
            }
        }

        return intSet.stream().findFirst().get();
    }
}
