package com.twiss.xiecheng;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/3/10 8:46 下午
 */
public class Permute {

    public int permute(int[] nums) {
        int res = 0;

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        HashSet<Integer> resSet = new HashSet<Integer>();
        backtrack(n, output, resSet, 0);
        Iterator<Integer> it = resSet.iterator();

        while(it.hasNext()){
            int a = it.next();
            res+=getPrimeNum(a);
        }
        return res;
    }

    public void backtrack(int n, List<Integer> output, HashSet<Integer> res, int first) {
        // 所有数都填完了
        if (first == n) {
            int sum = 1;
            for (int i = 0; i < n; ++i) {
                sum *= output.get(i);
            }
            res.add(sum);
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    private int getPrimeNum(int nums) {
        List<Integer> primes = new ArrayList<>();
        for (int candidate = 2; nums > 1; candidate++) {

            for (; nums % candidate == 0; nums /= candidate) {

                primes.add(candidate);

            }

        }
        return primes.size();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6};
        int ans = new Permute().permute(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
