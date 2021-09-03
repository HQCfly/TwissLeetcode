package com.twiss.stack;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/9/3 1:36 下午
 */
public class BinaryTreePreorderTraversal {
    private Deque<TreeNode> deque = new ArrayDeque<>();
    private List<Integer> res = new ArrayList<>();

    public List<Integer> getPreorderTraversal(TreeNode root){
        while (root!=null||!deque.isEmpty()){
            while (root!=null){
                res.add(root.val);
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            root = root.right;
        }
        return res;
    }

    public List<Integer> getPreorderTraversalByBacktracking(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        preorderTraversal(root,ans);
        return ans;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ans){
        if (root==null){
            return;
        }
        ans.add(root.val);
        preorderTraversal(root.left,ans);
        preorderTraversal(root.right,ans);
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

        List<Integer> res = new BinaryTreePreorderTraversal().getPreorderTraversal(root);
        System.out.println("迭代方法："+JSONObject.toJSONString(res));

        List<Integer> res2 = new BinaryTreePreorderTraversal().getPreorderTraversalByBacktracking(root);
        System.out.println("递归方法："+JSONObject.toJSONString(res2));
    }
}
