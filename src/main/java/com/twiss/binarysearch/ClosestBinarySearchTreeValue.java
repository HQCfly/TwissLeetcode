package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/15 4:14 下午
 */
public class ClosestBinarySearchTreeValue {

    private int getClosestNumber(TreeNode treeNode,int target){
        int result = treeNode.val;
        while (treeNode!=null){
            if (Math.abs(treeNode.val-target)<Math.abs(result-target)){
                result = treeNode.val;
            }
            treeNode = treeNode.val>target?treeNode.left:treeNode.right;
        }
        return result;
    }

}