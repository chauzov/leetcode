package com.yandex;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TheGame {
    public static void main(String[] args) {
        Queue<Integer> numbers = generateNumbers();

        int petyaTotal = 0;
        int petyaLastNum = 0;
        int vasyaTotal = 0;
        int vasyaLastNum = 0;

        petyaLastNum = numbers.poll();
        System.out.println("Petya has taken " + petyaLastNum);
        boolean petyaTurn = false;

        while (!numbers.isEmpty()) {
            if (petyaTurn) {
                petyaLastNum = numbers.poll();
                petyaTotal += petyaLastNum;
                System.out.println("Petya has taken " + petyaLastNum);
            } else {
                vasyaLastNum = numbers.poll();
                vasyaTotal += vasyaLastNum;
                System.out.println("Vasya has taken " + vasyaLastNum);
            }
            petyaTurn = petyaLastNum < vasyaLastNum;
        }

        System.out.println("Petya total: " + petyaTotal);
        System.out.println("Vasya total: " + vasyaTotal);

    }

    private static Queue<Integer> generateNumbers() {
        Queue<Integer> integers = new ArrayDeque<>();

        while (integers.size() != 100) {
            int num = ThreadLocalRandom.current().nextInt(1, 101);
            if (!integers.contains(num)) {
                integers.add(num);
            }
        }

        return integers;
    }

}

