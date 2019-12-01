package com.keiissland.leetcode.part0003;

public class Solution00028 {

    public int strStr(String haystack, String needle) {

        if ("".equals(needle)) {
            return 0;
        }

        if ("".equals(haystack)) {
            return -1;
        }

        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int[] next = getNextArr(needles);

        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            while (j >= 0 && haystacks[i] != needles[j]) {
                j = next[j];
            }

            ++i;
            ++j;

            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] getNextArr(char[] needles) {

        int len = needles.length;

        int[] next = new int[len];
        next[0] = -1;

        int i = 0;
        int j = -1;
        while (i < len - 1) {
            while (j >= 0 && needles[i] != needles[j]) {
                j = next[j];
            }

            next[++i] = ++j;
        }

        return next;
    }
}

