package com.twiss.binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Twiss
 * @Date: 2021/7/24 2:57 下午
 */
public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k){
        ArrayList<Integer> num = inorder(root,new ArrayList<Integer>());
        return num.get(k-1);
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if (root==null) return arr;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }

    public int getKthSmallestEle(TreeNode root, int k){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true){
            // 从root遍历完整个left节点
            while (root!=null){
                stack.add(root);
                root = root.left;
            }
            // 此时left节点已经遍历完成
            root = stack.removeLast();
            // stack按照从大到小排序
            if (--k==0){
                return root.val;
            }
            // 如果没有到达最k值，则遍历right节点
            root = root.right;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode oneLeft = new TreeNode(3);
        TreeNode oneRight = new TreeNode(6);
        TreeNode oneLeftL = new TreeNode(2);
        TreeNode oneLeftR = new TreeNode(4);
        TreeNode oneRightR = new TreeNode(7);

        root.left = oneLeft;
        root.right = oneRight;

        oneLeft.left = oneLeftL;
        oneLeft.right = oneLeftR;

        oneRight.right = oneRightR;

        int res = new KthSmallestElementInABST().kthSmallest(root,2);
        System.out.println(res);

        int res2 = new KthSmallestElementInABST().getKthSmallestEle(root,3);
        System.out.println(res2);
    }
}
