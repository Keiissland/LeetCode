package com.keiissland.leetcode.part0005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution00049 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        Map<Integer, List<String>> assist = new HashMap<>();

        // 存放前26个质数，每一质数与小写字母一一对应
        int[] primeNums = {2, 3, 5, 7, 11, 13,
                17, 19, 23, 29, 31,
                37, 41, 43, 47, 53,
                59, 61, 67, 71, 73,
                79, 83, 89, 97, 101};

        for (String str : strs) {
            // 字符映射对应的质数乘积
            int productMap = 1;
            for (int i = 0; i < str.length(); i++) {
                productMap *= primeNums[str.charAt(i) - 'a'];
            }
            if (assist.containsKey(productMap)) {
                assist.get(productMap).add(str);
            } else {
                ArrayList<String> subStrList = new ArrayList<>();
                subStrList.add(str);
                assist.put(productMap, subStrList);
                result.add(subStrList);
            }
        }

        return result;
    }
}