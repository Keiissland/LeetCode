package com.keiissland.leetcode.part002;

import java.util.Arrays;

public class Solution0014 {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder prefix = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return prefix.toString();
        }

        Arrays.sort(strs);

        char[] minChars = strs[0].toCharArray();
        char[] maxChars = strs[strs.length - 1].toCharArray();

        int minLen = Math.min(minChars.length, maxChars.length);

        for (int i = 0; i < minLen; i++) {
            if (minChars[i] == maxChars[i]) {
                prefix.append(minChars[i]);
            } else {
                return prefix.toString();
            }
        }

        return prefix.toString();
    }
}