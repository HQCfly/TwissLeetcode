package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/9/5 2:03 下午
 */
public class MinStack {

    private Deque<Integer> stackElement = new ArrayDeque<>();
    private Deque<Integer> stackMinElement = new ArrayDeque<>();

    public MinStack() {
        stackMinElement.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stackElement.push(val);
        stackMinElement.push(Math.min(val,stackElement.peek()));
    }

    public void pop() {
        stackElement.pop();
        stackMinElement.pop();
    }

    public int top() {
        return stackElement.peek();
    }

    public int getMin() {
        return stackMinElement.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("originStack: "+minStack.stackElement);

        int minElement = minStack.getMin();
        System.out.println("minElement: "+minElement);
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
