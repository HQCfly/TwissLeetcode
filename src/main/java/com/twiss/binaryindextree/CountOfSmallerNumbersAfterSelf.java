package com.twiss.binaryindextree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

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
            int preSum = query(id-1);
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
            pos --;
        }
        return ret;
    }

    /**
     * 更新查找到的bucket value值
     * @param pos
     */
    private void update(int pos){
        bucketValue[pos] = bucketValue[pos]+1;
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
        return Arrays.binarySearch(bucket,x);
    }

    /**************** 方法2： 归并排序 ************************/

    public static void main(String[] args) {
        int[] number = {5, 2, 6, 1};
        List<Integer> res = new CountOfSmallerNumbersAfterSelf().countSmaller(number);
        System.out.println(JSONObject.toJSONString(res));
    }
}
