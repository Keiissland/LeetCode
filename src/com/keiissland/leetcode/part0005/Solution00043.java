package com.keiissland.leetcode.part0005;

import java.util.Arrays;

public class Solution00043 {

    public String multiply(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int[] resultArr = new int[num1.length() + num2.length()];

        Arrays.fill(resultArr, 0);

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int curDigital1 = num1.charAt(i) - '0';
                int curDigital2 = num2.charAt(j) - '0';
                int product = curDigital1 * curDigital2;

                // 乘积 + 当前位值的和
                int sum = resultArr[i + j + 1] + product;
                resultArr[i + j + 1] = (sum) % 10;

                if (sum > 9) {
                    resultArr[i + j] += sum / 10;
                }
            }
        }

        boolean flag = true;
        for (int digital : resultArr) {
            // 找出首位不为0的数
            if (flag && digital != 0) {
                flag = false;
            }

            // 首位不为0，及之后的数作为结果
            if (!flag) {
                result.append(digital);
            }
        }

        // 结果为0的情况
        if (flag) {
            result.append(0);
        }

        return result.toString();
    }
}