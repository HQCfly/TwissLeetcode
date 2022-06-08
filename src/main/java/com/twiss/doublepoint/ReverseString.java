package com.twiss.doublepoint;

import java.util.Arrays;

/**
 * 翻转字符串
 *
 * @Author: Twiss
 * @Date: 2022/6/7 4:53 下午
 */
public class ReverseString {

    public String getReverseString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int n = s.length();
        int l = 0, r = s.length() - 1;
        char[] c = s.toCharArray();
        while (l < r) {
            c[l] ^= c[r];
            c[r] ^= c[l];
            c[l] ^= c[r];
            l++;
            r--;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "Hello";
        String ans = new ReverseString().getReverseString(s);
        System.out.println(ans);
    }
}
