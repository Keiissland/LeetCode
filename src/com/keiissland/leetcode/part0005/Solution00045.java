package com.keiissland.leetcode.part0005;

public class Solution00045 {

    public int jump(int[] nums) {

        int len = nums.length;

        // dp[i]表示从第i+1到最后一个单元格的距离
        int[] dp = new int[len];
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            // 不可到达终点
            if (nums[i] == 0) {
                dp[i] = -1;
                continue;
            }
            // 步长大于到终点距离，可以一步到达
            if (nums[i] >= (len - i - 1)) {
                dp[i] = 1;
                continue;
            }
            int minLen = Integer.MAX_VALUE;
            for (int j = i + 1; j <= nums[i] + i; j++) {
                if (dp[j] == -1) {
                    continue;
                }
                minLen = Math.min(dp[j], minLen);
            }
            if (minLen == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = minLen + 1;
            }
        }

        return dp[0];
    }
}