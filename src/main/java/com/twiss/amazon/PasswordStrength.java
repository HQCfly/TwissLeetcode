package com.twiss.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2022/8/20 10:36 下午
 */
public class PasswordStrength {

    //amazon笔试 2022/06/08
    //第一题 判断密码强度,例如"good",所有子串为
    // g o o d go oo od goo ood good
    // 1 1 1 1 2  1  2  2   2    3
    // 求和为16，返回16
    public static long findPasswordStrength(String password) {
        // Write your code here
        long result = 0;
        for (int i = 1; i <= password.length(); i++) {//i是长度
            Set<Character> set = new HashSet();
            for (int j = 0; j < password.length() + 1 - i; j++) {
                int count = 0;
                while (count < i) {
                    set.add(password.charAt(j + count));
                    count++;
                }
                result += set.size();
                set.clear();
            }
        }
        return result;
    }
}
