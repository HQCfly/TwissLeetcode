package com.twiss.microsoft;

/**
 *
 * @Author: Twiss
 * @Date: 2022/2/13 1:54 下午
 */
public class UniquePath {

    public int getUniquePath(int m,int n){
        int[][] dp = new int[m][n];
        for (int i=0;i<m;++i){
            dp[i][0] = 1;
        }
        for (int i=0;i<n;++i){
            dp[0][i] = 1;
        }

        for (int i=1;i<m;++i){
            for (int j=1;j<n;++j){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * [(m+n-2)(m+n-3)+...+n]/(m-1)!
     * @param m
     * @param n
     * @return
     */
    public int getUniquePathByCombine(int m, int n){
        long ans = 1;
        for(int x=n,j=1;j<m;x++,j++){
            ans = ans*x/j;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int m = 3, n =7;
        int res = new UniquePath().getUniquePath(m,n);
        System.out.println(res);

        int res2 = new UniquePath().getUniquePathByCombine(m,n);
        System.out.println(res2);
    }
}
