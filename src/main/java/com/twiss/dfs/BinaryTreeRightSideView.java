package com.twiss.dfs;

import com.alibaba.fastjson.JSONObject;
import com.twiss.dfs.TreeNode;

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
        dfs(ans,root,0);
        return ans;
    }

    private void dfs(List<Integer> res, TreeNode node, int depth){
        if (node==null){
            return;
        }

        // 先访问当前节点，再访问左右子树
        if (depth==res.size()){
            // 如果当前节点所在深度还没有出现在res里，
            // 说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中
            res.add(node.val);
        }

        depth++;
        dfs(res,node.right,depth);
        dfs(res,node.left,depth);
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

        List<Integer> res = new BinaryTreeRightSideView().rightSeeLevelOrder(treeNode);
        System.out.println(JSONObject.toJSONString(res));
    }
}
