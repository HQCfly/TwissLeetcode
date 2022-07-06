package com.twiss.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串匹配
 * @Author: Twiss
 * @Date: 2022/7/5 9:33 下午
 */
public class StringMatch {

    public boolean isMatch(String s,String p){
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int m = cs.length, n = cp.length;
        boolean[][] dp = new boolean[m+1][n+1];
        // 初始化
        dp[0][0] = true;
        // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int i=1;i<=n;i++){
            if (cp[i-1]=='*'){
                dp[0][i] = true;
            }
        }

        // 填格子
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                // 文本串和模式串末位字符能匹配上
                if (cs[i-1]==cp[j-1]||cp[j-1]=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (cp[j-1]=='*'){
                    // 模式串末位是*
                    // 模式串*的前一个字符能够跟文本串的末位匹配上
                    if (cs[i-1]==cp[j-2]||cp[j-2]=='.'){
                        dp[i][j]=dp[i][j-2] // *匹配0次的情况
                                ||dp[i-1][j];// *匹配1次或多次的情况
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String p = sc.nextLine();
        StringMatch stringMatch = new StringMatch();
        List<Integer> ans = new ArrayList<Integer>();
        for (int i=0;i<s.length;i++){
            if (stringMatch.isMatch(s[i],p)){
                ans.add(i);
            };
        }
        if (ans.size()==0){
            System.out.println(-1);
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<ans.size();i++){
                sb.append(ans.get(i));
                if (i<ans.size()-1){
                    sb.append(",");
                }
            }
            System.out.println(new String(sb));
        }
    }
}
