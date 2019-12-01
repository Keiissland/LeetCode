package com.keiissland.leetcode.part0003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution00030 {

    public List<Integer> findSubstring(String s, String[] words) {

        ArrayList<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordsCount = words.length;

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordLen * wordsCount; i++) {
            HashMap<String, Integer> assistMap = new HashMap<>();
            for (int j = i; j < i + wordLen * wordsCount; j += wordLen) {
                String curWord = s.substring(j, j + wordLen);
                if (wordCount.containsKey(curWord)) {
                    if (assistMap.getOrDefault(curWord, 0) >= wordCount.get(curWord)) {
                        break;
                    }
                    assistMap.put(curWord, assistMap.getOrDefault(curWord, 0) + 1);
                } else {
                    break;
                }

                if (j + wordLen >= i + wordLen * wordsCount) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}
