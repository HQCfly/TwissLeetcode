package com.twiss.zijie;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转字符串
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/4/18 8:46 下午
 */
public class ReverseWords {

    public String getWords(String word){
        if (word==null){
            return null;
        }
        int left = 0, right = word.length()-1;
        while (left<=right&&word.charAt(left)==' '){
            left++;
        }

        while (left<=right&&word.charAt(right)==' '){
            right--;
        }
        StringBuilder ans = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        while (left<=right){
            char c = word.charAt(left);
            if ((ans.length()!=0)&&(c==' ')){
                deque.offerFirst(ans.toString());
                ans.setLength(0);
            }else if (c!=' '){
                ans.append(c);
            }
            ++left;
        }
        deque.offerFirst(ans.toString());
        return String.join(" ",deque);
    }

    public static void main(String[] args) {
        String word = "leet code";
        String ans = new ReverseWords().getWords(word);
        System.out.println(ans);
    }
}
