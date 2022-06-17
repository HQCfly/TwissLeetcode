package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 右视图
 * @Author: Twiss
 * @Date: 2022/6/17 11:50 上午
 */
public class RightSideView {
    public List<List<Integer>> getLevel(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (i==size-1){
                    tmp.add(node.val);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<List<Integer>> ans = new RightSideView().getLevel(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
