package com.twiss.linkedlist;

/**
 * 设计链表
 *
 * @Author: Twiss
 * @Date: 2022/5/30 4:55 下午
 */
public class MyLinkedList {

    int size;
    LinkedNode head;

    public MyLinkedList() {
        head = new LinkedNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        LinkedNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        LinkedNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        LinkedNode tmp = curr.next;
        LinkedNode newNode = new LinkedNode(val);
        curr.next = newNode;
        newNode.next = tmp;
    }


    public void deleteAtIndex(int index) {
        if (index>size||index<0){
            return;
        }
        size--;
        LinkedNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        LinkedNode tmp = curr.next;
        curr.next = tmp.next;

    }

    public static void main(String[] args) {
        MyLinkedList head = new MyLinkedList();
        head.addAtHead(1);
        head.addAtTail(3);
        head.addAtIndex(1,2);
        System.out.println(head.get(1));
    }
}
