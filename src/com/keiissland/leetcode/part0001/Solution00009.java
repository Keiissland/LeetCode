package com.keiissland.leetcode.part0001;

public class Solution00009 {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int result = 0;

        int tempX = x;
        while (tempX > 0) {
            int digits = tempX % 10;
            result = result * 10 + digits;
            tempX = tempX / 10;
        }

        return result == x;
    }
}
