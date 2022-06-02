package com.twiss.hashtable;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找常用字符
 * @Author: Twiss
 * @Date: 2022/6/2 11:43 上午
 */
public class CommonChars {

    public List<String> getCommonChars(String[] words){
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        int[] hash = new int[26];
        for (int i=0;i<words[0].length();i++){
            hash[words[0].charAt(i)-'a']++;
        }

        for (int i=1;i<words.length;i++){
            int[] hashOtherStr = new int[26];
            String word = words[i];
            for (int j=0;j<word.length();j++){
                hashOtherStr[word.charAt(j)-'a']++;
            }
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }
        for (int i=0;i<26;i++){
            while (hash[i]!=0){
                char c = (char) (i+'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        List<String> ans = new ArrayList<>();
        ans = new CommonChars().getCommonChars(words);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
