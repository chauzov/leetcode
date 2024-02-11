package com.yandex;

import java.util.function.Function;

public class ComplexNumbers {
    public static void main(String[] args) {

        for (long i = 1; i <= 100; i++) {
            isComplex(i);
        }

    }

    private static boolean isComplex(Long num) {
        Function<Long, Long> getSum = x -> {
            long sum = 0;
            while (x > 0) {
                sum = sum + x % 10;
                x = x / 10;
            }
            return sum;
        };

        Function<Long, Double> getComplex = k -> (3*k) / Math.pow(getSum.apply(k), 2);

        System.out.println("Num: " + num + ", result: " + getComplex.apply(num));

        return false;
    }
}
