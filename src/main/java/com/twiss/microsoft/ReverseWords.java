package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/1/9 9:54 下午
 */
public class ReverseWords {

    public String getReverseWords(String s){
        // 去除首尾空格
        s = s.trim();
        // 正则分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }

    public String getReverseWordsByDequeue(String s){
        int left = 0, right = s.length()-1;
        // 去除首部空白字符串
        while (left<=right&&s.charAt(left)==' '){
            ++left;
        }

        // 去除尾部空白字符串
        while (left<=right&&s.charAt(right)==' '){
            --right;
        }
        // 创建双端队列
        Deque<String> deque = new ArrayDeque<String>();
        StringBuilder words = new StringBuilder();

        while (left<=right){
            char c = s.charAt(left);
            if ((words.length())!=0&&c==' '){
                deque.offerFirst(words.toString());
                // 重新将words长度设置为0
                words.setLength(0);
            }else if (c!=' '){
                words.append(c);
            }
            left++;
        }
        deque.offerFirst(words.toString());
        return String.join(" ",deque);
    }

    public static void main(String[] args) {
        String s = "I have fun";
        String res = new ReverseWords().getReverseWords(s);
        System.out.println(JSONObject.toJSONString(res));

        String s2 = "I have fun";
        String res2 = new ReverseWords().getReverseWords(s2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
