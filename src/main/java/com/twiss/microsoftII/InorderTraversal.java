package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;
import scala.Int;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/2/28 10:15 下午
 */
public class InorderTraversal {

    public List<Integer> getTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res){
        if (root==null){
            return;
        }
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ans = new InorderTraversal().getTraversal(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
