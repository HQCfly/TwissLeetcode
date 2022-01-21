package com.twiss.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2022/1/21 6:37 下午
 */
public class LengthOfLongestOfSubstring {

    public int getLength(String words) {
        int res = 0, n = words.length();
        if (n == 0) {
            return res;
        }
        Set<Character> occ = new HashSet<>();
        int rk = -1;
        for (int i = 0; i < n; ++i) {
            // 说明慢指针已经向后移了一位
            if (i != 0) {
                occ.remove(words.charAt(i - 1));
            }
            // 此时表示快指针往后移动
            while (rk + 1 < n && !occ.contains(words.charAt(rk + 1))) {
                occ.add(words.charAt(rk + 1));
                rk++;
            }
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String words = "abcabcbb";
        int res = new LengthOfLongestOfSubstring().getLength(words);
        System.out.println(res);
    }
}
