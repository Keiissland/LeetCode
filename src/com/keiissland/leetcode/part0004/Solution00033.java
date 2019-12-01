package com.keiissland.leetcode.part0004;

public class Solution00033 {

    public int search(int[] nums, int target) {
        int[] result = {-1};
        search(nums, target, 0, nums.length - 1, result);
        return result[0];
    }

    private void search(int[] nums, int target, int leftIdx, int rightIdx, int[] result) {

        if (leftIdx > rightIdx) {
            return;
        }

        int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

        int midNum = nums[midIdx];
        if (target == midNum) {
            result[0] = midIdx;
            return;
        }

        if (target > midNum) {
            if (nums[leftIdx] > midNum && nums[rightIdx] > midNum) {
                search(nums, target, leftIdx, midIdx - 1, result);
                search(nums, target, midIdx + 1, rightIdx, result);
            } else {
                search(nums, target, midIdx + 1, rightIdx, result);
            }
        } else {
            if (nums[leftIdx] > midNum && nums[rightIdx] > midNum) {
                search(nums, target, leftIdx, midIdx - 1, result);
            } else {
                search(nums, target, leftIdx, midIdx - 1, result);
                search(nums, target, midIdx + 1, rightIdx, result);
            }
        }
    }
}