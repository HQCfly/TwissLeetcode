package com.twiss.microsoftII;

/**
 * 二叉树的最大路径和
 * @Author: Twiss
 * @Date: 2022/2/19 1:12 下午
 */
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int getMaximumSum(TreeNode root){
        if (root==null){
            return maxSum;
        }
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        // 递归计算左节点贡献值，只有节点大于0才会选择该节点
        int maxLeft = Math.max(dfs(root.left),0);
        int maxRight = Math.max(dfs(root.right),0);

        int previous = root.val+maxLeft+maxRight;
        maxSum = Math.max(previous,maxSum);
        // 返回该节点的最大贡献值
        return root.val+Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int ans = new BinaryTreeMaximumPathSum().getMaximumSum(root);
        System.out.println(ans);
    }
}
