package com.sobes.strings;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWithArray("qwes"));
    }

    public static String reverseWithBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseWithBuffer(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    public static String reverseWithStack(String str) {
        if (str == null || str.isEmpty() || str.isBlank()) {
            return str;
        }

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static String reverseWithArray(String str) {
        if (str == null || str.isEmpty() || str.isBlank()) {
            return str;
        }
        char[] chars = str.toCharArray();

        int head = 0;
        int tail = chars.length - 1;

        while (head < tail) {
            char tmp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = tmp;
            head++;
            tail--;
        }

        return new String(chars);
    }
}
