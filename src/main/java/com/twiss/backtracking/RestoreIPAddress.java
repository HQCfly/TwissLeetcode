package com.twiss.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/6/3 4:09 下午
 */
public class RestoreIPAddress {
    
    private List<String> getNewIPAddress(String ip) {
        List<String> res = new ArrayList<>();

        return res;
    }

    private void dfs(int n, String cur, List<String> res){
        if (cur.length()==n){
            res.add(cur);
            return;
        }



    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new RestoreIPAddress().getNewIPAddress();
    }
}
