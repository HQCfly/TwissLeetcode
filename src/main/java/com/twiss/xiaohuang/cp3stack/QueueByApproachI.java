package com.twiss.xiaohuang.cp3stack;

/**
 * Approach(I)
 * Time Complexity of Enqueue : O(1)
 * Time Complexity of Dequeue : O(n)
 * Rear在n位置，Front在0位置
 *
 * @Author: Twiss
 * @Date: 2021/9/8 11:50 上午
 */
// Java program to implement a queue using an array
public class QueueByApproachI {
    private static int front, rear, capacity;
    private static int queue[];

    QueueByApproachI(int c) {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }

    // function to insert an element
    // at the rear of the queue
    public void queueEnqueue(int data) {
        // check queue is full or not
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }else {
            // insert element at the rear
            queue[rear] = data;
            rear++;
        }
        return;
    }

    // function to delete an element
    // from the front of the queue
    public void queueDequeue() {
        // if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        } else {
            // shift all the elements from index 2 till rear
            // to the right by one
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            // store 0 at rear indicating there's no element
            if (rear < capacity){
                queue[rear] = 0;
            }
            // decrement rear
            rear--;
        }
        return;
    }

    // print queue elements
    public void queueDisplay() {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }

    // print front of queue
    public void queueFront() {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }
}



