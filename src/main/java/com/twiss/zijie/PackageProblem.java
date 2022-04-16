package com.twiss.zijie;

/**
 * 01背包
 * @Author: Twiss
 * @Date: 2022/4/16 9:32 下午
 */
public class PackageProblem {

    public int getMaxValue(int n,int c,int[] v,int[] w){
        // 表示前i个物品体积不超过c的价值
        int[][] dp = new int[n][c+1];
        for (int i=0;i<=c;++i){
            dp[0][i] = i>=v[0]?w[0]:0;
        }

        for (int i=1;i<n;i++){
            for (int j=0;j<c+1;j++){
                int tmp = dp[i-1][j];
                int y = j >= v[i] ? dp[i-1][j-v[i]] + w[i] : 0;
                dp[i][j] = Math.max(tmp,y);
            }
        }
        return dp[n-1][c];
    }

    public static void main(String[] args) {
        int N =3;
        int V =5;
        int[] v ={4,2,3};
        int[] w ={4,2,3};
        int max = new PackageProblem().getMaxValue(N,V,v,w);
        System.out.println(max);
    }
}
