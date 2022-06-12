package com.twiss.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 * @Author: Twiss
 * @Date: 2022/6/12 9:39 上午
 */
public class StackWithQueue {

    Deque<Integer> queue;

    public StackWithQueue(){
        queue = new ArrayDeque<>();
    }

    public void push(int x){
        queue.addLast(x);
    }

    public int pop(){
        // [1,2,3,4]
        int size = queue.size();
        size--;
        while (size-->0){
            queue.addLast(queue.peekFirst());
            queue.pollFirst();
        }
        // [4,1,2,3]
        int res = queue.pollFirst();
        return res;
    }

    public int top(){
        return queue.peekLast();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
    }
}
