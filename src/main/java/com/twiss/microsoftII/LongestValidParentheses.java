package com.twiss.microsoftII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 *
 * @Author: Twiss
 * @Date: 2022/2/24 12:11 下午
 */
public class LongestValidParentheses {

    public int getNumbersOfParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxAns = 0;
        int n = s.length();
        // 栈是存储的是字符串下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i=0;i<n;++i){
            char parentheses = s.charAt(i);
            if (parentheses=='('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxAns = Math.max(maxAns,i-stack.peek());
                }
            }
        }
        return maxAns;
    }

    public static void main(String[] args) {
        String s = "(()";
        int nums = new LongestValidParentheses().getNumbersOfParentheses(s);
        System.out.println(nums);
    }
}
