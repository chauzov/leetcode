package com.leetcode.dynamic;


public class MinOpsToConvertTime {
    public static void main(String[] args) {
        String current = "09:41";
        String correct = "10:34";

        MinOpsToConvertTime solution = new MinOpsToConvertTime();
        System.out.println(solution.convertTime(current, correct));
    }

    public int convertTime(String current, String correct) {
        int currentMinutes = timeToMinutes(current);
        int correctMinutes = timeToMinutes(correct);

        int opsCount = 0;
        int diff = correctMinutes - currentMinutes;

        int[] minutes = {60, 15, 5, 1};

        for (int minute : minutes) {
            opsCount += diff / minute;
            diff = diff % minute;
        }

        return opsCount;
    }

    private int timeToMinutes(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return hours * 60 + minutes;
    }
}
