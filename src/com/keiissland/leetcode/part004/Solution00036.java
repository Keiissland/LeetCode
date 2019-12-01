package com.keiissland.leetcode.part004;

public class Solution00036 {

    public boolean isValidSudoku(char[][] board) {

        // Check row
        for (int row = 0; row < 9; row++) {
            int[] flag = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (flag[board[row][col] - '0'] != 0) {
                    return false;
                }
                flag[board[row][col] - '0'] = 1;
            }
        }

        // Check col
        for (int col = 0; col < 9; col++) {
            int[] flag = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (flag[board[row][col] - '0'] != 0) {
                    return false;
                }
                flag[board[row][col] - '0'] = 1;
            }
        }

        // Check box
        for (int block = 0; block < 9; block++) {
            int[] flag = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int row = (block / 3) * 3; row < (block / 3 + 1) * 3; row++) {
                for (int col = (block % 3) * 3; col < (block % 3 + 1) * 3; col++) {
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (flag[board[row][col] - '0'] != 0) {
                        return false;
                    }
                    flag[board[row][col] - '0'] = 1;
                }
            }
        }

        return true;
    }
}