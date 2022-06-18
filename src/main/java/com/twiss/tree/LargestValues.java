package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 在每个树行中找最大值
 * @Author: Twiss
 * @Date: 2022/6/18 2:58 下午
 */
public class LargestValues {

    public List<Integer> getLargestValue(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                max = Math.max(max,node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> ans = new LargestValues().getLargestValue(root);
        System.out.println(JSONObject.toJSONString(ans));

    }
}
