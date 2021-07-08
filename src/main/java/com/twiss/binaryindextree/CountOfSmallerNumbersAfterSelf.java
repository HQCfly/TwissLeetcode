package com.twiss.binaryindextree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Twiss
 * @Date: 2021/6/29 11:36 下午
 */
public class CountOfSmallerNumbersAfterSelf {

    /**************** 方法1： 离散树状数组： 桶排序 ************************/
    // 桶排序数组[5,2,6,1]
    private int[] bucket = null;
    // 桶数组的值[0,0,0,0]
    private int[] bucketValue = null;

    private List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>(length);
        discretization(nums);
        for (int i = nums.length - 1; i >= 0; --i) {
            // 获取num[i]在bucket中的下标
            int id = getId(nums[i]);
            // 更新bucketValue值：出现nums[i]的次数
            update(id);
            // 取bucketValue前id-1的前缀和
            int preSum = query(id - 1);
            // 将preSum赋值到result的第i位置上
            result.add(preSum);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 计算前pos的数组bucketValue的前缀和
     *
     * @param pos
     * @return
     */
    private int query(int pos) {
        int ret = 0;
        while (pos >= 0) {
            ret += bucketValue[pos];
            pos--;
        }
        return ret;
    }

    /**
     * 更新查找到的bucket value值
     *
     * @param pos
     */
    private void update(int pos) {
        bucketValue[pos] = bucketValue[pos] + 1;
    }

    private void discretization(int[] number) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : number) {
            numberSet.add(num);
        }
        int size = numberSet.size();
        bucket = new int[size];
        bucketValue = new int[size];
        int index = 0;
        for (int num : numberSet) {
            bucket[index++] = num;
        }
        Arrays.sort(bucket);
        Arrays.fill(bucketValue, 0);
    }

    private int getId(int x) {
        return Arrays.binarySearch(bucket, x);
    }

    /**************** 方法2： 归并排序 ************************/

    /**
     * 原来的归并排序的算法是直接移动数组元素，现在需要定位排序之前元素的位置，
     * 所以merge算法中移动的是元素的下标，即索引数组元素
     * merge时对索引数组的排序规则是不再是直接比较其元素大小，而是取对应位置处的num元素比较大小
     */
    private int[] res;

    public List<Integer> countSmallerByMergeSort(int[] numbers) {

        int length = numbers.length;
        this.res = new int[length];
        int[] index = new int[length];

        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        merge(numbers, index, 0, length - 1);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private void merge(int[] number, int[] index, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            merge(number, index, left, mid);
            merge(number, index, mid + 1, right);
            mergeSort(number, index, left, mid, right);
        }

    }

    private void mergeSort(int[] number, int[] index, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];
        int i = 0;
        int tempLeft = left, tempMid = mid + 1;
        while (tempLeft <= mid && tempMid <= right) {
            // 寻找比当前元素以后小元素，即寻找number[x] > number[subRight] 并累加1
            // 对于原始数组的顺序不需要重新排列
            if (number[index[tempLeft]] <= number[index[tempMid]]) {
                tempArr[i] = index[tempMid];
                i++;
                tempMid++;
            } else {
                //res[k]在res中的位置即nums[k]在nums中的位置,(right-i2+1)是当前右半（有序）数组中一定小于nums[k]的元素个数
                // 将当前number[index[tempLeft]] < number[index[tempMid]]的左边元素大的索引 赋值给临时数组
                tempArr[i] = index[tempLeft];
                res[tempArr[i]] += (right - tempMid + 1);
                i++;
                tempLeft++;
            }
        }

        while (tempLeft <= mid) {
            tempArr[i++] = index[tempLeft++];
        }

        while (tempMid <= right) {
            tempArr[i++] = index[tempMid++];
        }

        for (int k = 0; k < tempArr.length; k++) {
            index[left + k] = tempArr[k];
        }
    }

    /**************** 方法3： 二叉索引树 ************************/

    /**
     *        1
     *          \
     *          6
     *        /
     *        2
     *          \
     *          5
     * @param numbers
     * @return
     */
    private List<Integer> countSmallerByBinaryIndexTree(int[] numbers) {
        Integer[] res = new Integer[numbers.length];
        Arrays.fill(res, 0);
        TreeNode root = null;
        for (int i = numbers.length - 1; i >= 0; i--) {
            root = insert(root, new TreeNode(numbers[i]), res, i);
        }
        return Arrays.asList(res);
    }

    private TreeNode insert(TreeNode root, TreeNode node, Integer[] res, int i) {
        if (root == null) {
            root = node;
            return root;
        }

        if (root.val >= node.val) {
            root.count++;
            root.left = insert(root.left, node, res, i);
        } else {
            res[i] += root.count + 1;
            root.right = insert(root.right, node, res, i);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] number = {5, 2, 6, 1};
        List<Integer> res = new CountOfSmallerNumbersAfterSelf().countSmaller(number);
        System.out.println(JSONObject.toJSONString(res));

        int[] numbers = {5, 2, 6, 1};
        List<Integer> res2 = new CountOfSmallerNumbersAfterSelf().countSmallerByMergeSort(numbers);
        System.out.println(JSONObject.toJSONString(res2));

        int[] numbers1 = {5, 2, 6, 1};
        List<Integer> res3 = new CountOfSmallerNumbersAfterSelf().countSmallerByBinaryIndexTree(numbers1);
        System.out.println(JSONObject.toJSONString(res3));
    }
}

class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
        count = 0;
    }
}