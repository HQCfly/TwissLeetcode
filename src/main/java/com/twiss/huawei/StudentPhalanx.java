package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 学生方阵
 * @Author: Twiss
 * @Date: 2022/7/16 7:02 下午
 */
public class StudentPhalanx {

    private List<Integer> ans = new ArrayList<>();
    public int getMaxNumbersOfMan(String[][] grids){
        if (grids==null||grids.length==0){
            return 0;
        }
        int m = grids.length, n = grids[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grids[i][j].equals("M")){
                    getRes(grids,i,j);
                }
            }
        }
        Collections.sort(ans);
        return ans.get(ans.size()-1);
    }

    public void getRes(String[][] grids,int x,int y){
        int n=1;
        int a,b;
        int row = grids.length, col = grids[0].length;
        if (y<col){// 从此点水平向右
            a = x;
            b = y;
            while (b<col-1&&grids[a][++b].equals("M")){
                n++;
            }
            ans.add(n);
            n = 1;
        }
        if (x<row){// 从此点垂直向下
            a = x;
            b = y;
            while (a<row-1&&grids[++a][b].equals("M")){
                n++;
            }
            ans.add(n);
            n =1;
        }
        if (x<row&&y<col){// 正对角
            a = x;
            b = y;
            while (a<row-1&&b<col-1&&grids[++a][++b].equals("M")){
                n++;
            }
            ans.add(n);
            n =1;
        }
        if (x>=0&&y<col){// 反对角
            a = x;
            b = y;
            while (a>0&&b<col-1&&grids[--a][++b].equals("M")){
                n++;
            }
            ans.add(n);
        }
    }

    public static void main(String[] args) {
        String[][] grids = {
                {"F","M","M","F"},
                {"F","M","M","F"},
                {"F","F","M","M"},
                {"F","F","M","M"},
        };
        int ans = new StudentPhalanx().getMaxNumbersOfMan(grids);
        System.out.println(ans);
    }
}
