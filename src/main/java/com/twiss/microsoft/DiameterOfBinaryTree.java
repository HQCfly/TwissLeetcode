package com.twiss.microsoft;

/**
 * @Author: Twiss
 * @Date: 2022/1/16 10:57 下午
 */
public class DiameterOfBinaryTree {

    private int ans;

    public int getDiameter(TreeNode root){
        ans = 1;
        depth(root);
        return ans-1;
    }

    private int depth(TreeNode node){
        if (node==null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(ans,left+right+1);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int res = new DiameterOfBinaryTree().getDiameter(root);
        System.out.println(res);
    }
}
