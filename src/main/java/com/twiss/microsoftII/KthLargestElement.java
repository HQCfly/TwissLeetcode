package com.twiss.microsoftII;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 数组中第k个大的元素，最小堆和快排
 *
 * @Author: Twiss
 * @Date: 2022/2/14 2:56 下午
 */
public class KthLargestElement {

    public int getKthElement(int[] nums, int k) {
        int n = nums.length;
        // 构建最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < k; ++i) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = k; i < n; ++i) {
            int topElement = priorityQueue.peek();
            if (nums[i] > topElement) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    public int getKthElementByQuickSort(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, 0, n - 1, n - k);
    }

    private int quickSort(int[] nums, int left, int right, int index) {
        int pivot = randomPartition(nums,left,right);
        if (pivot == index) {
            return nums[pivot];
        }
        return pivot < index ? quickSort(nums, pivot + 1, right, index) :
                quickSort(nums, left, pivot - 1, index);
    }

    private int randomPartition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + 1;
        swap(nums, randomIndex, right);
        return partition(nums,left,right);
    }

    public int partition(int[] nums, int left, int right) {
        int tmp = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            // 将left之后的元素如果比right元素小的话，则将其转移到前面
            if (nums[j]<=tmp){
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,right);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = new KthLargestElement().getKthElement(nums,k);
        System.out.println(res);

        int[] nums2 = {3,2,1,5,6,4};
        int res2 = new KthLargestElement().getKthElementByQuickSort(nums2,k);
        System.out.println(res2);
    }
}
