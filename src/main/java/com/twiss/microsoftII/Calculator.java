package com.twiss.microsoftII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/3/28 5:54 下午
 */
public class Calculator {

    public int getResult(String words){
        if (words==null||words.length()==0){
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        int ret = 0;
        stack.push(1);
        int n = words.length();
        int i=0;
        while (i<n){
            if (words.charAt(i)==' '){
                i++;
            }else if (words.charAt(i)=='+'){
                sign = stack.peek();
                i++;
            }else if (words.charAt(i)=='-'){
                sign = -stack.peek();
                i++;
            }else if (words.charAt(i)=='('){
                stack.push(sign);
                i++;
            }else if (words.charAt(i)==')'){
                stack.pop();
                i++;
            }else {
                long num = 0;
                while (i<n&&Character.isDigit(words.charAt(i))){
                    num = num*10+words.charAt(i)-'0';
                    i++;
                }
                ret+=sign*num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String words = "1 + 1";
        int ans = new Calculator().getResult(words);
        System.out.println(ans);
    }
}
