package com.my;

import java.util.Random;

public class Util {
    public static int[] generateRandomArray(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0");
        }

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min; // Генерация числа в диапазоне [min, max]
        }

        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static void printArray(int[] array, int from, int to) {
        System.out.print("Sorted array from " + from + " to " + to + ": [");
        for (int i = from; i <= to; i++) {
            System.out.print(array[i]);
            if (i < to) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }

    public static int[] mergeArrays(int[] less, int lessCounter, int pivot, int[] greater, int greaterCounter) {
        int[] array = new int[less.length + 1 + greater.length];

        int index = 0;
        for (int i = 0; i < lessCounter; i++, index++) {
            array[index] = less[i];
        }
        array[index] = pivot;
        index++;
        for (int i = 0; i < greaterCounter; i++, index++) {
            array[index] = greater[i];
        }

        return array;
    }
}
