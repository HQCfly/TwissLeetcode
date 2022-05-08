package com.twiss.greed;

/**
 * @Author: Twiss
 * @Date: 2022/5/8 2:53 下午
 */
public class GreedTreeNode {
    public int val;
    public GreedTreeNode left, right;
    public GreedTreeNode(int val){
        this.val = val;
    }
    public GreedTreeNode(int val, GreedTreeNode left, GreedTreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
