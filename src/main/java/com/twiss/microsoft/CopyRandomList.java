package com.twiss.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2022/1/31 3:53 下午
 */
public class CopyRandomList {

    Map<MicroLinkedNode, MicroLinkedNode> cacheNode = new HashMap<>();

    public MicroLinkedNode getCopyLinkedNode(MicroLinkedNode head) {

        if (head == null) {
            return null;
        }

        if (!cacheNode.containsKey(head)) {
            MicroLinkedNode headNew = new MicroLinkedNode(head.val);
            cacheNode.put(head, headNew);
            headNew.next = getCopyLinkedNode(head.next);
            headNew.random = getCopyLinkedNode(head.random);
        }
        return cacheNode.get(head);
    }

    public MicroLinkedNode getCopyLinkedNodeByIterator(MicroLinkedNode head) {
        if (head == null) {
            return null;
        }

        // 复制一个当前node
        for (MicroLinkedNode node = head; node != null; node = node.next.next) {
            MicroLinkedNode nodeNew = new MicroLinkedNode(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        for (MicroLinkedNode node = head; node != null; node = node.next.next) {
            MicroLinkedNode nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        MicroLinkedNode headNew = head.next;
        // 将head分成两个部分
        for (MicroLinkedNode node = head; node != null; node = node.next) {
            MicroLinkedNode nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }

    public static void main(String[] args) {
        MicroLinkedNode node = new MicroLinkedNode(1);
        MicroLinkedNode node2 = new MicroLinkedNode(2);
        node.next = node2;
        node.random = node2;
        node2.next = null;
        node2.random = node2;
        MicroLinkedNode res = new CopyRandomList().getCopyLinkedNode(node);
        System.out.println(res.val);
    }
}
