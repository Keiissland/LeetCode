package com.keiissland.leetcode.part001;

public class Solution0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sumLen = nums1.length + nums2.length;

        if (sumLen % 2 == 0) {
            return (findKthSortedArrays(nums1, 0, nums2, 0, sumLen / 2 + 1) +
                    findKthSortedArrays(nums1, 0, nums2, 0, sumLen / 2)) / 2.0;
        }

        return findKthSortedArrays(nums1, 0, nums2, 0, sumLen / 2 + 1);
    }

    private int findKthSortedArrays(int[] nums1, int startIdx1, int[] nums2, int startIdx2, int k) {

        if (startIdx1 >= nums1.length) {
            return nums2[startIdx2 + k - 1];
        }

        if (startIdx2 >= nums2.length) {
            return nums1[startIdx1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[startIdx1], nums2[startIdx2]);
        }

        int halfNums1 = startIdx1 + k / 2 - 1 < nums1.length ? nums1[startIdx1 + k / 2 - 1] : Integer.MAX_VALUE;
        int halfNums2 = startIdx2 + k / 2 - 1 < nums2.length ? nums2[startIdx2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfNums1 > halfNums2) {
            return findKthSortedArrays(nums1, startIdx1, nums2, startIdx2 + k / 2, k - k / 2);
        } else {
            return findKthSortedArrays(nums1, startIdx1 + k / 2, nums2, startIdx2, k - k / 2);
        }
    }
}