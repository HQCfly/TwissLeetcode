package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/10/6 10:18 上午
 */
public class BubbleSorted {

    public int[] getSortedNums(int[] arrays){
        int len = arrays.length;
        for (int i=len-1;i>=0;i--){
            // 先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较，
            // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
            boolean isSort = true;
            for (int j=0;j<i;j++){
                if (arrays[j]>arrays[j+1]){
                    swap(arrays,j,j+1);
                    isSort = false;
                }
            }

            if (isSort){
                break;
            }
        }
        return arrays;
    }

    private void swap(int[] arrays, int index1, int index2){
        int temp = arrays[index1];
        arrays[index1] = arrays[index2];
        arrays[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 4, 1, 3, 5, 6, 7};
        int[] sortedArrays = new BubbleSorted().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(sortedArrays));
    }
}
