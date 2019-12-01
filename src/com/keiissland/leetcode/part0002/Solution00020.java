package com.keiissland.leetcode.part0002;

import java.util.Stack;


public class Solution00020 {

    public boolean isValid(String s) {

        char[] bracketsArr = s.toCharArray();

        Stack<Character> assist = new Stack<>();

        for (char brackets : bracketsArr) {
            if (brackets == '(' || brackets == '[' || brackets == '{') {
                assist.push(brackets);
            } else {
                if (assist.isEmpty()) {
                    return false;
                }

                boolean isParenthesisMatch = assist.peek() == '(' && brackets == ')';
                boolean isSquareBracketsMatch = assist.peek() == '[' && brackets == ']';
                boolean isBracesMatch = assist.peek() == '{' && brackets == '}';
                if (isParenthesisMatch || isSquareBracketsMatch || isBracesMatch) {
                    assist.pop();
                } else {
                    return false;
                }
            }
        }

        return assist.isEmpty();
    }
}