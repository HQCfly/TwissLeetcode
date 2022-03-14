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
        int pivot = randomPartition(nums, left, right);
        if (pivot == index) {
            return nums[pivot];
        }
        return pivot < index ? quickSort(nums, pivot + 1, right, index) :
                quickSort(nums, left, pivot - 1, index);
    }

    private int randomPartition(int[] nums, int left, int right) {
        int randomIndex = left+new Random().nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int tmp = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            // 将left之后的元素如果比right元素小的话，则将其转移到前面
            if (nums[j] <= tmp) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int getKthByHeap(int[] nums, int k) {
        int heapSize = nums.length;
        int n = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = n - 1; i >= n - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int index, int heapSize) {
        int left = index * 2 + 1, right = index * 2 + 2, largest = index;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(nums, index, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int res = new KthLargestElement().getKthElement(nums, k);
        System.out.println(res);

        int[] nums2 = {3, 2, 1, 5, 6, 4};
        int res2 = new KthLargestElement().getKthElementByQuickSort(nums2, k);
        System.out.println(res2);

        int[] nums3 = {3, 2, 1, 5, 6, 4};
        int res3 = new KthLargestElement().getKthByHeap(nums3, 2);
        System.out.println(res3);
    }
}
