package com.twiss.microsoftII;

import java.util.Random;

/**
 * @Author: Twiss
 * @Date: 2022/7/30 1:54 下午
 */
public class KthLargestElement3 {

    public int getKthEle(int[] nums,int k){
        int n = nums.length;
        return  partition(nums,0,n-1,n-k);
    }

    private int partition(int[] nums, int left, int right, int index){
        int pivot = randomPartition(nums,left,right);
        if (pivot==index){
            return nums[pivot];
        }
        return pivot<index?partition(nums,pivot+1,right,index):
                partition(nums,left,pivot-1,index);
    }

    private int randomPartition(int[] nums, int left, int right){
        int pivot = new Random().nextInt(right-left+1)+left;
        swap(nums,pivot,right);
        int l = left-1;
        int p = nums[right];
        for (int i=left;i<right;i++){
            if (nums[i]<=p){
                l+=1;
                swap(nums,l,i);
            }
        }
        swap(nums,l+1,right);
        return l+1;
    }

    private void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = new KthLargestElement3().getKthEle(nums,k);
        System.out.println(ans);
    }
}
