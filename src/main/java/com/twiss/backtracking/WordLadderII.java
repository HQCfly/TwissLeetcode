package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/6/28 8:58 下午
 */
public class WordLadderII {

    private List<List<String>> findLadder(String begin, String end, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        // 将wordList设置为Set集合
        Set<String> wordDict = new HashSet<String>(wordList);
        if (!wordDict.contains(end)) {
            return res;
        }

        wordDict.remove(begin);
        // 1. 广度优先遍历简历图
        // 设置一个Map表示nextWord和第几层搜索到的。key：单词，value：层数
        Map<String, Integer> steps = new HashMap<>();
        steps.put(begin, 0);
        // 设置一个Map表示当前nextWord是由那些单词转化而来，一对多关系
        Map<String, List<String>> from = new HashMap<>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(begin);
        int step = 1;
        boolean found = false;
        int wordLen = begin.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c < 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(currentWord);
                        }
                        if (!wordDict.contains(nextWord)) {
                            continue;
                        }

                        // 如果一个单词扩展出来的单词，以前遍历过则后续的距离更远，因此在wordDict删除
                        wordDict.remove(nextWord);

                        // 这一层扩展出来的单词进入队列
                        queue.offer(nextWord);

                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currentWord);

                        // 记录nextWord的step
                        steps.put(nextWord, step);

                        if (nextWord.equals(end)) {
                            found = true;
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
        }
        // 深度优先遍历, 从end去查到begin
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(end);
            dfs(begin, end, from, path, res);
        }
        return res;
    }

    private void dfs(String begin, String cur, Map<String, List<String>> from, Deque<String> path, List<List<String>> res) {
        if (cur.equals(begin)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String precursor : from.get(cur)) {
            path.addFirst(precursor);
            dfs(begin, precursor, from, path, res);
            path.removeFirst();
        }

    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> res = new WordLadderII().findLadder(beginWord, endWord, wordList);
        System.out.println(JSONObject.toJSONString(res));
    }
}
