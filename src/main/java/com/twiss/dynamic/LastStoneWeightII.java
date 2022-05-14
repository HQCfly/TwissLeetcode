package com.twiss.dynamic;

/**
 * 最后一块石头的重量II
 * @Author: Twiss
 * @Date: 2022/5/14 12:59 下午
 */
public class LastStoneWeightII {

    public int getLastStoneWeight(int[] stones){
        if (stones==null||stones.length==0){
            return 0;
        }
        int sum = 0;
        for (int stone:stones){
            sum+=stone;
        }
        int target = sum>>1;
        int[] dp= new int[target+1];
        for (int i=0;i<stones.length;i++){
            for (int j=target;j>=stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }

    public static void main(String[] args) {
        int[] stones = {2,4,1,1};
        int ans = new LastStoneWeightII().getLastStoneWeight(stones);
        System.out.println(ans);
    }
}
