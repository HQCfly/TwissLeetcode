package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层平均值
 * @Author: Twiss
 * @Date: 2022/6/18 10:37 上午
 */
public class AverageOfLevels {

    public List<Double> getAverage(TreeNode root){
        List<Double> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0.0;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }

            }

            res.add(sum/size);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Double> ans = new AverageOfLevels().getAverage(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
