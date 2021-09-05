package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 * 使用双栈实现，一个作为元素入栈，一个作为出栈
 * 比如1，2，3先压入栈得到3，2，1，
 * 继而将入栈的所有元素都重新压入出栈中得到出栈：1，2，3
 * 最后对出栈进行pop或者peek操作
 * @Author: Twiss
 * @Date: 2021/9/5 9:55 上午
 */
public class ImplementQueueUsingStacks {

    private Deque<Integer> inputStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public ImplementQueueUsingStacks(){

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty()&&outStack.isEmpty();
    }

    private void in2out(){
        while (!inputStack.isEmpty()){
            outStack.addLast(inputStack.pollLast());
        }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        obj.push(3);

        int param2 = obj.peek();
        System.out.println("param2: "+param2);

        int param3 = obj.pop();
        System.out.println("param3: "+param3);

        int param4 = obj.peek();
        System.out.println("param4: "+param4);

        boolean param = obj.empty();
        System.out.println("param: "+param);
    }

}
