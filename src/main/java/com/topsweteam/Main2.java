package com.topsweteam;

public class Main2 {
    public static void main(String[] args) {
        int ones = 0;
        int fives = 0;
        int tens = 0;

        int sum = 47;

        tens = sum / 10; // 4
        System.out.println("Tens: " + tens);
        fives = (sum - tens*10) / 5;
        System.out.println("Fives: " + fives);
        ones = sum - (tens*10 + fives*5);
        System.out.println("Ones: " + ones);

        System.out.println(tens + fives + ones);
    }
}
