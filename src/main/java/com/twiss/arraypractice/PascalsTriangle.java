package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/3/30 9:09 下午
 */
public class PascalsTriangle {
    public static List<List<Integer>> getPascalsTriangle(int rows){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i=0;i<rows;++i){
            List<Integer> row = new ArrayList<>();
            for (int j =0;j <= i;++j){
                if (j==0||j==i){
                    row.add(1);
                }else {
                    row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
    public static void main(String[] args) {
        int rows = 5;
        List<List<Integer>> res = getPascalsTriangle(rows);
        System.out.println(JSONObject.toJSONString(res));
    }
}
