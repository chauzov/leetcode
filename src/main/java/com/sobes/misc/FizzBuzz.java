package com.sobes.misc;

public class FizzBuzz {

    private static int numOfNumbers = 50;

    public static void main(String[] args) {

        for (int i = 1; i <= numOfNumbers; i++) {
            System.out.println(checkNumber(i));
        }
    }

    public static String checkNumber(int number) {
        if (number % 5 == 0) {
            if (number % 7 == 0) {
                return "fizzbuzz";
            }
            return "fizz";
        }

        if (number % 7 == 0) {
            return "buzz";
        }

        return String.valueOf(number);
    }
}
