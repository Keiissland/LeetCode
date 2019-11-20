package com.keiissland.leetcode.part003;

public class Solution0029 {

    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int isNeg = -1;

        if ((dividend < 0 && divisor < 0) || (dividend >=0  && divisor >= 0)) {
            isNeg = 1;
        }

        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);

        int N = 1;
        int result = 0;
        long tempDivisor = divisorL;
        long tempDividend = dividendL;
        while (tempDividend >= divisorL) {

            if (tempDividend < tempDivisor) {
                tempDivisor = divisorL;
                N = 1;
            }

            tempDividend -= tempDivisor;
            result += N;

            tempDivisor *= 2;
            N *= 2;
        }

        return isNeg * result;
    }
}

