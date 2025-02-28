package com.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestStringWithoutRepeat {
    public static void main(String[] args) {
        String s1 = "qwertyqazsxqe"; //7
        String s2 = "pwwkew"; // 3
        String s3 = "dvdf"; // 3
        String s4 = "asjrgapa"; //6
        System.out.println(" --- getSubstringLength ---");
        System.out.println("s1: " + getSubstringLength(s1));
        System.out.println("s2: " + getSubstringLength(s2));
        System.out.println("s3: " + getSubstringLength(s3));
        System.out.println("s4: " + getSubstringLength(s4));
        System.out.println(" --- longestUniqueSubstr ---");
        System.out.println("s1: " + longestUniqueSubstr(s1));
        System.out.println("s2: " + longestUniqueSubstr(s2));
        System.out.println("s3: " + longestUniqueSubstr(s3));
        System.out.println("s4: " + longestUniqueSubstr(s4));
    }

    private static int getSubstringLength(String s) {
        int maxLength = 0;
        Set<Character> visited = new HashSet<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            while (visited.contains(currentChar)) {
                visited.remove(s.charAt(left));
                left++;
            }

            visited.add(currentChar);
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }

    // Быстрее в 3 раза
    static int longestUniqueSubstr(String s) {
        int maxLength = 0;
        boolean[] visited = new boolean[256];

        int left = 0, right = 0;
        while (right < s.length()) {

            while (visited[s.charAt(right)]) {
                visited[s.charAt(left)] = false;
                left++;
            }

            visited[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }
}
