package com.yandex;

import java.io.*;

public class AplusBFile {
    public static void main(String[] args) throws IOException {
        FileReader inputFileReader = new FileReader("input.txt");
        FileWriter outputFileWriter = new FileWriter("output.txt");
        BufferedReader reader = new BufferedReader(inputFileReader);
        String input = reader.readLine();
        reader.close();

        String[] substrings = input.split(" ");
        long a = Long.parseLong(substrings[0]);
        long b = Long.parseLong(substrings[1]);
        String result = String.valueOf(a + b);
        outputFileWriter.write(result);
        outputFileWriter.close();
    }
}
