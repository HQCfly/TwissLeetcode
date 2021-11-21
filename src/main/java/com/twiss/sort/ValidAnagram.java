package com.twiss.sort;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/11/21 10:05 下午
 */
public class ValidAnagram {

    public boolean isValid(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean res = new ValidAnagram().isValid(s,t);
        System.out.println(res);
    }
}
