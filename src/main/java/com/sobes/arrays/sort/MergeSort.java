package com.sobes.arrays.sort;

// Сортировка слиянием

import java.util.Arrays;

public class MergeSort {
    private static int sortNextCounter = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 3, 5, 2};
        sort(arr);
        System.out.println("result = " + Arrays.toString(arr));
    }

    public static void sort(int[] array) {
        int srcLen = array.length;
        if (srcLen == 1) {
            return;
        }

        // array {1, 2, 4, 5, 3, 5, 2}
        // array length is 7
        int mid = srcLen / 2; // middle is 3
        int[] left = new int[mid]; // new array of 3 elements
        int[] right = new int[srcLen - mid]; // new array of 4 elements

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, srcLen - mid);

        sort(left);
        sort(right);
        merge(array, left, right);
    }

    public static void merge(int[] src, int[] left, int[] right) {
        int k = 0, i = 0, j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                src[k] = left[i];
                i++;
            } else {
                src[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            src[k] = left[i];
            k++; i++;
        }

        while (j < right.length) {
            src[k] = right[j];
            k++; j++;
        }
    }
}

