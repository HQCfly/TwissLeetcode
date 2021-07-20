package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/20 6:49 下午
 */
public class FirstBadVersion {

    private int getBadVersion(int num) {
        int low = 0, high = num;
        while (low<high){
            int mid = low+(high-low)/2;
            if (isBadVersion(mid)){
                high = mid;// 答案在区间 [left, mid] 中
            }else {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int num){
        return num==4;
    }

    public static void main(String[] args) {
        int n = 5;
        int res = new FirstBadVersion().getBadVersion(n);
        System.out.println(res);
    }
}
