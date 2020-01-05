package com.keiissland.leetcode.part0006;

public class Solution00053 {

    public int maxSubArray(int[] nums) {

        int result = Integer.MIN_VALUE;

        // 存放最大子序列和
        int maxSum = 0;
        for (int num : nums) {
            maxSum += num;
            if (maxSum > result) {
                result = maxSum;
            }
            // 子序列和小于0，则重置为0，确保不影响下一个子序列的和
            if (maxSum < 0) {
                maxSum = 0;
            }
        }

        return result;
    }
}