package com.twiss.dynamic.substring;

/**
 * @Author: Twiss
 * @Date: 2022/5/23 1:21 下午
 */
public class IsSubsequence {

    public boolean isValid(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[m][n]==m){
            return true;
        }else {
            return false;
        }
    }

    public boolean isValidByDouble(String s1, String s2){
        int m = s1.length(), n = s2.length();
        for (int slow=0,fast=0;fast<n;fast++){
            if (s2.charAt(fast)==s1.charAt(slow)){
                slow++;
            }
            if (slow==m){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        boolean ans = new IsSubsequence().isValid(s1,s2);
        System.out.println(ans);

        boolean ans2 = new IsSubsequence().isValidByDouble(s1,s2);
        System.out.println(ans2);
    }
}
