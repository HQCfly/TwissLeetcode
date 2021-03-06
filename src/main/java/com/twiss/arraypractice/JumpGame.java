package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/3/1 10:57 下午
 */
public class JumpGame {

    public static boolean solved(int[] arrays){
        int n = arrays.length;
        int reachMost = 0;
        for (int i = 0; i<n; ++i){
            if (i <= reachMost){
                reachMost = Math.max(reachMost,i+arrays[i]);
                if (reachMost>=n-1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrays = {3,2,1,0,4};
        boolean res = solved(arrays);
        System.out.println(res);
    }
}
