package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/8/30 9:52 上午
 */
public class BasicCalculator {

    public int getResult(String s){
        // 使用栈的时候使用ArrayDeque，队列使用LinkedList
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int sign = 1;

        int n = s.length();
        int ret = 0;
        int i = 0;

        char[] ch = s.toCharArray();
        while (i<n){
            if (ch[i]==' '){
                i++;
            }else if (ch[i]=='+'){
                sign = ops.peek();
                i++;
            }else if (ch[i]=='-'){
                sign = -ops.peek();
                i++;
            }else if (ch[i]=='('){
                ops.push(sign);
                i++;
            }else if (ch[i]==')'){
                ops.pop();
                i++;
            }else {
                int num = 0;
                while (i<n&&Character.isDigit(ch[i])){
                    num = num*10+ch[i]-'0';
                    i++;
                }
                ret +=sign*num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String expression = "1 + 1";
        int res = new BasicCalculator().getResult(expression);
        System.out.println(res);

        String expression2 = "(1+(4+5+2)-3)+(6+8)";
        int res2 = new BasicCalculator().getResult(expression2);
        System.out.println(res2);
    }
}
