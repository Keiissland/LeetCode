package com.keiissland.leetcode.part0006;

public class Solution00052 {

    private int total = 0;

    public int totalNQueens(int n) {
        // 棋盘，初始元素全为0表示无皇后，1表示放置皇后
        int[][] checkerboard = new int[n][n];
        totalNQueens(n, checkerboard, 0);
        return total;
    }

    private void totalNQueens(int n, int[][] checkerboard, int curRow) {

        int len = checkerboard.length;

        // 皇后数为0表示皇后已全部摆放完毕
        if (n == 0) {
            total++;
        }

        for (int col = 0; col < len; col++) {
            if (validate(checkerboard, curRow, col)) {

                // 放置一名皇后
                checkerboard[curRow][col] = 1;

                // 继续在下一行找一个位置放皇后
                totalNQueens(n - 1, checkerboard, curRow + 1);

                // 该位置置为0是因为该位置上摆放皇后的所有可能性已遍历完，需要遍历该位置无皇后的情况
                checkerboard[curRow][col] = 0;
            }
        }
    }

    private boolean validate(int[][] checkerboard, int rowIdx, int colIdx) {

        int length = checkerboard[0].length;

        // 检查列
        for (int i = 0; i < length; i++) {
            if (checkerboard[i][colIdx] == 1) {
                return false;
            }
        }

        // 检查经过(rowIdx, colIdx)反斜线（\）
        for (int i = rowIdx, j = colIdx; i >= 0 && j >= 0; i--, j--) {
            if (checkerboard[i][j] == 1) {
                return false;
            }
        }

        // 检查经过(rowIdx, colIdx)正斜线（/）
        for (int i = rowIdx - 1, j = colIdx + 1; i >= 0 && j < length; i--, j++) {
            if (checkerboard[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}