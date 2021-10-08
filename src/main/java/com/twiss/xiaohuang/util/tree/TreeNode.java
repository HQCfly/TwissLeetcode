package com.twiss.xiaohuang.util.tree;

/**
 * @Author: Twiss
 * @Date: 2021/9/15 6:58 下午
 */
public class TreeNode {
    int val;

    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int val){
        this.val = val;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild){
        super();
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode(){

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
