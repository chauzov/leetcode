package com.my;

import java.time.Duration;
import java.time.LocalTime;

public class QuickSort {
    private final int arraySize = 1_000_000;

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int runs = 10;
        long unsortedFirstTotal = 0;
        long unsortedMidTotal = 0;
        long sortedMidTotal = 0;

        for (int i = 0; i < runs; i++) {
            unsortedFirstTotal += quickSort.testUnsortedPivotFirst();
            unsortedMidTotal += quickSort.testUnsortedPivotMid();
            sortedMidTotal += quickSort.testSortedPivotMid();
            System.out.print(i + " ");
        }

        System.out.println("\nUnsorted, pivot is first, avg time: " + unsortedFirstTotal / runs);
        System.out.println("Unsorted, pivot is a middle, avg time: " + unsortedMidTotal / runs);
        System.out.println("Sorted, pivot is a middle, avg time: " + sortedMidTotal / runs);
    }

    private int[] quickSort(int[] array, int size, boolean useMid) {
        if (size < 2) {
            return array;
        }

        int pivot = useMid ? array[array.length/2] : array[0];
        int[] less = new int[size - 1];
        int[] greater = new int[size - 1];
        int lessCounter = 0;
        int greaterCounter = 0;

        for (int i = 1; i < size; i++) {
            if (array[i] <= pivot) {
                less[lessCounter] = array[i];
                lessCounter++;
            } else {
                greater[greaterCounter] = array[i];
                greaterCounter++;
            }
        }

        less = quickSort(less, lessCounter, useMid);
        greater = quickSort(greater, greaterCounter, useMid);

        return Util.mergeArrays(less, lessCounter, pivot, greater, greaterCounter);
    }

    private long testUnsortedPivotFirst() {
        int[] array = Util.generateRandomArray(arraySize, 1, arraySize);

        LocalTime started = LocalTime.now();
        int[] sorted = quickSort(array, array.length, false);

        long millis = Duration.between(started, LocalTime.now()).toMillis();
        return millis;
    }

    private long testUnsortedPivotMid() {
        int[] array = Util.generateRandomArray(arraySize, 1, arraySize);

        LocalTime started = LocalTime.now();
        int[] sorted = quickSort(array, array.length, true);

        long millis = Duration.between(started, LocalTime.now()).toMillis();
        return millis;
    }

    private void testSortedPivotFirst() {
        System.out.println("Sorted, pivot is first element");
        int[] array = Util.generateSortedArray(arraySize);

        LocalTime started = LocalTime.now();
        int[] sorted = quickSort(array, array.length, false);

        long millis = Duration.between(started, LocalTime.now()).toMillis();
        Util.printArray(sorted, 0, 9);
        System.out.println("Sorting took milliseconds: " + millis);
        System.out.println("\n");
    }

    private long testSortedPivotMid() {
        int[] array = Util.generateSortedArray(arraySize);

        LocalTime started = LocalTime.now();
        int[] sorted = quickSort(array, array.length, true);

        long millis = Duration.between(started, LocalTime.now()).toMillis();
        return millis;
    }
}
