package com.twiss.heaps;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author: Twiss
 * @Date: 2021/9/20 11:29 下午
 */
public class KthLargestElementInAnArray {
    private static Random random = new Random(System.currentTimeMillis());

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     * @return
     */
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
     * 本题必须随机初始化 pivot 元素，否则通过时间会很慢，因为测试用例中有极端测试用例。
     * 为了应对极端测试用例，使得递归树加深，可以在循环一开始的时候，随机交换第 11 个元素与它后面的任意 11 个元素的位置；
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left,int right){
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

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

    /**
     * 时间复杂度O(nlogn)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestByHeap(int[] nums, int k){
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,(a,b)->a-b);
        // 使用前k个元素构建一个最小堆
        for (int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }
        // 使用剩余的元素对前k个元素进行堆顶比较。如果大于堆顶则将minHeap的堆顶推出，
        // 添加该元素到最小堆中
        for (int i = k;i<len;i++){
            Integer topElement = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i]>topElement){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = new KthLargestElementInAnArray().findKthLargestElement(nums,k);
        System.out.println(res);

        int[] nums2 = {3,2,1,5,6,4};
        int k2 = 2;
        int res2 = new KthLargestElementInAnArray().findKthLargestByHeap(nums2,k2);
        System.out.println(res2);
    }
}
