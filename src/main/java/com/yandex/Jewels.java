package com.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Jewels {
    public static void main(String[] args) throws IOException {

        //System.out.print("Enter jewels: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] jewels = reader.readLine().toCharArray();
        //System.out.print("Enter stones: ");
        char[] stones = reader.readLine().toCharArray();

        Map<Character, Integer> numberOfJewels = new HashMap<>();

        for (int i = 0; i < jewels.length; i++) {
            numberOfJewels.put(jewels[i], 0);
        }

        for (int i = 0; i < stones.length; i++) {
            char stone = stones[i];
            if (numberOfJewels.containsKey(stone)) {
                Integer count = numberOfJewels.get(stone);
                numberOfJewels.put(stone, count + 1);
            }
        }

        int count = 0;
        for(Map.Entry<Character, Integer> entry : numberOfJewels.entrySet()) {
            count = count + entry.getValue();
        }

        System.out.println(count);
    }
}
