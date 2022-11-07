package com.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int prevElement = nums[0];
        int insertionIndex = 0;
        boolean duplicateFound = false;

        for (int currentPosition = 0; currentPosition < nums.length; currentPosition++) {

            if (currentPosition == 0) {
                insertionIndex++;
                continue;
            }

            // For readability
            int currentElement = nums[currentPosition];

            if (!duplicateFound) {
                if (currentElement != prevElement) {
                    if (currentPosition != insertionIndex) {
                        nums[insertionIndex] = currentElement;
                    }
                    prevElement = currentElement;
                    insertionIndex++;
                    continue;
                }
                // Current equal to previous - duplicate detected
                duplicateFound = true;
            } else {
                if (currentElement == prevElement || currentElement < prevElement) { // duplicate again - skip
                    continue;
                }
                // Unique element found - move to insertionIndex
                nums[insertionIndex] = currentElement;
                prevElement = currentElement;
                insertionIndex++;
                duplicateFound = false;
            }
        }
        return insertionIndex;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 5, 5, 5, 5, 5, 7, 9, 9, 12, 12, 15};
        int[] expectedNums = {1, 2, 4, 5, 7, 9, 12, 15};

        int k = removeDuplicates(nums);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

        System.out.println("Updated nums: " + Arrays.toString(nums));
    }


}
