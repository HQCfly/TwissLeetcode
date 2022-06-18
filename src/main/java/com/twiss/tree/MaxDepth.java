package com.twiss.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉树最大深度
 *
 * @Author: Twiss
 * @Date: 2022/6/18 4:51 下午
 */
public class MaxDepth {

    public int getMaxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
