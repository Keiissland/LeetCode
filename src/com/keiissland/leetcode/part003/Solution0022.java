package com.keiissland.leetcode.part003;

import java.util.ArrayList;
import java.util.List;


public class Solution0022 {

    private List<String> resList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        generateParenthesis(n, n, "");

        return resList;
    }

    private void generateParenthesis(int remainLeft, int remainRight, String bracketsStr) {

        if (remainLeft == remainRight) {
            if (remainLeft == 0) {
                resList.add(bracketsStr);
                return;
            } else {
                generateParenthesis(remainLeft - 1, remainRight, bracketsStr + "(");
            }
        }

        if (remainLeft == 0) {
            generateParenthesis(remainLeft, remainRight - 1, bracketsStr + ")");
        } else if (remainLeft < remainRight){
            generateParenthesis(remainLeft - 1, remainRight, bracketsStr + "(");
            generateParenthesis(remainLeft, remainRight - 1, bracketsStr + ')');
        }
    }
}