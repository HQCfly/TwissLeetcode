package com.twiss.arraypractice;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public static TreeNode2 buildTree2(int[] inOrder, int[] postOrder){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i],i);
        }
        return solve(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
    }

    public static TreeNode2 solve(int[] post, int i1, int j1, int[] in, int i2, int j2, Map<Integer, Integer> map){
        if (i1>j1||i2>j2){
            return null;
        }
        TreeNode2 root = new TreeNode2(post[j1]);
        System.out.println(root.val);
        int index = map.get(root.val);
        int left = index - i2;
        root.left = solve(post, i1, i1 + left - 1, in, i2, index - 1 , map);
        root.right = solve(post, i1 + left, j1 - 1, in, index + 1, j2, map);
        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = {4,2,5,1,6,3,7};
        int[] postOrder = {4,5,2,6,7,3,1};

        TreeNode2 tree = buildTree2(inOrder,postOrder);
    }
}

class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x){
        val = x;
    }
}

