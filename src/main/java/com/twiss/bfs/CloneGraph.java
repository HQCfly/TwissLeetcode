package com.twiss.bfs;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/8/21 8:31 下午
 */
public class CloneGraph {
    private HashMap<Node,Node> visited = new HashMap<Node,Node>();

    public Node getCloneGraph(Node node){
        if (node==null){
            return node;
        }

        // 如果该节点被访问过直接从h哈希表返回。{原始图中节点, 克隆图中对应节点}
        if (visited.containsKey(node)){
            return visited.get(node);
        }

        //克隆节点，为了深拷贝不会克隆他的邻居列表
        Node cloneNode = new Node(node.val,new ArrayList<>());

        // 哈希表存储
        visited.put(node,cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbour:node.neighbors){
            cloneNode.neighbors.add(getCloneGraph(neighbour));
        }

        return cloneNode;
    }

    public Node getCloneGraphByBfd(Node node){
        if (node==null){
            return node;
        }

        HashMap<Node,Node> visitedByBfs = new HashMap<>();
        Deque<Node> deque = new LinkedList<>();
        // 将题目中给定的节点加入哈希表中
        deque.offer(node);
        visitedByBfs.put(node,new Node(node.val,new ArrayList<>()));

        while (!deque.isEmpty()){
            // 取出头节点
            Node n = deque.poll();

            // 遍历改点邻居
            for (Node neighbour:n.neighbors){
                if (!visitedByBfs.containsKey(neighbour)){
                    //如果没有被访问过，就克隆并存储在哈希表中
                    visitedByBfs.put(neighbour,new Node(neighbour.val,new ArrayList<>()));
                    deque.offer(neighbour);
                }
                // 更新当前节点的邻居列表
                visitedByBfs.get(node).neighbors.add(visitedByBfs.get(neighbour));
            }
        }
        return visitedByBfs.get(node);
    }

    public static void main(String[] args) {


        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node.neighbors.add(node2);
        node.neighbors.add(node4);

        node2.neighbors.add(node);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node);
        node4.neighbors.add(node3);

        Node res = new CloneGraph().getCloneGraph(node);

        System.out.println(JSONObject.toJSONString(res));
    }
}
