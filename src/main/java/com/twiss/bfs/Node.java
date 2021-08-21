package com.twiss.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/8/21 8:05 下午
 */
public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
