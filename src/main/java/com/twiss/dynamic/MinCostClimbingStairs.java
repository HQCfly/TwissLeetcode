package com.twiss.dynamic;

/**
 * 最小花费体力爬楼梯
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * @Author: Twiss
 * @Date: 2022/5/10 5:33 下午
 */
public class MinCostClimbingStairs {

    public int getMinCostClimbing(int[] cost){
        if (cost==null||cost.length==0){
            return 0;
        }
        if (cost.length==1){
            return cost[0];
        }
        // 表示第i步所花费的最小体力
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[0];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int ans = new MinCostClimbingStairs().getMinCostClimbing(cost);
        System.out.println(ans);
    }
}
