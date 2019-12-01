package com.keiissland.leetcode.part0004;

import java.util.Arrays;

public class Solution00031 {

    public void nextPermutation(int[] nums) {

        int mostRightIdx = nums.length - 1;
        int mostLeftIdx = Integer.MIN_VALUE;
        for (int i = mostRightIdx; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (mostLeftIdx < j) {
                        mostLeftIdx = j;
                        mostRightIdx = i;
                    }
                }
            }
        }

        if (mostLeftIdx == Integer.MIN_VALUE) {
            mostLeftIdx = 0;
        }

        swap(nums, mostLeftIdx, mostRightIdx);
        Arrays.sort(nums, mostLeftIdx + 1, nums.length);
    }

    private void swap(int[] nums, int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}