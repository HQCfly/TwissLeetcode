package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/10/5 8:27 下午
 */
public class MergeSorted {

    private int[] temp;

    public int[] getSortedNums(int[] arrays) {
        temp = new int[arrays.length];
        mergeSort(arrays, 0, arrays.length - 1);
        return arrays;
    }

    private void mergeSort(int[] arrays, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(arrays, left, mid);
        mergeSort(arrays, mid + 1, right);
        // handle left array and right array
        int i = left, j = mid + 1;
        int cnt = 0;
        // 按照从小到大往临时数组中添加元素
        while (i <= mid && j <= right) {
            if (arrays[i]<=arrays[j]){
                temp[cnt++] = arrays[i++];
            }else {
                temp[cnt++] = arrays[j++];
            }
        }
        // 对于left数组未添加完成的，继续往临时数组中添加
        while (i<=mid){
            temp[cnt++] = arrays[i++];
        }
        // 对于right数组未添加完成的，继续往临时数组中添加
        while (j<=right){
            temp[cnt++] = arrays[j++];
        }

        // 将临时数组中的元素与原始数组进行替换
        for (int k = 0; k < right - left + 1; ++k) {
            arrays[k + left] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        int[] sortedArrays = new MergeSorted().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(sortedArrays));
    }
}
