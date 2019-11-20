package com.keiissland.leetcode.part001;

import java.util.HashMap;

public class Solution0001 {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length <= 0) {
            return null;
        }

        HashMap<Integer, Integer> assistMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (assistMap.containsKey(target - nums[i])) {
                return new int[]{assistMap.get(target - nums[i]), i};
            } else {
                assistMap.put(nums[i], i);
            }
        }

        return null;
    }
}
