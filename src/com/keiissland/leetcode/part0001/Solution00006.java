package com.keiissland.leetcode.part0001;

public class Solution00006 {

    public String convert(String s, int numRows) {

        if (s == null || s.length() <= 0 || numRows <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            boolean flag = true;
            for (int j = i; j < s.length();) {
                if (i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(j));
                    j += (numRows - 1) * 2;
                } else {
                    sb.append(s.charAt(j));
                    j = flag ? j + (numRows - i - 1) * 2 : j + (2 * i);
                    flag = !flag;
                }
            }
        }

        return sb.toString();
    }
}