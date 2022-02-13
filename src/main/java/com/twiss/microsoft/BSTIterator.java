package com.twiss.microsoft;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜素搜树迭代
 * @Author: Twiss
 * @Date: 2022/2/13 4:24 下午
 */
public class BSTIterator {

    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root){
        cur = root;
        stack = new LinkedList<>();
    }

    public int next(){
        while (cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.poll();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext(){
        return cur!=null||!stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15,new TreeNode(9),new TreeNode(20));
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }
}
