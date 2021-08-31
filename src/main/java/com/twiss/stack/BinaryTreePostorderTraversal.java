package com.twiss.stack;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 后序遍历
 *
 * @Author: Twiss
 * @Date: 2021/8/31 12:09 下午
 */
public class BinaryTreePostorderTraversal {

    private Deque<TreeNode> deque = new ArrayDeque<>();
    private List<Integer> res = new ArrayList<>();

    public List<Integer> postOrderTraversal(TreeNode root) {
        TreeNode prev = null;
        while (root != null || !deque.isEmpty()) {
            // 先遍历完左子节点
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
            // 获取从stack中获取当前节点
            root = deque.pollLast();
            // 其次遍历右子节点
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                deque.addLast(root);
                root = root.right;
            }

        }
        return res;
    }

    public List<Integer> postOrderTraversalByBacktracking(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        postOrder(root,res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res){
        if (root==null){
            return;
        }
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }


    /**
     *    3
     *   / \
     *  9   20
     *    /     \
     *   15      7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rightNode = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root.left = new TreeNode(9);
        root.right = rightNode;

        List<Integer> res = new BinaryTreePostorderTraversal().postOrderTraversal(root);
        System.out.println("迭代法："+ JSONObject.toJSONString(res));

        List<Integer> res2 = new BinaryTreePostorderTraversal().postOrderTraversalByBacktracking(root);
        System.out.println("递归法："+ JSONObject.toJSONString(res2));

    }
}
