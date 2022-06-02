package com.twiss.hashtable;

/**
 * 有效的字母异位词
 * @Author: Twiss
 * @Date: 2022/6/1 11:59 下午
 */
public class IsAnagram {

    public boolean isvalid(String s, String t){
        int[] record = new int[26];
        for (int i=0;i<s.length();i++){
            record[s.charAt(i)-'a'] +=1;
        }
        for (int i=0;i<t.length();i++){
            record[t.charAt(i)-'a'] -=1;
        }
        for (int i:record){
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean ans = new IsAnagram().isvalid(s,t);
        System.out.println(ans);
    }
}
