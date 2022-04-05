package com.twiss.zijie;

import java.util.HashMap;

/**
 * 最长无重复子串
 * 快慢指针+滑动窗口
 * start = Math.max(map.get(c),start)
 * @Author: Twiss
 * @Date: 2022/3/30 3:35 下午
 */
public class LongestSubString {

    public int getLongest(String strings){
        int n = strings.length(), ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int start =0,end=0;end<n;end++){
            Character character = strings.charAt(end);
            // 更新start
            if (map.containsKey(character)){
                start = Math.max(map.get(character),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(strings.charAt(end),end+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String strings = "abababc";
        int ans = new LongestSubString().getLongest(strings);
        System.out.println(ans);
    }
}
