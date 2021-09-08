package com.twiss.xiaohuang.cp3stack;

/**
 * @Author: Twiss
 * @Date: 2021/9/8 11:51 上午
 */
public class QueueOperation {
    public static void main(String[] args) {
        testQueueApproachII();
    }

    private static void testQueueApproachI(){
        // Create a queue of capacity 4
        QueueByApproachI q = new QueueByApproachI(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }

    private static void testQueueApproachII(){
        // Create a queue of capacity 4
        QueueByApproachII q = new QueueByApproachII(4);

        // print Queue elements
//        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}
