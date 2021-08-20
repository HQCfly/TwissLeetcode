package com.twiss.bfs;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/8/20 1:51 下午
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSeeLevelOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()){
            int currentSize = treeNodeDeque.size();
            for (int i=0;i<currentSize;++i){
                TreeNode node = treeNodeDeque.poll();

                if (node.left!=null){
                    treeNodeDeque.offer(node.left);
                }
                if (node.right!=null){
                    treeNodeDeque.offer(node.right);
                }
                if (i == currentSize-1){
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

    /**
     *          3
     *         / \
     *        9   20
     *       /     \
     *      15      7
     * @param args
     */
    public static void main(String[] args) {
        // 构建树
        TreeNode treeNode = new TreeNode(3);
        TreeNode rightNode = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        treeNode.left = new TreeNode(9);
        treeNode.right = rightNode;

        List<Integer> res = new BinaryTreeRightSideView().rightSeeLevelOrder(treeNode);
        System.out.println(JSONObject.toJSONString(res));
    }
}
