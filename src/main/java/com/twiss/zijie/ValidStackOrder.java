package com.twiss.zijie;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证栈序列
 * @Author: Twiss
 * @Date: 2022/4/26 11:33 上午
 */
public class ValidStackOrder {

    public boolean isValid(int[] push,int[] pop){
        Deque<Integer> stack = new LinkedList<>();
        int n = push.length;
        int j =0;
        for (int i=0;i<push.length;++i){
            stack.push(push[i]);
            while (!stack.isEmpty()&&j<pop.length&&pop[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
