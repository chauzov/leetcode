package com.topsweteam;

public class Main {
    public static void main(String[] args) {
        String str = "yxxaabbbcc";
        System.out.println(encodeString(str));
    }

    private static String encodeString(String str) {
        char[] charArr = str.toCharArray();
        StringBuilder result = new StringBuilder();
        char prev = ' ';
        int cnt = 1;

        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] == charArr[i - 1]) {
                cnt++;
            } else {
                if (cnt == 1) {
                    result.append(charArr[i - 1]);
                } else {
                    result.append(charArr[i - 1]).append(cnt + "");
                    cnt = 1;
                }

            }

            if (i == charArr.length - 1) {
                if (cnt == 1) {
                    result.append(charArr[i - 1]);
                } else {
                    result.append(charArr[i - 1]).append(cnt + "");
                    cnt = 1;
                }
            }
        }
        return result.toString();
    }
}
