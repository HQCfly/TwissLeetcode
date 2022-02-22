package com.twiss.microsoftII;

import java.util.*;

/**
 * 翻转字符串里面的单词
 *
 * @Author: Twiss
 * @Date: 2022/2/22 5:25 下午
 */
public class ReverseString {

    public String getReverseString(String s){
        if (s==null){
            return null;
        }
        // 去掉头部和尾部空格
        s.trim();
        List<String> wordList = Arrays.asList(s.split("//s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }

    public String getReverseStringByDeque(String s){
        if (s==null){
            return null;
        }
        int left = 0, right = s.length()-1;
        //去掉头部空格字符
        while (left<=right&&s.charAt(left)==' '){
            left++;
        }
        // 去除尾部空格字符
        while (right>=left&&s.charAt(right)==' '){
            --right;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        while (left<=right){
            char c = s.charAt(left);
            if (word.length()!=0&&c==' '){
                deque.offerFirst(word.toString());
                word.setLength(0);
            }else if (c!=' '){
                word.append(c);
            }
            ++left;
        }
        deque.offerFirst(word.toString());
        return String.join(" ",deque);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String res = new ReverseString().getReverseString(s);
        System.out.println(res);
        String s2 = "  hello world  ";
        String res2 = new ReverseString().getReverseStringByDeque(s2);
        System.out.println(res2);
    }
}
