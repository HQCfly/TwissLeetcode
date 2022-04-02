package com.twiss.zijie;

import java.util.Random;

/**
 * 第k大的数
 * 时间复杂度O(nlog)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/4/2 8:46 下午
 */
public class KthLargestElement {

    public int findKtByQuickSorted(int[] nums,int k){
        if (nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int target = n-k;
        while (true){
            int index = partition(nums,left,right);
            if (index==target){
                return nums[index];
            }else if (index<target){
                left = index+1;
            }else {
                right = index-1;
            }
        }
    }

    private int partition(int[] nums,int left,int right){
        int randomIndex = left+new Random().nextInt(right-left+1);
        swap(nums,randomIndex,right);
        int pivot = nums[right];
        int j = left-1;
        for (int i=left;i<right;++i){
            if (nums[i]<pivot){
                j= j+1;
                swap(nums,i,j);
            }
        }
        swap(nums,j+1,right);
        return j+1;
    }

    private void swap(int[] nums,int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k=2;
        int ans = new KthLargestElement().findKtByQuickSorted(nums,k);
        System.out.println(ans);
    }
}
