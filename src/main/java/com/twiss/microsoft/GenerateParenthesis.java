package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 *
 * @Author: Twiss
 * @Date: 2022/1/29 9:16 下午
 */
public class GenerateParenthesis {

    public List<String> getParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("",0,0,n,res);
        return res;
    }

    private void dfs(String stringBuilder, int left,int right, int n,List<String> res){
        if (left==n&&right==n){
            res.add(stringBuilder.toString());
            return;
        }

        if (left<right){
            return;
        }

        if (left<n){
            dfs(stringBuilder+"(",left+1,right,n,res);
        }
        if (right<n){
            dfs(stringBuilder+")",left,right+1,n,res);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = new GenerateParenthesis().getParenthesis(n);
        System.out.println(JSONObject.toJSONString(res));
    }
}
