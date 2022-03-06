package com.twiss.microsoftII;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复最长子串
 * 滑动窗口+快慢指针
 * 时间复杂度O(n)
 *
 * @Author: Twiss
 * @Date: 2022/3/6 4:34 下午
 */
public class LengthOfLongestSubstring2 {

    public int getLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> characterSet= new HashSet<>();
        int n = s.length();
        int fast = -1, ans = 0;
        for (int slow = 0; slow < n; ++slow) {
            // slow指针向后移动，所以需要移除该符号
            if (slow!=0){
                characterSet.remove(s.charAt(slow));
            }
            // 此时快指针向后移动
            while (fast+1<n&&!characterSet.contains(s.charAt(fast+1))){
                characterSet.add(s.charAt(fast+1));
                fast++;
            }
            ans = Math.max(ans,fast-slow+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = new LengthOfLongestSubstring2().getLength(s);
        System.out.println(ans);
    }
}
