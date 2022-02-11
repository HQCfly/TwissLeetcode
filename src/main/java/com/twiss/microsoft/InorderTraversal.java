package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2022/2/11 8:56 下午
 */
public class InorderTraversal {

    public List<Integer> getResult(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode node,List<Integer> res){
        if (node==null){
            return;
        }
        // left
        dfs(node.left,res);
        // node
        res.add(node.val);
        // right
        dfs(node.right,res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = new InorderTraversal().getResult(root);
        System.out.println(JSONObject.toJSONString(res));
    }
}
