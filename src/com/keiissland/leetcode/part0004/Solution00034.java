package com.keiissland.leetcode.part0004;

public class Solution00034 {

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{findFirstPosition(nums, 0, nums.length - 1, target), findLastPosition(nums, 0, nums.length - 1, target)};
    }

    private int findFirstPosition(int[] nums, int leftIdx, int rightIdx, int target) {

        if (leftIdx > rightIdx) {
            return -1;
        }

        int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
        int midNum = nums[midIdx];

        if (midNum > target) {
            return findFirstPosition(nums, leftIdx, midIdx - 1, target);
        } else if (midNum < target) {
            return findFirstPosition(nums, midIdx + 1, rightIdx, target);
        } else {
            if (midIdx == leftIdx || nums[midIdx - 1] < target) {
                return midIdx;
            }

            return findFirstPosition(nums, leftIdx, rightIdx - 1, target);
        }
    }

    private int findLastPosition(int[] nums, int leftIdx, int rightIdx, int target) {

        if (leftIdx > rightIdx) {
            return -1;
        }

        int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
        int midNum = nums[midIdx];

        if (midNum > target) {
            return findLastPosition(nums, leftIdx, midIdx - 1, target);
        } else if (midNum < target) {
            return findLastPosition(nums, midIdx + 1, rightIdx, target);
        } else {
            if (midIdx == rightIdx || nums[midIdx + 1] > target) {
                return midIdx;
            }
            return findLastPosition(nums, midIdx + 1, rightIdx, target);
        }
    }
}