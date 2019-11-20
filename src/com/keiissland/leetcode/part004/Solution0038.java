package com.keiissland.leetcode.part004;

import java.util.Stack;

public class Solution0038 {

    public String countAndSay(int n) {

        String result = "1";

        if (n == 1) {
            return result;
        }

        for (int i = 1; i < n; i++) {
            result = getNextString(result);
        }

        return result;
    }

    private String getNextString(String inputStr) {

        StringBuilder outputStr = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        char[] inputChars = inputStr.toCharArray();

        for (char inputChar : inputChars) {
            if (!stack.isEmpty() && stack.peek() != inputChar) {
                outputStr.append(stack.size()).append(stack.peek());
                stack.clear();
            }
            stack.push(inputChar);
        }

        if (!stack.isEmpty()) {
            outputStr.append(stack.size()).append(stack.peek());
            stack.clear();
        }

        return outputStr.toString();
    }
}