package com.keiissland.leetcode.part0005;

public class Solution00048 {

    public void rotate(int[][] matrix) {

        int len = matrix.length;

        // i表示对角线元素索引
        int temp;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[(len - 1) - j][i];
                matrix[(len - 1) - j][i] = matrix[(len - 1) - i][(len - 1) - j];
                matrix[(len - 1) - i][(len - 1) - j] = matrix[j][(len - 1) - i];
                matrix[j][(len - 1) - i] = temp;
            }
        }
    }
}