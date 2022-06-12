package com.twiss.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 * @Author: Twiss
 * @Date: 2022/6/12 8:30 上午
 */
public class QueueWithStack {

    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    public QueueWithStack(){
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void put(int val){
        stackIn.push(val);
    }

    public int pop(){
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek(){
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty(){
        return stackIn.isEmpty()&&stackOut.isEmpty();
    }

    private void dumpstackIn(){
        if (stackOut.isEmpty()){
            return;
        }
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}
