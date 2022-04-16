package com.twiss.zijie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * 动态规划
 * 时间复杂度O(n^2)
 * 空间复杂度O(n)
 *
 * @Author: Twiss
 * @Date: 2022/4/16 6:37 下午
 */
public class WordBreak {

    public boolean canBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean ans = new WordBreak().canBreak(s,wordDict);
        System.out.println(ans);
    }
}
