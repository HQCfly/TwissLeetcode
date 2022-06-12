package com.twiss.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 判断括号是否合法
 * @Author: Twiss
 * @Date: 2022/6/12 10:34 上午
 */
public class ValidBucket {

    public boolean isValid(String s){
        if (s==null||s.length()==0){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(')');
            }else if (s.charAt(i)=='['){
                stack.push(']');
            }else if (s.charAt(i)=='{'){
                stack.push('}');
            }else if (!stack.isEmpty()&&stack.peek()!=s.charAt(i)){
                return false;
            }else {
                //如果是右括号判断是否和栈顶元素匹配
                stack.pop();
            }
        }

        //最后判断栈中元素是否匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([{}])";
        boolean ans = new ValidBucket().isValid(s);
        System.out.println(ans);
    }
}
