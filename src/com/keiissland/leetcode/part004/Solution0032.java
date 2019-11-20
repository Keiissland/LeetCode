package com.keiissland.leetcode.part004;

import java.util.Arrays;

public class Solution0032 {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] parentheses = s.toCharArray();

        int[] dp = new int[parentheses.length];
        dp[0] = 0;
        for (int i = 1; i < parentheses.length; i++) {
            if (i - 1 - dp[i - 1] >= 0 && isMatch(parentheses, i - 1 - dp[i - 1], i)) {
                dp[i] = dp[i - 1] + 2;
                if (i - dp[i] > 0){
                    dp[i] += dp[i - dp[i]];
                }
            }
        }

        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    private boolean isMatch(char[] parentheses, int leftIdx, int rightIdx) {
        return parentheses[leftIdx] != parentheses[rightIdx] && parentheses[leftIdx] != ')';
    }
}