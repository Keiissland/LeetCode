package com.keiissland.leetcode.part002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution0018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int leftIdx = j + 1;
                int rightIdx = nums.length - 1;
                while (leftIdx < rightIdx) {

                    int fourSum = nums[i] + nums[j] + nums[leftIdx] + nums[rightIdx];
                    if (target == fourSum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[leftIdx], nums[rightIdx]));

                        ++leftIdx;
                        --rightIdx;

                        while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
                            ++leftIdx;
                        }
                        while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]) {
                            --rightIdx;
                        }
                    }  else if (target > fourSum) {
                        ++leftIdx;
                    } else {
                        --rightIdx;
                    }
                }
            }
        }

        return result;
    }
}