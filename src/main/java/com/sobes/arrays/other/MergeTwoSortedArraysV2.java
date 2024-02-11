package com.sobes.arrays.other;

/* Example
 *  a = [1,3,4];
 *  b = [2,3,5];
 * merge(a, b);
 * [1,2,3,3,4,5]
 * */

import java.util.Arrays;

public class MergeTwoSortedArraysV2 {
    public static void main(String[] args) {

        int[] b = new int[]{6, 7};
        int[] a = new int[]{2, 3, 5};
        int[] c = merge(a, b);
        System.out.println("Arrays.toString(c) = " + Arrays.toString(c));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aIdx = a.length - 1;
        int bIdx = b.length - 1;
        int cIdx = c.length - 1;

        while (bIdx >= 0) {
            if (aIdx >= 0 && a[aIdx] > b[bIdx]) {
                c[cIdx] = a[aIdx];
                aIdx--;
            } else {
                c[cIdx] = b[bIdx];
                bIdx--;
            }
            cIdx--;
        }
        return c;
    }
}
