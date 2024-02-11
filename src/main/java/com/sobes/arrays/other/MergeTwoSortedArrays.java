package com.sobes.arrays.other;

/* Example
 *  a = [1,3,4];
 *  b = [2,3,5];
 * merge(a, b);
 * [1,2,3,3,4,5]
 * */

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {

        int[] a = new int[]{5, 6, 7};
        int[] b = new int[]{2, 3, 5};
        int[] c = merge(a, b);
        System.out.println("Arrays.toString(c) = " + Arrays.toString(c));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0; int j = 0; int k = 0;

        while (k < c.length) {
            if (i < a.length && j < b.length) {
                if (a[i] <= b[j]) {
                    c[k] = a[i];
                    i++;
                } else {
                    c[k] = b[j];
                    j++;
                }
            } else {
                if (i == a.length && j < b.length) {
                    c[k] = b[j];
                    j++;
                }
                if (i < a.length && j == b.length) {
                    c[k] = a[i];
                    i++;
                }
            }
            k++;
        }

        return c;
    }
}
