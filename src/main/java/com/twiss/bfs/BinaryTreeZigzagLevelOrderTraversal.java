package com.twiss.bfs;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/8/20 4:07 下午
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> getZigzagLeve(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if (root==null){
            return ret;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        boolean isOrderLeft = true;
        while (!treeNodeDeque.isEmpty()){
            Deque<Integer> levelList = new LinkedList<Integer>();
            int currentSize = treeNodeDeque.size();
            for (int i=1;i<=currentSize;++i){
                TreeNode node = treeNodeDeque.poll();
                if (isOrderLeft){
                    levelList.addLast(node.val);
                }else {
                    levelList.addFirst(node.val);
                }

                if (node.left!=null){
                    treeNodeDeque.offer(node.left);
                }

                if (node.right!=null){
                    treeNodeDeque.offer(node.right);
                }
            }
            ret.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ret;
    }
    /**
     *          3
     *         / \
     *        9   20
     *          /     \
     *         15      7
     * @param args
     */
    public static void main(String[] args) {
        // 构建树
        TreeNode treeNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        treeNode.left = new TreeNode(9);
        treeNode.right = rightNode;

        List<List<Integer>> res = new BinaryTreeZigzagLevelOrderTraversal().getZigzagLeve(treeNode);
        System.out.println(JSONObject.toJSONString(res));
    }
}
