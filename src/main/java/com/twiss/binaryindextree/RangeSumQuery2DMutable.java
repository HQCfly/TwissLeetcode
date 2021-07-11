package com.twiss.binaryindextree;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/7/9 5:02 下午
 */
public class RangeSumQuery2DMutable {

    int[] treeNode;
    int[] nums;
    public RangeSumQuery2DMutable(int[] nums){
        this.nums = nums;
        treeNode = new int[nums.length*4];
        buildTree(0,0, nums.length-1);
    }

    private void buildTree(int curNode, int start, int end){
        if (start==end){
            treeNode[curNode] = nums[start];
            return;
        }

        int mid = start+((end-start)>>1);

        int leftNode = curNode*2+1;
        int rightNode = curNode*2+2;

        // 构建左子节点
        buildTree(leftNode,start,mid);
        // 构建右子节点
        buildTree(rightNode,mid+1,end);

        treeNode[curNode] = treeNode[leftNode]+treeNode[rightNode];
    }

    private void update(int index,int value){
        updateHelp(0,0, nums.length-1, index,value);
    }

    private void updateHelp(int currentNode,int start,int end,int index,int value) {
        if (start>end){
            return;
        }
        if (start==end){
            nums[index] = value;
            treeNode[currentNode]=value;
            return;
        }

        int mid = start+((end-start)>>1);
        int leftNode = currentNode*2+1;
        int rightNode = currentNode*2+2;

        if (index>=start&&index<=mid){
            updateHelp(leftNode,start,mid,index,value);
        } else {
            updateHelp(rightNode,mid+1,end,index,value);
        }

        treeNode[currentNode] = treeNode[leftNode]+treeNode[rightNode];
    }

    private int sumRange(int left,int right){
        return sum(0,0, nums.length-1, left,right);
    }

    private int sum(int currentNode,int start,int end,int left,int right){
        // 区间不在[left,right]范围内返回0
        if (left<start||right>end){
            return 0;
        }
        // 区间在[left,right]范围直接返回treeNode[currentNode]
        else if (left<=start&&right>=end){
            return treeNode[currentNode];
        }

        // 当寻找到叶子节点直接返回treeNode[currentNode]
        else if (start==end){
            return treeNode[currentNode];
        }

        int mid = start+((end-start)>>1);
        int leftNode = currentNode*2+1;
        int rightNode = currentNode*2+2;

        int leftSum = sum(leftNode,start,mid,left,right);
        int rightSum = sum(rightNode,mid+1,end,left,right);
        return leftSum+rightSum;
    }

    public static void main(String[] args) {

    }
}
