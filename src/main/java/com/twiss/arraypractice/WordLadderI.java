package com.twiss.arraypractice;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/5/1 10:08 下午
 */
public class WordLadderI {

    public static int getLadderLength(String beginWord,
                                      String endBegin,
                                      List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        // 判断是否wordList是空，或者不包括endBegin
        if (wordList.size() == 0 || !wordSet.contains(endBegin)) {
            return 0;
        }
        wordSet.remove(beginWord);
        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        // - 将beginWord作为队首
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        // - 将beginWord添加为访问过
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; ++i) {
                // 依次遍历队列中的单词
                String currentWord = queue.poll();
                // 如果currentWord能够修改一个字符就能与endWord相等则返回step+1
                if (changeWordEveryOneLetter(currentWord,
                        endBegin,queue,visited,wordSet)) {
                    return step + 1;
                }
            }
            step ++;
        }
        return 0;
    }

    public static boolean changeWordEveryOneLetter(String currentWord,
                                                   String endWord,
                                                   Queue<String> queue,
                                                   Set<String> visited,
                                                   Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); ++i) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            // 从a遍历z
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                // 判断集合中是否存在组合后的新单词
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)){
                        return true;
                    }
                    // 如果nextWord没有被访问过
                    if (!visited.contains(nextWord)){
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        queue.add(nextWord);
                        // 添加到访问集合
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复初始
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        String beginWord = "hit";
        String endWord = "cog";
        int res = getLadderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
