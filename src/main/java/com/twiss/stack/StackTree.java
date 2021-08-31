package com.twiss.stack;

/**
 * @Author: Twiss
 * @Date: 2021/8/31 11:12 上午
 */
public class StackTree {
    int val;
    StackTree left;
    StackTree right;

    StackTree() {
    }

    StackTree(int val) {
        this.val = val;
    }

    StackTree(int val, StackTree left, StackTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
