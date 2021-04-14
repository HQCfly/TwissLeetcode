package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/14 9:16 下午
 */
public class ShortestWordDistanceIII {
    public static int getShortestWordsDistance(String[] words,
                                               String word1,
                                               String word2) {
        int index1 = -1, index2 = -1, distance = Integer.MAX_VALUE;
        int turn = 0, ans = (word1.equals(word2) ? 1 : 0);
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i]) && turn % 2 == 0) {
                index1 = i;
                if (index2 != -1) {
                    distance = Math.min(distance, Math.abs(index2 - index1));
                }
                turn += ans;
            }else if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != -1) {
                    distance = Math.min(distance, Math.abs(index2 - index1));
                }
                turn += ans;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        int res = getShortestWordsDistance(words, word1, word2);
        System.out.println(res);
    }
}
