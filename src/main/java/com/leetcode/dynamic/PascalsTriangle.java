package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle solution = new PascalsTriangle();
        int numRows = 5;
        System.out.println(solution.generate(numRows));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int rowNum = 0; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i <= rowNum; i++) {
                if (i == 0 || i == rowNum) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = triangle.get(rowNum - 1);
                    row.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
