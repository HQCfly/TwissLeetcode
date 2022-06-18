package com.twiss.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针II
 * 非完全二叉树
 * @Author: Twiss
 * @Date: 2022/6/18 3:56 下午
 */
public class AddRightPointII {

    public List<String> getLevel(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i=0;i<size;i++){
                TreeNode node = deque.poll();
                if (i<size-1){
                    node.next = deque.peek();
                }
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
                res.add(String.valueOf(node.val));
                if (i==size-1){
                    res.add("#");
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<String> ans = new AddRightPointII().getLevel(root);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
