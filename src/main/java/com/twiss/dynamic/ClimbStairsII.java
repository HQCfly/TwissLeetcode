package com.twiss.dynamic;

/**
 * 爬楼梯方案总数
 *
 * @Author: Twiss
 * @Date: 2022/5/16 1:32 下午
 */
public class ClimbStairsII {

    public int getPlans(int n, int[] stairs){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=0;i<=n;i++){
            for (int j=0;j<stairs.length;j++){
                if (i>=stairs[j]){
                    dp[i] += dp[i-stairs[j]];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] stairs = {1,2};
        int n = 3;
        int ans = new ClimbStairsII().getPlans(n,stairs);
        System.out.println(ans);
    }

}
