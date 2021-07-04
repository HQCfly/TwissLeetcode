package com.twiss.binaryindextree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/6/29 11:36 下午
 */
public class CountOfSmallerNumbersAfterSelf2 {

    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) return res;
        //将nums中的元素排序，记录每个元素对应的索引
        TreeSet<Integer> set = new TreeSet();
        for(int i = 0; i < len; i++){
            set.add(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for(Integer n : set){
            map.put(n, index);
            index++;
        }
        //利用索引更新并统计
        FenwickTree fenwickTree = new FenwickTree(len + 1);
        for(int i = len - 1; i >= 0; i--){
            index = map.get(nums[i]);
            //在索引位置添加计数1
            fenwickTree.update(index, 1);
            //统计比索引对应元素小的个数
            res.addFirst(fenwickTree.query(index - 1));
        }
        return res;
    }

    //线段树，O(logn)实现单点更新和前缀和计算
    private class FenwickTree {

        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }
        //更新本节点和父节点
        public void update(int i, int delta) {
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }
        //求和，找到对应树的节点
        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }
        //计算第一个非0的位置，2的幂
        public int lowbit(int x) {
            return x & (-x);
        }
    }

    public static void main(String[] args) {
        int[] number = {5, 2, 6, 1};
        List<Integer> res = new CountOfSmallerNumbersAfterSelf2().countSmaller(number);
        System.out.println(JSONObject.toJSONString(res));
    }
}
