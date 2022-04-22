package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

/**
 * 合并有序数组
 * 时间内复杂度O(m+n)
 * 内复杂度O(m+n)
 * @Author: Twiss
 * @Date: 2022/4/22 9:09 下午
 */
public class SortedArray {

    public int[] getSorted(int[] nums1,int m, int[] nums2,int n){
        int[] sorted = new int[n+m+1];
        int p1 =0, p2 =0;
        int curr;
        while (p1<m||p2<n){
            if (p1==m){
                curr = nums2[p2++];
            }else if (p2==n){
                curr = nums1[p1++];
            }else if (nums1[p1]<nums2[p2]){
                curr = nums1[p1++];
            }else {
                curr = nums2[p2++];
            }
            sorted[p1+p2-1] = curr;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int m= 3;
        int[] num2 = {2,5,6};
        int n =3;
        int[] ans = new SortedArray().getSorted(num1,m,num2,n);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
