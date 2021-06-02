package com.twiss.dynamic;

/**
 * @Author: Twiss
 * @Date: 2021/5/29 9:23 下午
 */
public class RegularExpressionMatching {

    private boolean isMatch(String s, String p) {
        if (p==null){
            return s == null;
        }

        if (s==null && p.length()==1){
            return false;
        }

        int m = s.length()+1;
        int n = p.length()+1;

        boolean[][]dp = new boolean[m][n];

        dp[0][0] = true;

        for (int j=2;j<n;j++){
            if (p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int r=1;r<m;r++){
            int i = r-1;
            for (int c=1;c<n;c++){
                int j = c-1;
                if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
                    dp[r][c] = dp[r-1][c-1];
                }else if (p.charAt(j)=='*'){
                    if (p.charAt(j-1)==s.charAt(i) || p.charAt(j-1)=='.'){
                        dp[r][c] = dp[r-1][c] || dp[r][c-2];
                    }else{
                        dp[r][c] = dp[r][c-2];
                    }
                }else{
                    dp[r][c] = false;
                }

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean res = new RegularExpressionMatching().isMatch(s,p);
        System.out.println(res);
    }
}
