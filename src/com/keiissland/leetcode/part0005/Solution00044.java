package com.keiissland.leetcode.part0005;

public class Solution00044 {

    public boolean isMatch(String s, String p) {

        int sLen = s.length();
        int pLen = p.length();

        // dp[i][j]表示p0~pi与s0~sj是否匹配
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;

        // 初始化，字符串p的子串分别与空串进行匹配
        for (int i = 1; i <= pLen; i++) {
            dp[i][0] = dp[i - 1][0] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[pLen][sLen];
    }
}