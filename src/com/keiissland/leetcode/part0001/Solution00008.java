package com.keiissland.leetcode.part0001;

public class Solution00008 {

    public int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        String tempStr = str.trim();

        boolean isNeg = false;
        long result = 0;
        for (int i = 0; i < tempStr.length(); i++) {

            char curChar = tempStr.charAt(i);

            if (i == 0 && (tempStr.charAt(i) == '-' || curChar == '+')) {
                isNeg = curChar == '-';
            } else if (curChar < '0' || curChar > '9') {
                break;
            } else {
                result = result * 10 + curChar - '0';
            }

            if (result > Integer.MAX_VALUE) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return isNeg ? -(int)result : (int)result;
    }
}
