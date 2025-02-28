package com.leetcode.binary;

public class SumTwoIntegers {
    public static void main(String[] args) {
        Integer a = 2;
        Integer b = 3;

        System.out.println(sum(a, b));
    }

    private static int sum(Integer a, Integer b) {
        int save = (a & b) << 1;
        int res = a^b;
        if (save == 0) return res;
        return sum(save, res);
    }
}
