package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/8/9 8:56 下午
 */
public class ValidPerfectSquare {

    public boolean valid(int target){
        int l =0, h=target;
        while (l<=h){
            int mid = l+(h-l)/2;
            int tmp = mid*mid;
            if (tmp==target){
                return true;
            }else if (tmp<target){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 16;
        boolean res = new ValidPerfectSquare().valid(target);
        System.out.println(res);
    }
}
