package com.keiissland.leetcode.part004;

public class Solution0035 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private int searchInsert(int[] nums, int leftIdx, int rightIdx, int target) {

        int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
        int midNum = nums[midIdx];

        if (midNum == target) {
            return midIdx;
        }

        if (target < midNum) {
            if (midIdx == leftIdx || target > nums[midIdx - 1]) {
                return midIdx;
            }

            return searchInsert(nums, leftIdx, midIdx - 1, target);
        } else {
            if (midIdx == rightIdx) {
                return rightIdx + 1;
            }
            if (target < nums[midIdx + 1]) {
                return midIdx + 1;
            }

            return searchInsert(nums, midIdx + 1, rightIdx, target);
        }
    }
}