package com.keiissland.leetcode.part0006;

public class Solution00055 {

    public boolean canJump(int[] nums) {

        if (nums[0] == 0) {
            return false;
        }

        int canJumpDistance = nums[0];
        for (int i = 0; i <= canJumpDistance; i++) {
            if (canJumpDistance >= nums.length - 1) {
                return true;
            }
            // 每次更新能够跳跃的最长距离
            if (i + nums[i] > canJumpDistance) {
                canJumpDistance = i + nums[i];
            }
        }

        return false;
    }
}