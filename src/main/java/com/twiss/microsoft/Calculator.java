package com.twiss.microsoft;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 简单计算器时间复杂度度O(N) 空间复杂度O(N)
 * https://leetcode-cn.com/problems/basic-calculator/solution/ru-he-xiang-dao-yong-zhan-si-lu-lai-zi-y-gpca/
 * @Author: Twiss
 * @Date: 2022/1/15 11:30 下午
 */
public class Calculator {

    public int getResult(String s){
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i<n){
            if (s.charAt(i)==' '){
                i++;
            }else if (s.charAt(i)=='+'){
                sign = ops.peek();
                i++;
            }else if (s.charAt(i)=='-'){
                sign = -ops.peek();
                i++;
            }else if (s.charAt(i)=='('){
                ops.push(sign);
                i++;
            }else if (s.charAt(i)==')'){
                ops.pop();
                i++;
            }else {
                int nums = 0;
                while (i<n&&Character.isDigit(s.charAt(i))){
                    nums = nums*10+s.charAt(i)-'0';
                    i++;
                }
                ret += sign*nums;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int res = new Calculator().getResult(s);
        System.out.println(res);
    }
}
