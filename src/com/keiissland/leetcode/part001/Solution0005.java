package com.keiissland.leetcode.part001;

public class Solution0005 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = s.length();

        int[] dp = new int[length];
        dp[0] = 1;

        char[] chars = s.toCharArray();

        String result = "";
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {

            if (i - dp[i - 1] > 0) {
                if (chars[i - dp[i - 1] - 1] == chars[i]) {
                    dp[i] = dp[i - 1] + 2;
                } else {
                    for (int j = i - dp[i - 1]; j < i; j++) {
                        if (isPalindrome(chars, j, i)) {
                            dp[i] = i - j + 1;
                            break;
                        }
                        if (j == i - 1) {
                            dp[i] = 1;
                            break;
                        }
                    }
                }
            } else {
                if (isPalindrome(chars, 0, i)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (isPalindrome(chars, j, i)) {
                            dp[i] = i - j + 1;
                            break;
                        }
                        if (j == i - 1) {
                            dp[i] = 1;
                            break;
                        }
                    }
                }
            }

            if (maxLength < dp[i]) {
                result = s.substring(i - dp[i] + 1, i + 1);
                maxLength = dp[i];
            }
        }

        return result;
    }

    private boolean isPalindrome(char[] chars, int startIdx, int endIdx) {

        if (startIdx > endIdx) {
            return false;
        }

        while (startIdx < endIdx) {
            if (chars[startIdx++] != chars[endIdx--]) {
                return false;
            }
        }

        return true;
    }
}