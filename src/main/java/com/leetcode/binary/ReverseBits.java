package com.leetcode.binary;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596));
    }
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;           // Сдвигаем result влево на 1
            System.out.println("i = " + i + ", result: " + Integer.toBinaryString(result));

            result = result | (n & 1);      // Добавляем последний бит из n
            System.out.println("i = " + i + ", result: " + Integer.toBinaryString(result));

            n = n >>> 1;               // Сдвигаем n вправо (беззнаково)
            System.out.println("i = " + i + ", n: " + Integer.toBinaryString(n));
        }
        return result;
    }
}
