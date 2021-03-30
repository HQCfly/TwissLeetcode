package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/3/30 9:08 下午
 */
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> C = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j>0 ; j--) {
                row.set(j,row.get(j-1)+row.get(j));
            }
        }
        return row;
    }

    public static List<Integer> getRow4(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(row.get(i-1)*(rowIndex-i+1)/i);
        }
        return row;
    }

    public static void main(String[] args) {
        int rows = 3;
        List<Integer> res = getRow(rows);
        System.out.println(JSONObject.toJSONString(res));
        List<Integer> res2 = getRow2(rows);
        System.out.println(JSONObject.toJSONString(res2));
        List<Integer> res3 = getRow3(rows);
        System.out.println(JSONObject.toJSONString(res3));
        List<Integer> res4 = getRow4(rows);
        System.out.println(JSONObject.toJSONString(res4));
    }
}
