package com.twiss.xiaohuang.cp4heap;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/9/15 1:17 下午
 */
public class UnsortedArrayConvertMaxHeap {

    public void buildMinHeap(int[] array) {
        heapify(array);
    }

    public void heapify(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            siftDown(array, i);
        }
    }

    private void siftDown(int[] array, int index) {
        while (index * 2 + 1 < array.length) {
            int son = index * 2 + 1;
            // get less son
            if (son + 1 < array.length && array[son] < array[son + 1]) {
                son = son + 1;
            }
            if (array[son] <= array[index]) {
                break;
            }
            int temp = array[son];
            array[son] = array[index];
            array[index] = temp;
            index = son;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        new UnsortedArrayConvertMaxHeap().buildMinHeap(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
