package com.twiss.zijie;

import java.util.HashMap;

/**
 * 长度为n的，只有0、1组成的数组
 * 判断两个1之间是否至少有k个0
 * @Author: Twiss
 * @Date: 2022/3/30 9:34 下午
 */
public class TheNumberOfZeroBetweenOne {

    public boolean isValid(int[] arrays,int k){
        if (arrays==null||arrays.length==0){
            return false;
        }
        int pre = -1; boolean valid= false;
        for (int end=0;end<arrays.length;end++){
            int num = arrays[end];
            if (num==1){
                if (pre!=-1){
                    if (end-pre-1>=k){
                        valid = true;
                    }
                }
                pre = end;
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        int[] arrays = {0,1,0,0,1};
        int k = 1;
        boolean ans = new TheNumberOfZeroBetweenOne().isValid(arrays,k);
        System.out.println(ans);

        int[] arrays2 = {0,0,1,0,0};
        int k2 = 3;
        boolean ans2 = new TheNumberOfZeroBetweenOne().isValid(arrays2,k2);
        System.out.println(ans2);
    }
}
