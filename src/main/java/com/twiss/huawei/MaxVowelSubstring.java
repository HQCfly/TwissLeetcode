package com.twiss.huawei;

import java.util.*;

/**
 * 最长的指定瑕疵度的元音子串
 * @Author: Twiss
 * @Date: 2022/6/25 9:26 下午
 */
public class MaxVowelSubstring {

    public int getMax(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        for (int start=0, end = 1;end<s.length();end++){
            if (list.contains(s.charAt(end))&&list.contains(s.charAt(start))){
                int len = end-start-1;
                if (len>=0&&len>=maxLen){
                    maxLen = len;
                    start = end;
                }
            }
        }
        if (maxLen==Integer.MIN_VALUE){
            maxLen = 0;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int ans = new MaxVowelSubstring().getMax(str);
            System.out.println(ans);
        }
    }
}
