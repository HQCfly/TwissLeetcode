package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> ans = new Traversal().preorderTraversal(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
