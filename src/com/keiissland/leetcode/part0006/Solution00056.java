package com.keiissland.leetcode.part0006;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution00056 {

    public int[][] merge(int[][] intervals) {

        // 对区间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Stack<Integer> stack = new Stack<>();
        for (int[] interval : intervals) {
            if (stack.isEmpty() || stack.peek() < interval[0]) {
                stack.push(interval[0]);
                stack.push(interval[1]);
            } else {
                stack.push(Math.max(stack.pop(), interval[1]));
            }
        }

        int[][] result = new int[stack.size() / 2][2];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i][1] = stack.pop();
            result[i][0] = stack.pop();
        }

        return result;
    }
}