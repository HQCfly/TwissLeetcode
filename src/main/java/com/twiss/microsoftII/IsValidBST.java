package com.twiss.microsoftII;

/**
 * 验证二叉搜索树
 * 中序遍历
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/3/9 11:20 下午
 */
public class IsValidBST {
    private Integer pre = Integer.MIN_VALUE;;

    public boolean validBst(TreeNode root){
        if (root==null){
            return false;
        }
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root){
        if (root==null){
            return true;
        }
        if (!inorderTraversal(root.left)){
            return false;
        }
        if (pre>=root.val){
            return false;
        }
        pre = root.val;
        return inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
    }
}
