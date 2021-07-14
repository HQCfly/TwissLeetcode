package com.twiss.binaryindextree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2021/7/14 9:13 下午
 */
public class ReversePairs {

    private int getCountOfReversPairs(int[] numbers) {
        int length = numbers.length;

        if (length < 2) {
            return 0;
        }

        // 使用set去除重复元素
        Set<Integer> numbersSet = new HashSet<Integer>();
        for (int num : numbers) {
            numbersSet.add(num);
        }
        // 把排名存到hash表中
        Map<Integer, Integer> rankMap = new HashMap<>();
        int index = 1;
        for (int num : numbersSet) {
            rankMap.put(num, index);
            index++;
        }

        int count = 0;
        // 使用树状数组完成前缀和
        // 从后向前，先给对应的排名+1，然后在计算前缀和
        FenwickTree fenwickTree = new FenwickTree(length);
        for (int i = length - 1; i >= 0; i--) {
            // 获取当前num的下标
            int rank = rankMap.get(numbers[i]);
            fenwickTree.update(rank, 1);
            count += fenwickTree.query(rank - 1);
        }
        return count;
    }

    private class FenwickTree {
        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i <= this.len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }

    }

    public static void main(String[] args) {
        int[] numbers = {5, 5, 2, 3, 6};
        int count = new ReversePairs().getCountOfReversPairs(numbers);
        System.out.println(count);
    }
}
