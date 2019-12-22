package com.keiissland.leetcode.part0005;

public class Solution00050 {

    public double myPow(double x, int n) {

        double result = 1.0D;

        boolean isNeg = n < 0;
        // i表指数，每次折半，对应公式为：x^n == (x^2)^(n/2) == ((x^2)*(x^2))^(n/4)
        for (int i = n; i != 0; i /= 2) {
            // 兼容负指数次幂
            if (Math.abs(i % 2) == 1) {
                result *= x;
            }
            x *= x;
        }

        return !isNeg ? result : 1 / result;
    }
}