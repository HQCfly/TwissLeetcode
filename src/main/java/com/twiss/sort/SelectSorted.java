package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/10/5 6:42 下午
 */
public class SelectSorted {

    public int[] getSortedNums(int[] arrays){
        int len = arrays.length;
        for (int i=0;i<len-1;++i){
            int minIndex= i;
            for (int j=i+1;j<len;++j){
                if (arrays[minIndex]>arrays[j]){
                    minIndex = j;
                }
            }
            swap(arrays,i,minIndex);
        }
        return arrays;
    }

    private void swap(int[] nums, int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] sortedArrays = new SelectSorted().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(sortedArrays));
    }
}
