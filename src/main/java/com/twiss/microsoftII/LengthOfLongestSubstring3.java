package com.twiss.microsoftII;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复最长子串
 * @Author: Twiss
 * @Date: 2022/8/8 5:47 下午
 */
public class LengthOfLongestSubstring3 {

    public int getMaxLength(String words){
        if (words==null||words.length()==0){
            return  0;
        }
        Set<Character> occ = new HashSet<>();
        int n = words.length();
        int rk = -1, ans = 0;
        for (int i=0;i<n;i++){
            if (i!=0){
                occ.remove(words.charAt(i-1));
            }
            while (rk+1<n&&!occ.contains(words.charAt(rk + 1))){
                occ.add(words.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String words = "abcabcbb";
        int ans = new LengthOfLongestSubstring3().getMaxLength(words);
        System.out.println(ans);
    }
}
