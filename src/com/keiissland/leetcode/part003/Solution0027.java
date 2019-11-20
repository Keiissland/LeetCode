package com.keiissland.leetcode.part003;

import java.util.Arrays;

public class Solution0027 {

    public int removeElement(int[] nums, int val) {

        Arrays.sort(nums);

        int valCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                ++valCount;
                continue;
            }
            nums[i - valCount] = nums[i];
        }

        return nums.length - valCount;
    }
}