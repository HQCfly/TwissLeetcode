package com.twiss.dynamic;

/**
 * 完全背包
 * @Author: Twiss
 * @Date: 2022/5/15 3:18 下午
 */
public class CompletePack {

    public int getMaxValue(int[] w,int[] v, int bag){
        int[] dp = new int[bag+1];
        // 先遍历物品，其次遍历背包容量
        for (int i=0;i<w.length;i++){
            for (int j=w[i];j<=bag;j++){
                dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[bag];
    }

    public static void main(String[] args) {
        int[] w= {1,3,4};
        int[] v= {15,20,30};
        int bag =4;
        int ans = new CompletePack().getMaxValue(w,v,bag);
        System.out.println(ans);
    }
}
