package com.twiss.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 * @Author: Twiss
 * @Date: 2022/5/17 11:33 上午
 */
public class WordBreak {

    public boolean isBreakByDp(String words, List<String> wordDict){
        boolean[] valid = new boolean[words.length()+1];
        valid[0] = true;
        for (int i =1;i<=words.length();i++){
            for (int j =0;j<i;j++){
                if (wordDict.contains(words.substring(j,i))&&valid[j]){
                    valid[i] = true;
                }
            }
        }
        return valid[words.length()];
    }

    public boolean isBreakByDFS(String words, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        int[] mem = new int[words.length()+1];
        return dfs(words,set,mem,0);
    }

    private boolean dfs(String words, Set<String> wordDict, int[] mem, int startIndex){
        if (startIndex==words.length()){
            return true;
        }
        if (mem[startIndex]==-1){
            return false;
        }
        for (int i=startIndex;i<words.length();i++){
            String sub = words.substring(startIndex,i+1);
            if (!wordDict.contains(sub)){
                continue;
            }
            boolean res = dfs(words,wordDict,mem,i+1);
            if (res){
                return true;
            }
        }
        mem[startIndex] = -1;
        return false;
    }

    public static void main(String[] args) {
        String words = "leetcode";
        List<String> wordsDic = Arrays.asList("leet","code");
        boolean ans = new WordBreak().isBreakByDp(words,wordsDic);
        System.out.println(ans);

        boolean ans2 = new WordBreak().isBreakByDFS(words,wordsDic);
        System.out.println(ans2);

    }
}
