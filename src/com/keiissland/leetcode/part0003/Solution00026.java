package com.keiissland.leetcode.part0003;

public class Solution00026 {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = 0; i + 1 < nums.length; i++) {
            if (dp[i] != dp[i + 1]) {
                nums[dp[i]] = nums[i];
            }
            if (i + 1 == nums.length - 1) {
                nums[dp[i + 1]] = nums[i + 1];
            }
        }

        return dp[nums.length - 1] + 1;
    }
}