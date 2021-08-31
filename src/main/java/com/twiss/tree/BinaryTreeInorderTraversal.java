package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/8/31 11:25 上午
 */
public class BinaryTreeInorderTraversal {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();

    /**
     * 迭代写法
     * @param root
     * @return
     */
    public List<Integer> getInorderTraversal(TreeNode root){
        while (root!=null|| !deque.isEmpty()){
            // 先获取左子树节点
            while (root!=null){
                deque.addLast(root);
                root = root.left;
            }
            // 获取当前节点值
            root = deque.pollLast();
            ans.add(root.val);
            // 替换当前节点为右子节点
            root = root.right;
        }
        return ans;
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<Integer> getInorderTraversalByBackTracing(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
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
        TreeNode root = new TreeNode(3);
        TreeNode rightNode = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        root.left = new TreeNode(9);
        root.right = rightNode;

        List<Integer> res = new BinaryTreeInorderTraversal().getInorderTraversal(root);
        System.out.println("迭代写法：" + JSONObject.toJSONString(res));

        List<Integer> res2 = new BinaryTreeInorderTraversal().getInorderTraversalByBackTracing(root);
        System.out.println("递归写法：" + JSONObject.toJSONString(res2));
    }
}
