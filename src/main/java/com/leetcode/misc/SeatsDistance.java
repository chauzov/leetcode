package com.leetcode.misc;

public class SeatsDistance {

    public static void main(String[] args) {
        int[] seats1 = {1,0,0,0,1,0,1};
        int[] seats2 = {0,0,0,1,0,1};
        int[] seats3 = {1,0,0,1,0,0,0,0};
        System.out.println(maxDistToClosest(seats3));
    }

    public static int maxDistToClosest(int[] seats) {
        if (seats.length <= 2 || seats.length > 2*10000) {
            System.out.println("Seats length is out of range!");
            return 0;
        }

        int distance = 0;
        int emptySeatsNum = 0;
        int startPos = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0)
                emptySeatsNum++;
            else {
                if (startPos == 0) {
                    distance = emptySeatsNum;
                } else {
                    distance = Math.max(distance, (emptySeatsNum / 2) + (emptySeatsNum % 2));
                }
                emptySeatsNum = 0;
                startPos = seats[i];
            }
        }
        distance = Math.max(distance, emptySeatsNum);
        return distance;
    }
}
