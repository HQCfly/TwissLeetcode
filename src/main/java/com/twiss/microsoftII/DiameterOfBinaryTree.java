package com.twiss.microsoftII;

/**
 * 二叉树直径
 *
 * @Author: Twiss
 * @Date: 2022/2/26 7:28 下午
 */
public class DiameterOfBinaryTree {

    private int ans;
    public int getDiameter(TreeNode root){
        ans = 1;
        if (root==null){
            return ans;
        }
        depth(root);
        return ans-1;
    }

    private int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        ans = Math.max(leftDepth,rightDepth);
        return Math.max(leftDepth,rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        int ans = new DiameterOfBinaryTree().getDiameter(root);
        System.out.println(ans);
    }

}
