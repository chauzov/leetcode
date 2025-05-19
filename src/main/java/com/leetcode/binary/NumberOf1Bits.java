package com.leetcode.binary;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        byte bitsNumber = 0;

        while (n != 0) {
            if ((n & 1) == 1) bitsNumber++;
            n = n >> 1;
        }

        return bitsNumber;
    }
}
