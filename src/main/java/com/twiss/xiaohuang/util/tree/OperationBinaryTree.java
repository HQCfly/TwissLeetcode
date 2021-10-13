package com.twiss.xiaohuang.util.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 按照层序添加数组形成树，求其遍历顺序
 * @Author: Twiss
 * @Date: 2021/10/7 10:27 下午
 */
public class OperationBinaryTree {
    Common common = new Common();
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void inOrder(TreeNode node) {
        common.inOrder(node);
    }

    public void preOrder(TreeNode rootNode) {
        common.preOrder(rootNode);
    }

    public void postOrder(TreeNode rootNode) {
        common.postOrder(rootNode);
    }

    public void addByLeve(Integer[] arrays) {
        int i = 1;
        this.root = new TreeNode(arrays[0]);  // 根节点
        TreeNode current = null;
        Integer value = null;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (i < arrays.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            value = arrays[i++];
            if (value != null) {
                TreeNode left = new TreeNode(value);
                current.setLeftChild(left);//创建当前节点的左孩子
                queue.offer(left); // 在链表尾部 左孩子入队
            }
            value = arrays[i++];
            if (value != null) {
                TreeNode right = new TreeNode(value);
                current.setRightChild(right);//创建当前节点的右孩子
                queue.offer(right);// 在链表尾部 右孩子入队
            }

        }
        levelIetrator(root);
    }

    private int levelIetrator(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.getLeftChild() != null) {
                queue.offer(current.getLeftChild());
//                System.out.println("节点" + current.val + "的左孩子是" + current.getLeft().val);
            }  //                System.out.println("节点" + current.val + "没有左孩子");

            if (current.getRightChild() != null) {
                queue.offer(current.getRightChild());
//                System.out.println("节点" + current.val + "的右孩子是" + current.getRight().val);
            }  //                System.out.println("节点" + current.val + "没有右孩子");

        }
        return 1;

    }

    public void show(TreeNode root){
        Common common = new Common();
        common.show(root);
    }

    public static void main(String[] args) {
        /**
         *              4
         *           /     \
         *          8       3
         *        /  \      \
         *       9    6      1
         *          /  \    /
         *         7   5   2
         */
        OperationBinaryTree bt = new OperationBinaryTree();
        Integer[] array = {4, 8, 3, 9, 6, null, 1, null,null, 7, 5, 2,null};
        bt.addByLeve(array);
        bt.show(bt.getRoot());
        System.out.println();
        System.out.println("bt1先序遍历PreOrder: ");
        bt.preOrder(bt.getRoot());
        System.out.println();
        System.out.println("bt1中序遍历InOrder: ");
        bt.inOrder(bt.getRoot());
        System.out.println();
        System.out.println("bt1后序遍历PostOrder: ");
        bt.postOrder(bt.getRoot());



        OperationBinaryTree bt2 = new OperationBinaryTree();
        Integer[] array2 = {9, 8, 7, 6, 5, 4,3,2, 1, 0, null};
        bt2.addByLeve(array2);
        bt2.show(bt2.getRoot());
        System.out.println();
        System.out.println("bt2先序遍历PreOrder: ");
        bt2.preOrder(bt2.getRoot());
        System.out.println();
        System.out.println("bt2中序遍历InOrder: ");
        bt2.inOrder(bt2.getRoot());
        System.out.println();
        System.out.println("bt2后序遍历PostOrder: ");
        bt2.postOrder(bt2.getRoot());
    }
}