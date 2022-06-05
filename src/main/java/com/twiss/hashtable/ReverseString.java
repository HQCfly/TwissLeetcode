package com.twiss.hashtable;

import com.alibaba.fastjson.JSONObject;

/**
 * 反转字符串
 * @Author: Twiss
 * @Date: 2022/6/5 3:24 下午
 */
public class ReverseString {

    public void getNewString(char[] s){
        int l = 0;
        int r = s.length-1;
        while (l<r){
            s[l]^=s[r];
            s[r]^=s[l];
            s[l]^=s[r];
            l++;
            r--;
        }
        System.out.println(JSONObject.toJSONString(s));
    }

    public static void main(String[] args) {
        char[] c = {'h','e','l','l','o'};
        new ReverseString().getNewString(c);
    }

}
