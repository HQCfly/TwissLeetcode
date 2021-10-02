package com.twiss.xiaohuang.cp4heap;

import com.alibaba.fastjson.JSONObject;

/**
 * T(n) = O(n)
 * T(n) = T(n/2)
 * Heapify down from A.length -> 0.
 *      n/2 - n : Leafs, Do nothing.
 *      n/4 - n/2: heapify down 1 level maximum (find the min from left and right, then swap).
 *      n/8 - n/4: heapify down 2 level maximum
 *      ...
 *      0 :     heapify down logn maximum.
 *
 * Complexity: n/2 * 1 + n/4 * 2 + ... + n/(2 ^ h) * lg h
 *			 = n (1/2 + 1/4 ...)
 *           = n.
 * @Author: Twiss
 * @Date: 2021/9/15 1:17 下午
 */
public class UnsortedArrayConvertMinHeap {
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
            if (son + 1 < array.length && array[son] > array[son + 1]) {
                son = son + 1;
            }

            if (array[son] >= array[index]) {
                break;
            }
            int temp = array[son];
            array[son] = array[index];
            array[index] = temp;
            index = son;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 2, 8, 5, 6, 1, 3};
        new UnsortedArrayConvertMinHeap().buildMinHeap(array);
        System.out.println(JSONObject.toJSONString(array));
    }
}
