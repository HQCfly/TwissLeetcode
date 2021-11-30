package com.twiss.xiaohuang.cp4heap;

import com.alibaba.fastjson.JSONObject;
import com.twiss.xiaohuang.util.tree.OperationBinaryTree;

/**
 * @Author: Twiss
 * @Date: 2021/9/15 1:17 下午
 * O(n)
 */
public class UnsortedArrayConvertMinHeap {

    public void buildMinHeap(Integer[] array) {
        heapify(array);
    }

    public void heapify(Integer[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            siftDown(array, i);
        }
    }

    private void siftDown(Integer[] array, int index) {
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

    public void show(Integer[] array1){
        int n = array1.length;
        Integer[] array = new Integer[n+1];
        if (n%2==0){
            for (int i=0;i<n+1;++i){
                if (i<n){
                    array[i]=array1[i];
                }
            }
        }else {
            array = array1;
        }
        OperationBinaryTree tree = new OperationBinaryTree();
        tree.addByLeve(array);
        tree.show(tree.getRoot());
    }

    public void removeMin(Integer[] array1){
        int n = array1.length;
        Integer[] array = new Integer[n-1];
        for (int i=0;i<n-1;++i){
            if (i==0){
                array[i] = array1[n-1];
            }else {
                array[i] = array1[i];
            }
        }
        System.out.println("删除后的元素列表排序（未重新堆化）："+JSONObject.toJSONString(array));
        buildMinHeap(array);
        System.out.println("删除后堆顶元素后树的形状：");
        show(array);
        System.out.println("删除后堆顶元素排序："+JSONObject.toJSONString(array));
    }

    public static void main(String[] args) {
//        Integer[] array = { 2, 9, 5, 10, 11, 7, 8,6};
        Integer[] array = { 3, 4, 6, 9, 7,2};
        UnsortedArrayConvertMinHeap minHeap = new UnsortedArrayConvertMinHeap();
        minHeap.buildMinHeap(array);
        System.out.println("最小堆化后的数组："+JSONObject.toJSONString(array));
        minHeap.show(array);
        System.out.println();
        minHeap.removeMin(array);
    }

}
