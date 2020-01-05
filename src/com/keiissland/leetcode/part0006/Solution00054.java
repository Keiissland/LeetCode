package com.keiissland.leetcode.part0006;

import java.util.ArrayList;
import java.util.List;

public class Solution00054 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int rowLen;
        if (matrix == null || (rowLen = matrix.length) <= 0) {
            return result;
        }
        int colLen = matrix[0].length;

        // matrix[m][n]较短的边长
        int minSideLen = Math.min(rowLen, colLen);

        double halfOfDiagonal = minSideLen / 2D;
        for (int i = 0; i < Math.ceil(halfOfDiagonal); i++) {

            // 终止行索引值
            int endRowIdx = rowLen - 1 - i;
            // 终止列索引值
            int endColIdx = colLen - 1 - i;

            // 1. 打印第i行
            for (int j = i; j <= endColIdx; j++) {
                result.add(matrix[i][j]);
            }

            // 2. 打印倒数第i列
            for (int j = i + 1; j <= endRowIdx; j++) {
                result.add(matrix[j][endColIdx]);
            }

            // 3. 打印倒数第i行
            // 如果倒数第i行与地i行为同一行则不打印
            if (endRowIdx != i){
                for (int j = endColIdx - 1; j >= i; j--) {
                    result.add(matrix[endRowIdx][j]);
                }
            }

            // 4. 打印第i列
            // 如果倒数第i列与第i列为同一行则不打印
            if ((colLen - 1) - i != i) {
                for (int j = endRowIdx - 1; j > i; j--) {
                    result.add(matrix[j][i]);
                }
            }
        }

        return result;
    }
}