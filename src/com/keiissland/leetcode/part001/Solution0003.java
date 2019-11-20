package com.keiissland.leetcode.part001;

public class Solution0003 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();

        int[] dp = new int[length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i - dp[i - 1]; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i] = i - j;
                    break;
                } else if (j == i - 1) {
                    dp[i] = dp[i - 1] + 1;
                }
                maxLength = Math.max(dp[i], maxLength);
            }
        }

        return maxLength;
    }
}
