package com.twiss.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除重复元素
 * @Author: Twiss
 * @Date: 2022/6/13 9:39 下午
 */
public class RemoveDuplicates {

    public String getNewString(String s){
        if (s==null||s.length()==0){
            return null;
        }

        Deque<Character> stack = new LinkedList<>();

        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (stack.isEmpty()||stack.peek()!=ch){
                stack.push(ch);
            }else {
                stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()){
            str.insert(0, stack.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String ans = new RemoveDuplicates().getNewString(s);
        System.out.println(ans);
    }
}
