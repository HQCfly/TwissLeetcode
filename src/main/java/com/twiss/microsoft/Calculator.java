package com.twiss.microsoft;

import java.util.Deque;
import java.util.LinkedList;

/**
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
            }else if (s.charAt(i)=='('){
                ops.push(sign);
            }else if (s.charAt(i)==')'){
                ops.pop();
                i--;
            }
        }
    }

    public static void main(String[] args) {

    }
}
