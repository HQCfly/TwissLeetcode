package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * dfs
 *
 * @Author: Twiss
 * @Date: 2022/2/28 10:26 下午
 */
public class GenerateParenthesis {

    public List<String> getParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(ans, stringBuilder, 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans,
                          StringBuilder stringBuilder,
                          int open,
                          int close,
                          int max) {
        if (stringBuilder.length() == max * 2) {
            ans.add(stringBuilder.toString());
        }
        if (open<max){
            stringBuilder.append("(");
            backtrack(ans,stringBuilder,open+1,close,max);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (close<open){
            stringBuilder.append(")");
            backtrack(ans,stringBuilder,open,close+1,max);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new GenerateParenthesis().getParenthesis(n);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
