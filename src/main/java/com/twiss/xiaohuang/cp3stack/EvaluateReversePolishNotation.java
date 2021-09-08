package com.twiss.xiaohuang.cp3stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/9/3 5:35 下午
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] expression){
        if (expression==null||expression.length==0){
            return -1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int n = expression.length;
        for (int i=0;i<n;++i){
            String op = expression[i];
            if (isNumber(op)){
                deque.addLast(Integer.parseInt(op));
            }else {
                int number1 = deque.pollLast();
                int number2 = deque.pollLast();
                switch (op){
                    case "+":
                        deque.addLast(number1+number2);
                        break;
                    case "-":
                        deque.addLast(number1-number2);
                        break;
                    case "*":
                        deque.addLast(number1*number2);
                        break;
                    case "/":
                        deque.addLast(number1/number2);
                        break;
                    default:
                }
            }
        }
        return deque.pop();
    }

    private Boolean isNumber(String ex){
        return !("+".equals(ex)||"-".equals(ex)||"*".equals(ex)||"/".equals(ex));
    }

    public static void main(String[] args) {
        String[] expression = {"2", "1", "+", "3", "*"};
        int ans = new EvaluateReversePolishNotation().evalRPN(expression);
        System.out.println(ans);
    }
}
