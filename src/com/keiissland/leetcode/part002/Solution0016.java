package com.keiissland.leetcode.part002;

import java.util.Arrays;

public class Solution0016 {

    public int threeSumClosest(int[] nums, int target) {

        int result = 0;

        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;
            while (leftIdx < rightIdx) {
                
                int diff = target - nums[i] - nums[leftIdx] - nums[rightIdx];
                if (Math.abs(closest) > Math.abs(diff)) {
                    closest = diff;
                    result = nums[i] + nums[leftIdx] + nums[rightIdx];
                }

                if (diff > 0) {
                    ++leftIdx;
                } else if (diff < 0){
                    --rightIdx;
                } else {
                    return result;
                }
            }
        }

        return result;
    }
}