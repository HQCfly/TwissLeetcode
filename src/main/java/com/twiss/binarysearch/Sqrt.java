package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/8 10:30 下午
 */
public class Sqrt {

    public int getSqrt(int x){
        int l = 0, h = x, ans = -1;
        while (l<=h){
            int mid = l+(h-l)/2;
            if ((long) mid*mid<=x){
                ans = mid;
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 8;
        int res = new Sqrt().getSqrt(x);
        System.out.println(res);
    }
}
