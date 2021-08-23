package com.twiss.dfs;

import com.twiss.dfs.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2021/8/23 1:35 下午
 */
public class MinimumDepthOfBinaryTree {

    public int getMinimumDepth(TreeNode root){
        if (root==null){
            return 0;
        }

        if (root.left==null&&root.right==null){
            return 1;
        }
        int ans = Integer.MAX_VALUE;

        if (root.left!=null){
            ans = Math.min(ans,getMinimumDepth(root.left));
        }

        if (root.right!=null){
            ans = Math.min(ans,getMinimumDepth(root.right));
        }

        return ans+1;
    }

    /**
     *          3
     *         / \
     *        9   20
     *          /     \
     *         15      7
     * @param args
     */
    public static void main(String[] args) {
        // 构建树
        TreeNode treeNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        treeNode.left = new TreeNode(9);
        treeNode.right = rightNode;

        int res = new MinimumDepthOfBinaryTree().getMinimumDepth(treeNode);
        System.out.println(res);
    }
}
