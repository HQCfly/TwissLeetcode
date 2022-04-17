package com.twiss.zijie;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长子串
 * 滑动窗口双指针+哈希表
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/4/17 6:20 下午
 */
public class LengthOfLongestSubstring2 {

    public int getLengthOfSubstring(String word){
        if (word==null||word.length()==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int n = word.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int start =0, end =0;end<n;++end){
            Character tmp = word.charAt(end);
            if (map.containsKey(tmp)){
                start = Math.max(map.get(tmp),start);
            }
            max = Math.max(max,end-start+1);
            map.put(tmp,end+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String word = "abcabcbb";
        int max = new LengthOfLongestSubstring2().getLengthOfSubstring(word);
        System.out.println(max);
    }
}
