package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * @Author: Twiss
 * @Date: 2022/3/18 9:33 下午
 */
public class CopyRandomList {

    private HashMap<RandomNode,RandomNode> cache;
    public RandomNode copy(RandomNode node1){
        if (node1==null){
            return null;
        }
        if (cache.containsKey(node1)){
            RandomNode tmp = new RandomNode(node1.val);
            cache.put(node1,tmp);
            tmp.next = copy(node1.next);
            tmp.random = copy(node1.random);
        }
        return cache.get(node1);
    }

    public static void main(String[] args) {
        RandomNode randomNode = new RandomNode(7);
        randomNode.random = null;
        randomNode.next = new RandomNode(13);
        randomNode.next.random = randomNode;

    }
}

class RandomNode{
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}