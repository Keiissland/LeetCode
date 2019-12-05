package com.keiissland.leetcode.part0005;

public class Solution00042 {

    public int trap(int[] height) {

        int result = 0;

        int maxHeightIdx = -1;
        int maxHeight = Integer.MIN_VALUE;

        // 找出最高的柱子，然后从左右两边分别寻找计算两边储水量
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeightIdx = i;
                maxHeight = height[i];
            }
        }

        for (int i = 0; i < maxHeightIdx; i++) {
            int temp = 0;
            for (int j = i + 1; j <= maxHeightIdx; j++) {
                if (height[i] > height[j]) {
                    temp += (height[i] - height[j]);
                } else {
                    result += temp;
                    i = j - 1;
                    break;
                }
            }
        }

        for (int i = height.length - 1; i > maxHeightIdx; i--) {
            int temp = 0;
            for (int j = i - 1; j >= maxHeightIdx; j--) {
                if (height[i] > height[j]) {
                    temp += (height[i] - height[j]);
                } else {
                    result += temp;
                    i = j + 1;
                    break;
                }
            }
        }

        return result;
    }
}