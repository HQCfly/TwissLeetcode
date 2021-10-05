package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/10/5 7:55 下午
 */
public class InsertSorted {

    public int[] getSortedNums(int[] arrays){
        int len = arrays.length;
        for (int i=1;i<len;++i){
            int temp = arrays[i];
            int j = i;
            while (j>0&&arrays[j-1]>temp){
                arrays[j] = arrays[j-1];
                j--;
            }
            arrays[j] = temp;
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] sortedArrays = new InsertSorted().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(sortedArrays));
    }
}
