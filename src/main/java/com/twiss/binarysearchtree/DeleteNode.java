package com.twiss.binarysearchtree;


import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/10/1 10:26 上午
 */
public class DeleteNode {

    public TreeNode getNewTreeAfterDeleteNode(TreeNode root, int key){
        if (root==null){
            return null;
        }
        // delete from the right subtree
        if (key>root.val){
            root.right = getNewTreeAfterDeleteNode(root.right,key);
        }else if (key< root.val){
            // delete from the left subtree
            root.left = getNewTreeAfterDeleteNode(root.left,key);
        }else {
            // the node is leaf
            if(root.left==null&&root.right==null){
                root = null;
            }
            // the node is not leaf and has a right child
            else if (root.right!=null){
                root.val = successor(root);
                root.right = getNewTreeAfterDeleteNode(root.right,key);
            }
            // the node is not leaf and has a left child
            else {
                root.val = predecessor(root);
                root.left = getNewTreeAfterDeleteNode(root.left,key);
            }
        }
        return root;
    }

    /**
     * get successor
     * @param root
     * @return
     */
    public int successor(TreeNode root){
        root = root.right;
        while (root.left!=null){
            root = root.left;
        }
        return root.val;
    }

    /**
     * get predecessor
     * @param root
     * @return
     */
    public int predecessor(TreeNode root){
        root = root.left;
        while (root.right!=null){
            root = root.right;
        }
        return root.val;
    }
    /**
     *          5
     *       /
     *     3
     *    / \
     *   2  4
     *
     */
    public static void main(String[] args) {
        TreeNode threeLeft = new TreeNode(3,null,new TreeNode(4));
        TreeNode twoRight = new TreeNode(6, threeLeft,new TreeNode(8));
        TreeNode left = new TreeNode(2,new TreeNode(1),twoRight);

//        TreeNode right = new TreeNode(6,null,new TreeNode(7));
        TreeNode root = new TreeNode(9,left,null);
        TreeNode newTree = new DeleteNode().getNewTreeAfterDeleteNode(root,9);
        System.out.println(JSONObject.toJSONString(newTree.left.right.right.val));
    }
}
