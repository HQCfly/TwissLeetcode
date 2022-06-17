package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 层序遍历II
 * 与层序遍历顺序相反
 * @Author: Twiss
 * @Date: 2022/6/17 11:17 上午
 */
public class LevelTraversalII {

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
                tmp.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(0,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<List<Integer>> ans = new LevelTraversalII().getLevel(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
