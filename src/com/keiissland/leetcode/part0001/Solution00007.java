package com.keiissland.leetcode.part0001;

public class Solution00007 {

    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        int sign = 1;

        if (x < 0) {
            sign = -1;
        }

        int tempX = Math.abs(x);
        long result = 0;
        while (tempX > 0) {
            int digits = tempX % 10;

            if (result * 10 + digits > Integer.MAX_VALUE) {
                return 0;
            }
            result = result * 10 + digits;
            tempX = tempX / 10;
        }

        return (int)(sign * result);
    }
}
