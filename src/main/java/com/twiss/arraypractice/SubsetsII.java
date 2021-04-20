package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/4/19 9:32 下午
 */
public class SubsetsII {
    /**
     * << : 左移运算符，num << 1,相当于num乘以2
     * >> : 右移运算符，num >> 1,相当于num除以2
     *
     * @param number
     * @return
     */
    public static List<List<Integer>> getSubsets(int[] number) {
        Arrays.sort(number);
        List<List<Integer>> res = new ArrayList<>();
        int n = number.length;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> tmp = new ArrayList<>();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    if (j > 0 && (i >> (j - 1) & 1) == 0 && number[j] == number[j - 1]) {
                        flag = false;
                        break;
                    }
                    tmp.add(number[j]);
                }
            }
            if (flag) {
                res.add(tmp);
            }
        }
        return res;
    }

    public static List<Integer> t = new ArrayList<Integer>();
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> getSubsets2(int[] number) {

        dfs(false,0, number);
        return ans;
    }

    public static void dfs(boolean choosePre, int curr, int[] number) {
        if (curr == number.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }

        dfs(false,curr + 1, number);
        if (!choosePre&&curr>0&&number[curr-1]==number[curr]){
            return;
        }
        t.add(number[curr]);
        dfs(true,curr + 1, number);
        t.remove(t.size() - 1);
    }


    public static void main(String[] args) {
        int[] number = {1, 2, 2};
        List<List<Integer>> res = getSubsets(number);
        System.out.println(JSONObject.toJSONString(res));
        int[] number2 = {1, 2, 2};
        List<List<Integer>> res2 = getSubsets2(number2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
