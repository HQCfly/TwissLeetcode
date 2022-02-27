package com.twiss.microsoftII;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 * 时间复杂度O()
 * 空间复杂度O()
 *
 * @Author: Twiss
 * @Date: 2022/2/27 2:12 下午
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> getTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean isOrderLeft = true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            Deque<Integer> path = new LinkedList<>();
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curr = deque.poll();
                if (isOrderLeft) {
                    path.offerLast(curr.val);
                } else {
                    path.offerFirst(curr.val);
                }
                if (curr.left != null) {
                    deque.offer(curr.left);
                }
                if (curr.right != null) {
                    deque.offer(curr.right);
                }
            }
            res.add(new ArrayList<>(path));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new ZigzagLevelOrder().getTraversal(root);
        System.out.println(res);
    }
}
