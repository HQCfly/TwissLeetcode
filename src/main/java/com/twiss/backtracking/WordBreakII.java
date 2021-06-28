package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/6/23 9:57 下午
 */
public class WordBreakII {

    /**
     * 先使用动态规划将每个可截取单词的right下标找出来dp[right] = true
     * 其次对整个字符串进行dfs回溯算法查找所有有效的分词。根据是否存在词典中和dp[i]是否是true，如果true则往下搜索
     * -- 符合条件的分词使用Deque双端队列
     */
    private List<String> getResult(String words,List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int len = words.length();
        boolean[] dp = new boolean[len+1];
        // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        // 1. 动态规划是否有解
        // dp[i] 表示的是长度为i的前子串是否可以拆成wordDict中的单词
        // 长度包括0，因此状态数组的长度为len+1
        for (int right = 1;right<=len;right++){
            // 如果单词集合中的单词不长，从后向前遍历是更快
            for (int left = right-1;left>=0;left--){
                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                if (wordSet.contains(words.substring(left,right))&&dp[left]){
                    // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去，因为dp表示的是长度为i的前子串的状态
                    // dp[left]表示前left子字符串已经是true，并且后续的word(left,right)也包含在wordDict中，
                    // 因此dp[right]为true后，直接跳出当前循环进行下一轮
                    dp[right] = true;
                    break;
                }
            }
        }
        // 2. 回溯算法搜索所有符合条件的解
        if (dp[len]){
            Deque<String> path = new ArrayDeque<>();
            dfs(words,wordSet,len,dp,path,res);
            return res;
        }
        return res;
    }

    /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     * @param words 字符串
     * @param wordSet 单词集合
     * @param len 字符串长度
     * @param dp 预处理得到的dp
     * @param path 从叶子节点到根节点路径
     * @param res 保存所有结果变量
     */
    private void dfs(String words,Set<String> wordSet,int len,boolean[] dp,Deque<String> path,List<String> res){
        if (len==0){
            res.add(String.join(" ",path));
            return;
        }

        for (int i=len-1;i>=0;i--){
            String suffix = words.substring(i,len);
            if (wordSet.contains(suffix)&&dp[i]){
                path.addFirst(suffix);
                dfs(words,wordSet,i,dp,path,res);
                path.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        String words = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> res = new WordBreakII().getResult(words,wordDict);
        System.out.println(JSONObject.toJSONString(res));
    }

}
