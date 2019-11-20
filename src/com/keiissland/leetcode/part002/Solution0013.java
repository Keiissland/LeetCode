package com.keiissland.leetcode.part002;

public class Solution0013 {

    public int romanToInt(String s) {

        int[] romanSymbol = new int['X' + 1];
        romanSymbol['I'] = 1;
        romanSymbol['V'] = 5;
        romanSymbol['X'] = 10;
        romanSymbol['L'] = 50;
        romanSymbol['C'] = 100;
        romanSymbol['D'] = 500;
        romanSymbol['M'] = 1000;

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += romanSymbol[s.charAt(i)];
            for (int j = i - 1; j >= 0 && compare(romanSymbol, s.charAt(j), s.charAt(i)) < 0 ; j--) {
                result -= romanSymbol[s.charAt(j)];
                i--;
            }
        }

        return result;
    }

    private int compare(int[] romanSymbol, char roman1, char roman2) {
        return romanSymbol[roman1] - romanSymbol[roman2];
    }
}