package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转二叉树
 *
 * @Author: Twiss
 * @Date: 2022/6/19 10:56 下午
 */
public class InvertTree {

    public TreeNode dfs(TreeNode root){
        if (root==null){
            return null;
        }
        dfs(root.left);
        dfs(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root){
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public TreeNode bfs(TreeNode root){
        if (root==null){
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                swap(node);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode ans = new InvertTree().dfs(root);
        System.out.println(ans.left.val);
        TreeNode ans2 = new InvertTree().bfs(root);
        System.out.println(ans2.left.val);
    }

}
