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
                // 此步骤主要是为j做标志位，将j的向右移动最大位置计算出来
                j++;
                // 此步骤是为了将假如j是移动最大位置，此时的j与i不一致的情况下，将后续的较小元素移到前面
                // 此方式能实现比pivot大的元素都在后面
                swap(nums,j,i);
            }
        }
        // j是移动的最大位置，将left移动到最大位置处，即实现j左边都是小于pivot的
        swap(nums,j,left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = new KthLargestElementInAnArray().findKthLargestElement(nums,k);
        System.out.println(res);
    }
}
