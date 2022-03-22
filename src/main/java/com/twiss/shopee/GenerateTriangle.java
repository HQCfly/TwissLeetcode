package com.twiss.shopee;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 时间复杂度O(n^2)
 * 空间复杂度O(n)
 * 输出第k行的i行至j列的和
 * @Author: Twiss
 * @Date: 2022/3/21 9:08 下午
 */
public class GenerateTriangle {

    public List<List<Integer>> getTriangle(int rowNums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < rowNums; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j==0||j==i){
                    row.add(1);
                }else {
                    row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }

    public int getSum(int rowNums,int start, int end){
        int ans = 0;
        List<List<Integer>> triangle = getTriangle(rowNums);
        List<Integer> kth = triangle.get(rowNums-1);
        for (int i=0;i<kth.size();++i){
            if (i>=start&&i<=end){
                ans+=kth.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int row = 5;
        int i=2,j=4;
        int ans = new GenerateTriangle().getSum(row,i,j);
        System.out.println(ans);
    }
}
