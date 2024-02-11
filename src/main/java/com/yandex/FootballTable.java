package com.yandex;

import java.util.ArrayList;
import java.util.List;

public class FootballTable {

    private static final String WIN = "W";
    private static final String LOOSE = "L";
    private static final String DRAW = "D";
    private static final String SELF = "X";


    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        results.add("Linux - Gentoo - 1:0");
        results.add("Gentoo - Windows - 2:1");
        results.add("Linux - Windows - 0:2");
    }
}
