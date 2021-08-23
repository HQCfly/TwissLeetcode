package com.twiss.bfs;

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

        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root);

        while (!deque.isEmpty()){
            int currentSize = deque.size();
            depth++;
            for (int i=0;i<currentSize;++i){
                TreeNode node = deque.poll();
                if (node.left==null&&node.right==null){
                    return depth;
                }
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
        return depth;
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
