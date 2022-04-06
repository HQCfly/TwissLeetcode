package com.twiss.shopee;

import java.util.*;

/**
 * 互斥字符串
 *
 * @Author: Twiss
 * @Date: 2022/4/6 7:35 下午
 */
public class MinOperationsString {

    public int MinOperations(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // 先进行按照字符串长度n进行互斥全排列
        // 根据所有的互斥排列遍历出与原始字符串变动最少的即可
        List<String> permute = getPermute(n);
        int min = Integer.MAX_VALUE;
        for (String single:permute){
            int tmpCount = 0;
            for (int i =0;i<n;++i){
                if (single.charAt(i)!=s.charAt(i)){
                    tmpCount++;
                }
            }
            min = Math.min(min,tmpCount);
        }
        return min;
    }
    private boolean[] visited;

    public List<String> getPermute(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        visited = new boolean[n];
        StringBuilder path = new StringBuilder();
        StringBuilder path2 = new StringBuilder();
        dfs(n, 0, path, res,'A');
        dfs(n, 0, path2, res,'B');
        return res;
    }

    private void dfs(int n,
                     int ith,
                     StringBuilder path,
                     List<String>  res,
                     Character start) {
        // 递归出口
        if (ith == n) {
            res.add(path.toString());
            return;
        }
        // 全排列
        for (int i = 0; i < n; ++i) {
            if (visited[i]||(i > 0&&!visited[i - 1])) {
                continue;
            }
            // 剪枝
            if (i>0){
                String tmp =  path.toString();
                if (tmp.charAt(i-1)=='A'){
                    path.append('B');
                }else {
                    path.append('A');
                }
            }else {
                path.append(start);
            }
            visited[i] = true;
            dfs(n,ith+1,path,res,start);
            visited[i] = false;
            if (i>0){
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABAA";
        int ans = new MinOperationsString().MinOperations(s);
        System.out.println(ans);
//        List<String> ans = new MinOperationsString().getPermute(2);
//        System.out.println(JSONObject.toJSONString(ans));
    }
}
