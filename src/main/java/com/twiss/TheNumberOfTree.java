package com.twiss;

/**
 * @Author: Twiss
 * @Date: 2022/3/15 7:05 下午
 */
public class TheNumberOfTree {

    private int result = 0;

    public int getNumber(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int n = arrays.length;
        int level = getLeve(n)+1;
        for (int i = 0; i < n/2; ++i) {
           int newLeft = 2*i+1;
           int newRight = 2*i+2;
           if (arrays[i]!=-1&&arrays[newLeft]==-1&&arrays[newRight]==-1){
               result++;
           }
           if (newLeft>=(int) Math.pow(2,level-1)&&(arrays[newLeft]!=-1)){
               result++;
           }
            if (newRight>=(int) Math.pow(2,level-1)&&(arrays[newRight]!=-1)){
                result++;
            }
        }
        return result;
    }

    private int getLeve(int n){
        int re = 0;
        for (int i=0;i<n;++i){
            re += (int) Math.pow(2,i);
            if (re>=n){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, -1, 4, -5, 6,-1, -1, 7, 8, 9, -1, -1, 10};
        int ans = new TheNumberOfTree().getNumber(arrays);
        System.out.println(ans);
    }
}
