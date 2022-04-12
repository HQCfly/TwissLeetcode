package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

/**
 * 合并数组
 * 时间复杂度O(m+n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/12 5:31 下午
 */
public class MergeArray {

    public int[] merge(int[] num1,int m,int[] num2, int n){
        int p1 = m-1, p2 = n-1;
        int tail = m+n-1;
        int curr;
        while (p1>=0||p2>=0){
            if (p1==-1){
                curr = num2[p2--];
            } else if (p2==-1){
                curr = num1[p1--];
            } else if (num1[p1]>num2[p2]){
                curr = num1[p1--];
            } else {
                curr = num2[p2--];
            }
            num1[tail--] = curr;
        }
        return num1;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int m = 3;
        int n = 3;
        int[] ans = new MergeArray().merge(num1,m,num2,n);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
