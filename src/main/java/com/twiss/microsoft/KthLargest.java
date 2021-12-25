package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author: Twiss
 * @Date: 2021/12/23 10:25 下午
 * 数组中第k个最大元素
 */
public class KthLargest {

    public int getKthLargestByQuickSorted(int[] nums, int k){
        return quickSorted(nums, 0,nums.length-1,nums.length-k);
    }

    private int quickSorted(int[] nums,int left, int right, int index){
        int pos = randomPartition(nums,left,right);
        if (pos==index){
            return nums[pos];
        }else {
            return pos<index?quickSorted(nums,pos+1,right,index):
                    quickSorted(nums,left,pos-1,index);
        }
    }

    private int randomPartition(int[] nums, int left, int right){
        int pos = new Random().nextInt(right-left+1)+1;
        swap(nums,pos,right);
        return partition(nums,left,right);
    }

    private int partition(int[] nums,int left,int right){
        int pivot = nums[right];
        // 将比pivot小的元素都替换到靠前位置
        int i = left-1;
        for (int j = left;j<right;++j){
            if (nums[j]<=pivot){
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,right);
        return i+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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

        int[] nums2 = {3,2,1,5,6,4};
        int k2 = 1;
        int res2 = new KthLargest().getKthLargestByQuickSorted(nums2,k2);
        System.out.println(res2);
    }

}
