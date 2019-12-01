package com.keiissland.leetcode.part0004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution00039 {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>());
        return resultList;
    }

    private void combinationSum(int[] candidates, int target, int startIdx, List<Integer> subList) {

        if (startIdx >= candidates.length || candidates[startIdx] > target) {
            return;
        }

        int currentNum = candidates[startIdx];

        if (currentNum == target) {
            subList.add(candidates[startIdx]);
            resultList.add(subList);
            return;
        }

        combinationSum(candidates, target, startIdx + 1, new ArrayList<>(subList));

        target -= currentNum;
        subList.add(currentNum);
        combinationSum(candidates, target, startIdx, new ArrayList<>(subList));
    }
}