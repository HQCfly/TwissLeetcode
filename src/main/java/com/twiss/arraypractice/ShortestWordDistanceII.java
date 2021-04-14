package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/4/13 8:33 下午
 */
public class ShortestWordDistanceII {

    public static int getShortestWordsDistance(String[] words,
                                               String word1,
                                               String word2) {
        int distance = Integer.MAX_VALUE;
        Map<String, List<Integer>> wordsMap = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> indexList = wordsMap.get(words[i]);
            if (indexList == null) {
                indexList = new ArrayList<Integer>();
            }
            indexList.add(i);
            wordsMap.put(words[i], indexList);
        }

        List<Integer> index1 = wordsMap.get(word1);
        List<Integer> index2 = wordsMap.get(word2);
        int i = 0, j = 0;
        while (i < index1.size() && j < index2.size()) {
            distance = Math.min(Math.abs(index1.get(i) - index2.get(j)), distance);
            if (index1.get(i) < index2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "practice";
        String word2 = "coding";
        int res = getShortestWordsDistance(words, word1, word2);
        System.out.println(res);
    }
}
