package com.twiss.arraypractice;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPreorderTraversal {

    public static TreeNode buildTree(int[] preOrder, int[] inOrder){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i],i);
        }
        return solve(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,map);
    }

    public static TreeNode solve(int[] preOrder, int i1, int j1, int[] inOrder, int i2, int j2, Map<Integer,Integer> map){
        if (i1>j1||i2>j2){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[i1]);
        int index = map.get(root.val);
        int nleft = index - i2;
        root.left = solve(preOrder,i1+1,i1+nleft,inOrder,i2,index-1,map);
        root.right = solve(preOrder,nleft+i1+1,j1,inOrder,index+1,j2,map);
        System.out.println(root.val);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] inOrder = {4,2,5,1,6,3,7};
        TreeNode tree = buildTree(preOrder,inOrder);
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

