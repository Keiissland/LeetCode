package com.keiissland.leetcode.part002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0015 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {

                int sum = nums[leftIdx] + nums[rightIdx] + nums[i];
                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[leftIdx++], nums[rightIdx--]));

                    while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
                        ++leftIdx;
                    }
                    while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]) {
                        --rightIdx;
                    }
                } else if (sum < 0) {
                    ++leftIdx;
                } else {
                    --rightIdx;
                }
            }
        }

        return result;
    }
}