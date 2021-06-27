package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

        return new ArrayList<>();
    }


    public static void main(String[] args) {
        String words = "";
        List<String> wordDict = new ArrayList<String>();
        List<String> res = new WordBreakII().getResult(words,wordDict);
        System.out.println(JSONObject.toJSONString(res));
    }

}
