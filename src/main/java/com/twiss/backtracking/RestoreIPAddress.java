package com.twiss.backtracking;

import java.util.ArrayList;
import java.util.Deque;
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

    private void dfs(int n, int start, int residue, String ip, Deque<String> path, List<String> res) {
        if (start == n) {
            if (residue==0){
                res.add(String.join(".",path));
            }
            return;
        }

        for (int i = start; i < start+3; i++) {

        }

    }

    private boolean judgeIpSegment(String tmpIP){

        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new RestoreIPAddress().getNewIPAddress();
    }
}
