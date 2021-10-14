package com.twiss.sort;

/**
 * @Author: Twiss
 * @Date: 2021/10/14 8:01 下午
 */
public class Hindex {

    public int getHIndex(int[] cs) {
        int n = cs.length;
        int l = 0, r = n;
        while (l<r){
            int mid = l+r+1>>1;
            if (check(cs,mid)){
                l = mid;
            }else {
                r = mid-1;
            }
        }
        return l;
    }

    private boolean check(int[] cs, int mid){
        int ans = 0;
        for (int i:cs){
            if (i>=mid){
                ans++;
            }
        }
        return ans>=mid;
    }

    public static void main(String[] args) {
        int[] cs = {3,0,6,1,5};
        int res = new Hindex().getHIndex(cs);
        System.out.println(res);
    }
}
