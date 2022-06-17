package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 前中后遍历二叉树
 * @Author: Twiss
 * @Date: 2022/6/16 10:52 上午
 */
public class Traversal {

    /**
     * 先序遍历(root, left, right)
     * @param root 根节点
     */
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        getPreorder(root,res);
        return res;
    }

    private void getPreorder(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        res.add(root.val);
        getPreorder(root.left,res);
        getPreorder(root.right,res);
    }

    public List<Integer> preorderTraversalByIteration(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // 先将跟节点加入res中，其次将右孩子加入stack，最后将左孩子加入stack中
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right!=null){
                stack.push(node);
            }
            if (node.left!=null){
                stack.push(node);
            }
        }
        return res;
    }

    /**
     * 中序遍历(left,root,right)
     * @param root 根节点
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        getInorder(root,res);
        return res;
    }

    private void getInorder(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        getPreorder(root.left,res);
        res.add(root.val);
        getPreorder(root.right,res);
    }

    public List<Integer> inorderTraversalByIteration(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        // 左右中
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr!=null||!stack.isEmpty()){
            // 将所有的左节点加入栈中
            if (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else {
                // 推出当前栈顶元素
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历(left,right,root)
     * @param root 根节点
     */
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        getPostorder(root,res);
        return res;
    }

    private void getPostorder(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        getPreorder(root.left,res);
        getPreorder(root.right,res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversalByIteration(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // 先将跟节点加入res中，其次将左孩子加入stack，最后将右孩子加入stack中
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left!=null){
                stack.push(node);
            }
            if (node.right!=null){
                stack.push(node);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> ans = new Traversal().preorderTraversal(root);
        System.out.println(JSONObject.toJSONString(ans));

        List<Integer> ans2 = new Traversal().inorderTraversal(root);
        System.out.println(JSONObject.toJSONString(ans2));

        List<Integer> ans3 = new Traversal().postorderTraversal(root);
        System.out.println(JSONObject.toJSONString(ans3));
    }
}
