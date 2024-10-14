package com.leetcode.misc;

public class SeatDistance2 {
    public static void main(String[] args) {
        int[] seats1 = {1,0,0,0,1,0,1};
        int[] seats2 = {0,0,0,1,0,1};
        int[] seats3 = {1,0,0,1,0,0,0,0};
        System.out.println(maxDistToClosest(seats1));
        System.out.println(maxDistToClosest(seats2));
        System.out.println(maxDistToClosest(seats3));
    }

    public static int maxDistToClosest(int[] seats) {
        if (seats.length < 3 || seats.length > 1000) {
            return -1;
        }

        int maxDistance = -1;
        int currentDistance = 0;
        boolean firstBusyFound = false;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 && !firstBusyFound) {
                currentDistance = 1;
                firstBusyFound = true;
                continue;
            }
            if (seats[i] == 0 && firstBusyFound) {
                currentDistance++;
                continue;
            }
            if (seats[i] == 1 && firstBusyFound) {
                currentDistance++;
                maxDistance = Math.max(maxDistance, currentDistance);
                currentDistance = 0;
            }
        }
        return maxDistance;
    }
}
