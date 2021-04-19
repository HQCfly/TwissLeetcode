package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/4/19 9:32 下午
 */
public class Subsets {
    /**
     * << : 左移运算符，num << 1,相当于num乘以2
     * >> : 右移运算符，num >> 1,相当于num除以2
     *
     * @param number
     * @return
     */
    public static List<List<Integer>> getSubsets(int[] number) {
        List<List<Integer>> res = new ArrayList<>();
        int n = number.length;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int t = i >> j;
                if (((i >> j) & 1) == 1) {
                    tmp.add(number[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static List<Integer> t = new ArrayList<Integer>();
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> getSubsets2(int[] number) {

        dfs(0, number);
        return ans;
    }

    public static void dfs(int curr, int[] number) {
        if (curr==number.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(number[curr]);
        dfs(curr+1,number);
        t.remove(t.size()-1);
        dfs(curr+1,number);
    }


    public static void main(String[] args) {
        int[] number = {1, 5, 7};
        List<List<Integer>> res = getSubsets(number);
        System.out.println(JSONObject.toJSONString(res));
        int[] number2 = {1, 5, 7};
        List<List<Integer>> res2 = getSubsets2(number2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
