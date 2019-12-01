package com.keiissland.leetcode.part0002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution00017 {

    private String[][] keyboard = {{},                   {"a", "b", "c"}, {"d", "e", "f"},
            {"g", "h", "i"},      {"j", "k", "l"}, {"m", "n", "o"},
            {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {

        List<List<String>> inputList = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            inputList.add(Arrays.asList(keyboard[digits.charAt(i) - '0' - 1]));
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            List<String> curStr = inputList.get(i);
            if (i == 0) {
                result = new ArrayList<>(curStr);
                continue;
            }

            List<String> tempList = new ArrayList<>();
            for (String oldStr : result) {
                for (String newStr : curStr) {
                    tempList.add(oldStr + newStr);
                }
            }

            result.clear();
            result.addAll(tempList);
        }

        return result;
    }
}