package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

/**
 * 删除二叉搜索树节点
 * @Author: Twiss
 * @Date: 2022/8/8 7:43 下午
 */
public class DeleteNodeBST2 {

    public TreeNode deleteNode(TreeNode root, int key){
        if (root==null){
            return null;
        }
        if (root.val>key){
            root.left = deleteNode(root.left,key);
            return root;
        }
        if (root.val<key){
            root.right = deleteNode(root.right,key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode ans = new DeleteNodeBST2().deleteNode(root,3);
        System.out.println(ans.left.val);

    }
}
