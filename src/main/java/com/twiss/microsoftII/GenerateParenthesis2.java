package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/3/11 2:17 下午
 */
public class GenerateParenthesis2 {

    public List<String> getParenthesis(int n){

        List<String> ans = new ArrayList<>();
        if (n==0){
            return ans;
        }
        dfs(n,0,0,new StringBuilder(),ans);
        return ans;
    }

    private void dfs(int n, int left, int right,StringBuilder stringBuilder,List<String> ans){
        if (stringBuilder.length()==n*2){
            ans.add(stringBuilder.toString());
            return;
        }
        if (left<n){
            stringBuilder.append("(");
            dfs(n,left+1,right,stringBuilder,ans);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (right<left){
            stringBuilder.append(")");
            dfs(n,left,right+1,stringBuilder,ans);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        int n=3;
        List<String> ans = new GenerateParenthesis2().getParenthesis(n);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
