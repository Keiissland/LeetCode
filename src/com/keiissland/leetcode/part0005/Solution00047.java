package com.keiissland.leetcode.part0005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution00047 {

    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        permuteUnique(nums, new ArrayList<>(), 0);
        return results;
    }

    /**
     * index 表示nums[index]到nums[nums.length - 1]中的元素进行全排列
     */
    private void permuteUnique(int[] nums, List<Integer> subList, int index) {

        int numsLen = nums.length;

        // 表示当nums中只有一个元素需要全排列时的情况（即就是该元素本身）
        if (index == numsLen - 1) {
            subList.add(nums[index]);
            results.add(subList);
            return;
        }

        // 将连续相同的数字，存入一份到assist中，便于后续跳过相同元素的排列组合
        List<Integer> assist = new ArrayList<>();
        for (int i = index; i < numsLen; i++) {

            // 跳过相同的元素
            if (assist.contains(nums[i])) {
                continue;
            }

            assist.add(nums[i]);
            // 将index位置上的元素不断替换成index之后的元素
            swap(nums, index, i);

            // 将输入参数分为两段，首数字和剩下数字两段
            // 首数字为index上的元素，nums[index]
            List<Integer> list = new  ArrayList<>(subList);
            list.add(nums[index]);
            permuteUnique(nums, list, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}