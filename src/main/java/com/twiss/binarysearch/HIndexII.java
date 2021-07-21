package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/21 8:55 下午
 */
public class HIndexII {

    private int getHIndex(int[] thesis){
        int n = thesis.length;
        int low = 0, high = n-1;
        while (low<high){
            int mid = low+(high-low)/2;
            if (thesis[mid]>=n-mid){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return n-low;
    }

    public static void main(String[] args) {
        int[] thesis = {0,1,3,5,6};
        int res = new HIndexII().getHIndex(thesis);
        System.out.println(res);
    }
}
