package com.twiss.slidwindow;

import java.util.Arrays;

/**
 * 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/solution/zhu-shi-chao-xiang-xi-de-hua-dong-chuang-rc7d/
 * @Author: Twiss
 * @Date: 2022/2/18 2:20 下午
 */
public class PermutationInString {

    public boolean checkInclusion(String shortString, String longString) {
        int shortLen = shortString.length();
        int longLen = longString.length();
        if (longLen < shortLen) {
            return false;
        }
        char[] shortArrays = shortString.toCharArray();
        char[] longArrays = longString.toCharArray();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < shortLen; ++i) {
            count1[shortArrays[i] - 'a']++;
        }
        for (int start = 0, end = start + shortLen - 1; end < longLen; ++end) {
            count2[longArrays[end]-'a']++;
            if (Arrays.equals(count1,count2)){
                return true;
            }else {
                // start指针右移一位，所以需要减去
                count2[longArrays[start]-'a']--;
                if (count2[longArrays[start]-'a']<0){
                    count2[longArrays[start]-'a'] = 0;
                }
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean res = new PermutationInString().checkInclusion(s1,s2);
        System.out.println(res);
        String s3 = "eidboaoo";
        boolean res3 = new PermutationInString().checkInclusion(s1,s3);
        System.out.println(res3);
    }

}
