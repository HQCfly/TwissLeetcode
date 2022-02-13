package com.twiss.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 * @Author: Twiss
 * @Date: 2022/2/13 4:16 下午
 */
public class BSTIteratorByDfs {

    private int index;
    private List<Integer> array;

    public BSTIteratorByDfs(TreeNode root){
        index = 0;
        array = new ArrayList<>();
        inorderTraversal(root);
    }

    public int next(){
        return array.get(index++);
    }

    public boolean hasNext(){
        return index<array.size();
    }

    private void inorderTraversal(TreeNode node){
        if (node==null){
            return;
        }

        inorderTraversal(node.left);
        array.add(node.val);
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15,new TreeNode(9),new TreeNode(20));
        BSTIteratorByDfs bstIteratorByDfs = new BSTIteratorByDfs(root);
        System.out.println(bstIteratorByDfs.next());
        System.out.println(bstIteratorByDfs.hasNext());
    }
}
