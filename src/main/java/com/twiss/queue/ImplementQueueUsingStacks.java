package com.twiss.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2021/9/5 9:55 上午
 */
public class ImplementQueueUsingStacks {

    private Deque<Integer> queue1 = new LinkedList<>();
    private Deque<Integer> queue2 = new LinkedList<>();

    public ImplementQueueUsingStacks(){

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue2.offerLast(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.pollFirst());
        }
        Deque<Integer> tmp  = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue1.pollFirst();
    }

    /** Get the front element. */
    public int top() {
        return queue1.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        obj.push(3);

        int param2 = obj.top();
        System.out.println("param2: "+param2);

        int param3 = obj.pop();
        System.out.println("param3: "+param3);

        int param4 = obj.top();
        System.out.println("param4: "+param4);

        boolean param = obj.empty();
        System.out.println("param: "+param);
    }
}
