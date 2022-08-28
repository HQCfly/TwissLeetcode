package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

/**
 * 最大子数组和
 * 给定整数数组，其中0到多个连续整数构成子数组，反转任意子数组后，求新数组中子数组和的最大值
 * 比如1 2 3 -1 4，子数组-1 4反转后变成1 2 3 4 -1，最大子数组和是10
 * @Author: Twiss
 * @Date: 2022/8/28 10:26 上午
 */
public class MaxSumOfSubArrays {

    public int getMaxSum(int[] arrays){
        if (arrays==null||arrays.length==0){
            return 0;
        }
        int len = arrays.length;
        int reverseStart = 0;
        int reverseEnd = 0;

        for (int i=1;i<len-1;i++){
            if (arrays[i-1]>0&&arrays[i]<0){
                reverseStart = i;
            }
            if (arrays[i]<0&&arrays[i+1]>0){
                reverseEnd = i+1;
            }
        }
        reverse(arrays,reverseStart,reverseEnd);
        System.out.println(JSONObject.toJSONString(arrays));
        int[] dp = new int[len];
        dp[0] = arrays[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + arrays[i];
            } else {
                dp[i] = arrays[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private void reverse(int[] arrays, int start,int end){
        while (start<end){
            int tmp = arrays[start];
            arrays[start] = arrays[end];
            arrays[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,-1,4,-2,5};
        int ans = new MaxSumOfSubArrays().getMaxSum(nums);
        System.out.println(ans);
    }
}
