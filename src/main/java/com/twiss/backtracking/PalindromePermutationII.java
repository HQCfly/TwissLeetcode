package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/26 8:48 下午
 */
public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }

        int [] count = new int[256];
        int n = s.length();
        int po = -1;
        for(int i = 0; i<n; i++){
            count[s.charAt(i)]++;
        }

        int oneCount = 0;
        for(int i = 0; i<256; i++){
            oneCount += count[i]%2;

            if(count[i]%2 == 1){
                po = i;
            }
        }

        if(oneCount > 1){
            return res;
        }

        String init = "";
        if(po != -1){
            init += (char)po;
            count[po]--;
        }

        dfs(count, init, n, res);
        return res;
    }

    private void dfs(int [] count, String cur, int n, List<String> res){
        if(cur.length() == n){
            res.add(cur);
            return;
        }

        for(int i = 0; i<count.length; i++){
            if(count[i] > 0){
                count[i] -= 2;
                dfs(count, (char)i+cur+(char)i, n, res);
                count[i] += 2;
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<String> res = new PalindromePermutationII().generatePalindromes(s);
        System.out.println(JSONObject.toJSONString(res));
    }
}
