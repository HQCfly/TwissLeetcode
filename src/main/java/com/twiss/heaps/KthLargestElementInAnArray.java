package com.twiss.heaps;

/**
 * @Author: Twiss
 * @Date: 2021/9/20 11:29 下午
 */
public class KthLargestElementInAnArray {

    public int findKthLargestElement(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        // 第k个大元素下标是len - k
        int target = len-k;
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

    /**
     * 对数组 nums 的子区间 [left..right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的定义：
     * nums[left + 1..j] < nums[left]
     * nums(j..i) >= nums[left]
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left,int right){
        int pivot = nums[left];
        int j = left;
        for (int i=left+1;i<=right;i++){
            if (nums[i]<pivot){
                // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                j++;
                swap(nums,j,i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
