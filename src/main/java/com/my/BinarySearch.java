package com.my;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = makeArray(1_000_000);
        int wanted = 500_001;
        int index = findNumber(array, wanted);
        System.out.println("Found number " + wanted + " at position " + index);
    }

    private static int[] makeArray(int size) {
        LocalTime startedAt = LocalTime.now();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        LocalTime finishedAt = LocalTime.now();
        System.out.println("Create array within microseconds: " + ChronoUnit.MICROS.between(startedAt, finishedAt));
        return array;
    }

    private static int findNumber(int[] array, int number) {
        LocalTime startedAt = LocalTime.now();
        int low = 0;
        int high = array.length - 1;
        int count = 0;

        while (low <= high) {
            count++;
            int mid = (low + high) / 2;

            if (array[mid] == number) {
                LocalTime finishedAt = LocalTime.now();
                System.out.println("Number of attempts: " + count);
                System.out.println("Found number within microseconds: " + ChronoUnit.MICROS.between(startedAt, finishedAt));
                return mid;
            }

            if (array[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
