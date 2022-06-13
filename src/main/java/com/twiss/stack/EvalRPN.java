package com.twiss.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 * @Author: Twiss
 * @Date: 2022/6/13 10:16 下午
 */
public class EvalRPN {

    public int getResult(String[] tokens){
        if (tokens==null||tokens.length==0){
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0;i<tokens.length;i++){
            String tmp = tokens[i].trim();
            if ("+".equals(tmp)){
                stack.push(stack.pop()+stack.pop());
            }else if ("-".equals(tmp)){
                stack.push(-stack.pop()+stack.pop());
            }else if ("*".equals(tmp)){
                stack.push(stack.pop()*stack.pop());
            }else if ("/".equals(tmp)){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(num2/num1);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {
                "2", "1", "+", "3", " * "
        };
        int ans = new EvalRPN().getResult(tokens);
        System.out.println(ans);
    }
}
