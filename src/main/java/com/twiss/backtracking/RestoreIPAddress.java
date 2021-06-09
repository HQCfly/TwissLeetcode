package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
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
        int n = ip.length();
        if (n<4||n>12){
            return res;
        }
        Deque<String> deque = new ArrayDeque<>(4);
        dfs(n,0,0,ip,deque,res);
        return res;
    }

    private void dfs(int n, int start, int splitTimes, String ip, Deque<String> path, List<String> res) {
        if (start == n) {
            if (splitTimes == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 看到剩下的不够就退出，len-begin表示剩余的未分割的字符串位数
        if (n - start < 4 - splitTimes || (4 - splitTimes) * 3 < n - start) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (start + i >= n) {
                break;
            }
            int ipSegment = judgeIpSegment(ip, start, start + i);
            if (ipSegment != -1) {
                path.addLast(ipSegment + "");
                dfs(n, start + i + 1, splitTimes + 1, ip, path, res);
                path.removeLast();
            }
        }

    }

    private int judgeIpSegment(String tmpIP, int start, int end) {
        int len = end-start+1;
        // 大于1位时候，第一个不能为0
        if (len>1&&tmpIP.charAt(start)=='0'){
            return -1;
        }

        // 转成int类型
        int res = 0;
        for (int i=start;i<=end;i++){
            res = res*10+tmpIP.charAt(i)-'0';
        }

        if (res>255){
            return -1;
        }

        return res;
    }

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs2(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    private void dfs2(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment2(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs2(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment2(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new RestoreIPAddress().getNewIPAddress(s);
        System.out.println(JSONObject.toJSONString(res));

        String s2 = "25525511135";
        List<String> res2 = new RestoreIPAddress().restoreIpAddresses(s2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
