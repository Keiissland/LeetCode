package com.keiissland.leetcode.part0002;

import java.util.Collections;

public class Solution00012 {

    public String intToRoman(int num) {

        char[] romanSymbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        StringBuilder roman = new StringBuilder();

        int bitNum = 0;
        int tempNum = num;
        while (tempNum > 0) {

            int digits = tempNum % 10;

            StringBuilder tempStr = new StringBuilder();
            if (digits <= 3) {
                roman.insert(0, concatRepeat(romanSymbol[bitNum], digits));
            } else if (digits <= 5) {
                tempStr.append(concatRepeat(romanSymbol[bitNum], 5 - digits)).append(romanSymbol[bitNum + 1]);
                roman.insert(0, tempStr);
            } else if (digits <= 8){
                tempStr.append(romanSymbol[bitNum + 1]).append(concatRepeat(romanSymbol[bitNum], digits - 5));
                roman.insert(0, tempStr);
            } else {
                tempStr.append(romanSymbol[bitNum]).append(romanSymbol[bitNum + 2]);
                roman.insert(0, tempStr);
            }

            tempNum /= 10;
            bitNum += 2;
        }

        return roman.toString();
    }

    private String concatRepeat(char oriChar, int repeatNum) {
        return String.join("", Collections.nCopies(repeatNum, String.valueOf(oriChar)));
    }
}