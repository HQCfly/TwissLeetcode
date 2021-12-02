package com.twiss.tree;

/**
 * @Author: Twiss
 * @Date: 2021/12/2 4:20 下午
 * 时间复杂度O(n)
 */
public class LeafSum {

    public static int sum;

    public void getLeavesSum(TreeNode root){
        if (root == null)
            return;

        // add root data to sum if
        // root is a leaf node
        if (root.left == null && root.right == null)
            sum += root.val;
        // propagate recursively in left
        // and right subtree
        getLeavesSum(root.left);
        getLeavesSum(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        // variable to store sum of leaf nodes
        sum = 0;
        new LeafSum().getLeavesSum(root);
        System.out.println(sum);
    }
}
