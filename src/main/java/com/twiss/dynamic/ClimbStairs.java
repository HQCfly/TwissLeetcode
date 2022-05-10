package com.twiss.dynamic;

/**
 * 爬楼梯
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * @Author: Twiss
 * @Date: 2022/5/10 2:07 下午
 */
public class ClimbStairs {

    public int getNums(int stairs){
        int[] dp = new int[stairs+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=stairs;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[stairs];
    }

    public int getNumsByConstant(int stairs){
        int a = 0, b=1, c = 0;
        for (int i=1;i<=stairs;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 5;
        int ans = new ClimbStairs().getNums(n);
        System.out.println(ans);

        int ans2 = new ClimbStairs().getNumsByConstant(n);
        System.out.println(ans2);
    }
}
