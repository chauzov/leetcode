package com.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AplusB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String[] substrings = input.split(" ");
        long a = Long.parseLong(substrings[0]);
        long b = Long.parseLong(substrings[1]);
        System.out.println(a + b);
    }
}
