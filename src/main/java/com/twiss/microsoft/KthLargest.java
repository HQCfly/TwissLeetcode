package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.PriorityQueue;

/**
 * @Author: Twiss
 * @Date: 2021/12/23 10:25 下午
 * 数组中第k个最大元素
 */
public class KthLargest {

    public int getKthLargestByQuickSorted(int[] nums, int k){

    }

    public int getKthLargest(int[] nums, int k){
        int length = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        for (int i=0;i<length;++i){
            maxHeap.add(nums[i]);
        }
        System.out.println(JSONObject.toJSONString(maxHeap));
        if (k>0){
            for (int i=0;i<k-1;i++){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 1;
        int res = new KthLargest().getKthLargest(nums,k);
        System.out.println(res);
    }
}
