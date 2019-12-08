package com.keiissland.leetcode.part0005;

import java.util.ArrayList;
import java.util.List;

public class Solution00046 {

    private List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, new ArrayList<>(), 0);
        return results;
    }

    /**
     * index 表示nums[index]到nums[nums.length - 1]中的元素进行全排列
     */
    private void permute(int[] nums, List<Integer> subList, int index) {

        int numsLen = nums.length;

        // 表示当nums中只有一个元素需要全排列时的情况（即就是该元素本身）
        if (index == numsLen - 1) {
            subList.add(nums[index]);
            results.add(subList);
            return;
        }

        for (int i = index; i < numsLen; i++) {

            // 将index位置上的元素不断替换成index之后的元素
            // 这里需要对nums进行拷贝，确保对调index和i上的元素
            int[] tempNums = nums.clone();
            swap(tempNums, index, i);

            // 将输入参数分为两段，首数字和剩下数字两段
            // 首数字为index上的元素，即tempNums[index]
            List<Integer> list = new  ArrayList<>(subList);
            list.add(tempNums[index]);
            permute(tempNums, list, index + 1);
        }
    }

    private void swap(int[] nums, int leftIdx, int rightIdx) {
        int temp = nums[leftIdx];
        nums[leftIdx] = nums[rightIdx];
        nums[rightIdx] = temp;
    }
}