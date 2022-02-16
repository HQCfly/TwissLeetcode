package com.twiss.slidwindow;

import java.util.HashMap;

/**
 * 至多包含两个不同字符的最长子串
 * intpu: eceba output:3   因为ece
 * input: ccaabbb output:5 因为aabbb
 *
 * @Author: Twiss
 * @Date: 2022/2/16 1:26 下午
 */
public class LongestSubstringTwoDistinct {

    public int getLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> hasWord = new HashMap<>();
        int count = 0, maxLength = 0;//不同字符数量
        for (int start = 0, end = 0; end < n; end++) {
            char endChar = s.charAt(end);
            int endNum = hasWord.getOrDefault(endChar,0)+1;
            hasWord.put(endChar,endNum);
            // 第一次进入hasWord，表示新增一个新字母
            if (endNum==1){
                count++;
            }
            // count<2的时候判断maxLength与end-start大小
            if (count<=2){
                maxLength = Math.max(maxLength,end-start+1);
            }
            // 缩小时间窗口，增加start指针
            while (count>2){
                // start右移一位
                char startChar = s.charAt(start);
                int startNum = hasWord.get(startChar)-1;
                hasWord.put(startChar,startNum);
                if (startNum==0){
                    count--;
                }
                start++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ccaabbb";
        int res = new LongestSubstringTwoDistinct().getLongestSubstring(s);
        System.out.println(res);
    }
}
