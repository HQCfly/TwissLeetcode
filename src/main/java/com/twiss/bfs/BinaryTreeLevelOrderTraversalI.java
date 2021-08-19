package com.twiss.bfs;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/8/19 6:18 下午
 */
public class BinaryTreeLevelOrderTraversalI {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return list;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> leve = new ArrayList<>();
            int currentLeveSie = queue.size();
            for (int i=1;i<=currentLeveSie;++i){
                // 将当前的节点取出加入到leve中
                TreeNode currentNode = queue.poll();
                leve.add(currentNode.val);
                // 如果当前节点存在左节点，将其加入queue中进行下层次循环
                if (currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                // 如果当前节点存在右节点，将其加入queue中进行下层次循环
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            list.add(0,leve);
        }
        return list;
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

        List<List<Integer>> res = new BinaryTreeLevelOrderTraversalI().levelOrder(treeNode);
        System.out.println(JSONObject.toJSONString(res));

    }
}
