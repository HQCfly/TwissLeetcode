package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/20 9:36 下午
 */
public class GenerateParentheses {

    private List<String> getGenerateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    private void backtrace(StringBuilder cur, int open, int close, int n, List<String> ans) {
        if (cur.length() == n * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < n) {
            cur.append("(");
            backtrace(cur, open + 1, close, n, ans);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(")");
            backtrace(cur,open,close+1,n,ans);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = new GenerateParentheses().getGenerateParenthesis(n);
        System.out.println(JSONObject.toJSONString(res));
    }
}
