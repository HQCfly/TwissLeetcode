package com.twiss.dynamic;

/**
 * 一和零
 * @Author: Twiss
 * @Date: 2022/5/15 12:01 下午
 */
public class FindMaxForm {

    public int getMaxForm(String[] strs,int m,int n){
        if (strs==null||strs.length==0){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (String str: strs){
            int zeroNum = 0, oneNum = 0;
            for (char c:str.toCharArray()){
                if (c=='1'){
                    oneNum++;
                }else {
                    zeroNum++;
                }
            }
            for (int i=m;i>=zeroNum;i--){
                for (int j=n;j>=oneNum;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m=5,n=3;
        int ans = new FindMaxForm().getMaxForm(strs,m,n);
        System.out.println(ans);
    }
}