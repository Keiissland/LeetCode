package com.keiissland.leetcode.part001;

public class Solution0010 {

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int idxS, String p, int idxP) {

        if (idxS == s.length() && idxP == p.length()) {
            return true;
        }

        if (s.length() > 0 && p.length() == 0) {
            return false;
        }

        if (idxS < s.length() && idxP == p.length()) {
            return false;
        }

        boolean logicalExpression = idxP < p.length() - 1 && p.charAt(idxP + 1) == '*';
        if (idxS == s.length() && idxP < p.length()) {

            if (logicalExpression) {
                return isMatch(s, idxS, p, idxP + 2);
            }

            return false;
        }

        char currentS = s.charAt(idxS);
        char currentP = p.charAt(idxP);

        if (currentS == currentP || currentP == '.') {

            if (logicalExpression) {
                return isMatch(s, idxS + 1, p, idxP) ||
                        isMatch(s, idxS + 1, p, idxP + 2) ||
                        isMatch(s, idxS, p, idxP + 2);
            }

            return isMatch(s, idxS + 1, p, idxP + 1);
        } else {

            if (logicalExpression) {
                return isMatch(s, idxS, p, idxP + 2);
            }

            return false;
        }
    }
}
