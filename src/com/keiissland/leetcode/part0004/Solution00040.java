package com.keiissland.leetcode.part0004;

import java.util.*;

public class Solution00040 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        combinationSum2(candidates, 0, new LinkedList<>(), target);

        return result;
    }

    private void combinationSum2(int[] candidates, int startIdx, Deque<Integer> subList, int target) {

        if (startIdx > candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(subList));
        }

        for (int i = startIdx; i < candidates.length; i++) {
            // 跳过相同元素
            if (i != startIdx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 先加入元素，后检测是否满足条件
            subList.addLast(candidates[i]);
            combinationSum2(candidates, i + 1, subList, target - candidates[i]);
            subList.removeLast();
        }
    }
}