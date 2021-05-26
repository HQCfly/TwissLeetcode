package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/26 7:38 下午
 */
public class PalindromePartitioning {

    private List<List<String>> getPalindrome(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = buildMatrix(s, n);
        backtrace(n, 0,s, dp, new ArrayList<>(), res);
        return res;
    }

    /**
     * 动态规划方法判断s[i,j]从i到j是否是回文子串
     * f(i,j) = f(i+1,j-1)^(s[i]=s[j]) j>i的时候
     * @param s
     * @param n
     * @return
     */
    private boolean[][] buildMatrix(String s, int n) {
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }

    private void backtrace(int n, int start,String s, boolean[][] dp, List<String> sol, List<List<String>> res) {
        if (start == n) {
            res.add(new ArrayList<>(sol));
            return;
        }
        for (int i = start; i < n; i++) {
            if (dp[start][i]) {
                sol.add(s.substring(start,i+1));
                backtrace(n,i+1,s,dp,sol,res);
                sol.remove(sol.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = new PalindromePartitioning().getPalindrome(s);
        System.out.println(JSONObject.toJSONString(res));
    }

}
