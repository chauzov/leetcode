package com.sobes.strings;

import java.util.HashMap;
import java.util.Map;

public class DetectPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("none"));
    }

    public static boolean isPalindrome(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        int head = 0;
        int tail = chars.length - 1;

        while( head < tail) {
            if (chars[head] != chars[tail]) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
