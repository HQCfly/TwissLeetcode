package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/21 9:03 下午
 */
public class GrayCode {

    private List<Integer> getGrayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);//初始化 n = 0 的解
        for (int i = 0; i < n; i++) {
            int add = 1 << i;//要加的数
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + add);
            }
        }
        return res;
    }

    /**
     * << : 左移运算符，num << 1,相当于num乘以2
     * >> : 右移运算符，num >> 1,相当于num除以2
     * @param n
     * @return
     */
    private List<Integer> getGrayCode2(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for(int binary = 0;binary < 1 << n; binary++){
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer> res = new GrayCode().getGrayCode(n);
        System.out.println(JSONObject.toJSONString(res));
        List<Integer> res2 = new GrayCode().getGrayCode2(n);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
