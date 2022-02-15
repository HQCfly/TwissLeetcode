package com.twiss.slidwindow;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 * @Author: Twiss
 * @Date: 2022/2/15 2:48 下午
 */
public class SubstringWithConcatenation {

    public List<Integer> findSubString(String s, String[] words){
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum==0){
            return res;
        }
        int wordLen = words[0].length();
        // hash表存储words
        HashMap<String,Integer> wordHash = new HashMap<>();
        for (String word:words){
            int value = wordHash.getOrDefault(word,0);
            wordHash.put(word,value+1);
        }
        // 遍历所有的子串
        for (int i=0;i<s.length()-wordNum*wordLen+1;i++){
            // 存储子串遍历到的字母
            HashMap<String,Integer> hasWord = new HashMap<>();
            int num = 0;
            while (num<wordNum){
                String substring = s.substring(i+num*wordLen,
                        i+(num+1)*wordLen);
                //判断该单词在 wordHash 中
                if (wordHash.containsKey(substring)){
                    int value = hasWord.getOrDefault(substring,0);
                    hasWord.put(substring,value+1);
                    // 判断当前单词的 value 和 wordHash 中该单词的 value
                    if (hasWord.get(substring)>wordHash.get(substring)){
                        break;
                    }
                }else {
                    break;
                }
                num++;
            }
            // 判断是不是所有的字符串都符合要求
            if (num==wordNum){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> res = new SubstringWithConcatenation().findSubString(s,words);
        System.out.println(JSONObject.toJSONString(res));
    }
}
