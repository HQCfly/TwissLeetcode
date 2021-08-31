package com.twiss.tree;

/**
 * @Author: Twiss
 * @Date: 2021/8/31 11:25 上午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){

    }
    public TreeNode(int x){
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
