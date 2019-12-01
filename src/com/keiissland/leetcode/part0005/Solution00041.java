package com.keiissland.leetcode.part0005;

public class Solution00041 {

    public int firstMissingPositive(int[] nums) {

        if (nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < nums.length) {
                // 让num和存入下标为[num-1]的数据单元中，后续根据对应关系，来判断缺失的第一个正整数
                if (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}