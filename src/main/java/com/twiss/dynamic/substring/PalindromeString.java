package com.twiss.dynamic.substring;

/**
 * 回文子串
 * @Author: Twiss
 * @Date: 2022/5/24 4:41 下午
 */
public class PalindromeString {

    public int getCountPalindromeByDp(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        int ans = 0, len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i=0;i<len;i++){
            for (int j=0;j<=i;j++){
                if (s.charAt(i)==s.charAt(j)){
                    if (i-j<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i-1][j+1];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if (dp[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int getPalindromeByDouble(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        int ans = 0, len = s.length();
        // 由i点开始向两边同步扩散对比
        for (int i=0;i<2*len-1;i++){
            int left = i/2, right = left+i%2;
            while (left>=0&&right<len&&s.charAt(left)==s.charAt(right)){
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaa";
        int count = new PalindromeString().getCountPalindromeByDp(s);
        System.out.println(count);

        int count2 = new PalindromeString().getPalindromeByDouble(s);
        System.out.println(count2);
    }
}
