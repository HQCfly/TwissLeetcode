package com.twiss.dynamic;

/**
 * 打家劫舍I
 * @Author: Twiss
 * @Date: 2022/5/17 1:19 下午
 */
public class Rob {

    public int getMaxMoney(int[] money){
        if (money==null||money.length==0){
            return 0;
        }
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(dp[0],dp[1]);
        for (int i=2;i<money.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);
        }
        return dp[money.length-1];
    }

    public static void main(String[] args) {
        int[] money = {2,7,9,3,1};
        int ans = new Rob().getMaxMoney(money);
        System.out.println(ans);
    }
}
