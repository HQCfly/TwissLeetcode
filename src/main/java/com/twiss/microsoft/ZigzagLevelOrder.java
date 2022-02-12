package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/2/12 7:48 下午
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> getResult(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean isOrderLeft = true;
        while (!deque.isEmpty()){
            Deque<Integer> levelList = new ArrayDeque<>();
            int size = deque.size();
            for (int i=0;i<size;++i){
                TreeNode currentNode = deque.poll();
                if (isOrderLeft){
                    levelList.addLast(currentNode.val);
                }else {
                    levelList.addFirst(currentNode.val);
                }
                if (currentNode.left!=null){
                    deque.add(currentNode.left);
                }
                if (currentNode.right!=null){
                    deque.add(currentNode.right);
                }
            }
            res.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new ZigzagLevelOrder().getResult(root);
        System.out.println(JSONObject.toJSONString(res));
    }
}
