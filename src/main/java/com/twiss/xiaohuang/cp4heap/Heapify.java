package com.twiss.xiaohuang.cp4heap;

import com.alibaba.fastjson.JSONObject;

/**
 * T(n) = O(n)
 * T(n) = T(n/2)
 * @Author: Twiss
 * @Date: 2021/9/15 1:17 下午
 */
public class Heapify {

    public void buildHeap(int[] array){
        for (int i=array.length/2;i>=0;i--){
            heapify(array,array.length,i);
        }
    }

    public void heapify(int[] array, int n,int i){
        // 初始化最大值作为root
        int largest = i;
        // 左子节点位置
        int l = 2*i+1;
        // 右子节点位置
        int r = 2*i+2;

        // 左节点比root大
        if (l<n&&array[l]>array[largest]){
            largest = l;
        }
        // 右节点比root大
        if (r<n&&array[r]>array[largest]){
            largest = r;
        }
        // 如果largest不是root
        if (largest!=i){
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // 重新调整子树
            heapify(array,n,largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,1,4,5};
        new Heapify().buildHeap(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
