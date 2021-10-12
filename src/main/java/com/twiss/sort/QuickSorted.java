package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.Random;

/**
 * @Author: Twiss
 * @Date: 2021/10/5 9:35 下午
 */
public class QuickSorted {

    public int[] getSortedNums(int[] array) {
        int len = array.length;
        quickSort(array, 0, len - 1);
        return array;
    }

    private void quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            // 选出左边小于基准值 右边大于基准值的下标
            int pos = partition(arrays, left, right);
            System.out.println(JSONObject.toJSONString(arrays));
            quickSort(arrays, left, pos - 1);
            quickSort(arrays, pos + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int randomIndex = left+new Random().nextInt(right - left + 1);
        System.out.println("randomIndex:"+randomIndex);
        swap(array, right, randomIndex);
        // 基准值
        int pivot = array[right];
        System.out.println("pivot:"+pivot);
        int i = left, j=right;
//        int lt = left;
        // 将比pivot小的元素都替换到靠前位置
        while (i<j){
            if (array[i++]>pivot){
                swap(array,--i,--j);
            }
        }
//        for (int i = left + 1; i <= right; i++) {
//            if (array[i] < pivot) {
//                lt++;
//                swap(array, i, lt);
//            }
//        }
        // 将前面lt个元素的最后一个元素与left替换，因为left是前lt元素最大
//        swap(array,i,lt);
        swap(array, i,right);
        return i;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 4, 1, 3, 5, 6, 7};
        int[] sortedArrays = new QuickSorted().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(sortedArrays));
    }
}
