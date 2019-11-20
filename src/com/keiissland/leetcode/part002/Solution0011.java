package com.keiissland.leetcode.part002;

public class Solution0011 {

    public int maxArea(int[] height) {

        int leftCursor = 0;
        int rightCursor = height.length - 1;

        int maxAreaRes = Integer.MIN_VALUE;
        while (leftCursor < rightCursor) {

            int leftHeight = height[leftCursor];
            int rightHeight = height[rightCursor];

            int currentArea = (rightCursor - leftCursor) * Math.min(leftHeight, rightHeight);

            maxAreaRes = Math.max(maxAreaRes, currentArea);

            if (leftHeight < rightHeight) {
                ++leftCursor;
            } else {
                --rightCursor;
            }
        }

        return maxAreaRes;
    }
}
