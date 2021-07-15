package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/15 5:19 下午
 */
public class CountCompleteTreeNode {

    public int countNodes(TreeNode root) {

        if (root==null){
            return 0;
        }

        int left = countLevel(root.left);
        int right = countLevel(root.right);

        if (left==right){
            return countNodes(root.right)+(1<<left);
        }else {
            return countNodes(root.left)+(1<<right);
        }

    }

    private int countLevel(TreeNode root){
        int level = 0;
        while (root!=null){
            level++;
            root = root.left;
        }
        return level;
    }
}