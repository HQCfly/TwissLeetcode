package com.twiss.microsoftII;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复最长子串
 * 滑动窗口+快慢指针
 * @Author: Twiss
 * @Date: 2022/2/25 3:58 下午
 */
public class LengthOfLongestSubstring {

    public int getSubstring(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        Set<Character> occ = new HashSet<>();
        int res = 0;
        int n = s.length();
        int rk=-1;
        for (int i=0;i<n;++i){
            // 表示向后移动了，因此需要将其char在set中删除
            if (i!=0){
                occ.remove(s.charAt(i));
            }
            // 此时快指针向后移动
            while (rk+1<n&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            res = Math.max(res,rk-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = new LengthOfLongestSubstring().getSubstring(s);
        System.out.println(res);
    }
}
