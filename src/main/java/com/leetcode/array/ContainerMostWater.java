package com.leetcode.array;

public class ContainerMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int max = 0;

        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int limit = Math.min(height[i], height[j]);
            max = Math.max(max, limit * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
