package com.keiissland.leetcode.part004;

public class Solution0037 {

    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = (char) ('0' + num);
                            if (!solve(board)) {
                                board[row][col] = '.';
                            } else {
                                return true;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int rowIdx, int colIdx, int num) {

        int startRowIdx = (rowIdx / 3) * 3;
        int startColIdx = (colIdx / 3) * 3;

        for (int i = 0; i < 9; i++) {
            if (board[rowIdx][i] == '0' + num) {
                return false;
            }
            if (board[i][colIdx] == '0' + num) {
                return false;
            }
            if (board[startRowIdx + i / 3][startColIdx + i % 3] == '0' + num) {
                return false;
            }
        }

        return true;
    }
}