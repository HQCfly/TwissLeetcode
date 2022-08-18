package com.twiss.flexport;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Click `Run` to execute the snippet below!
 *  this is a sentence it is a good one and it is also bad
 *  5
 *
 *  is not a sentence it
 * @Author: Twiss
 * @Date: 2022/8/18 7:14 下午
 */
public class ConstructNewWords {
    public String getNewWords(String words, int n){
        if(words==null){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        String[] wordsString = words.split(" ");
        Map<String, Set<String>> wordsMap = new HashMap<>();
        int length = wordsString.length;
        // 构建map
        for(int i=0;i<length-1;i++){
            String tmpKey = wordsString[i];
            String tmpValue = wordsString[i+1];
            if(!wordsMap.containsKey(tmpKey)){
                Set<String> wordSet = new HashSet<>();
                wordSet.add(tmpValue);
                wordsMap.put(tmpKey, wordSet);
            }else{
                wordsMap.get(tmpKey).add(tmpValue);
            }
        }

        if(!wordsMap.containsKey(wordsString[length-1])){
            Set<String> wordSet = new HashSet<>();
            wordSet.add(wordsString[0]);
            wordsMap.put(wordsString[length-1], wordSet);
        }else{
            wordsMap.get(wordsString[length-1]).add(wordsString[0]);
        }

        int randomI = new Random().nextInt(length-1);
        String randomWord = wordsString[randomI];
        while(n>0){
            ans.append(randomWord).append(" ");
            Set<String> wordTmpSet = wordsMap.get(randomWord);
            int tmpLen = wordTmpSet.size();
            randomI = new Random().nextInt(tmpLen);
            String[] tm = new String[tmpLen];
            int indx = 0;
            for (String v:wordTmpSet){
                tm[indx] = v;
                indx++;
            }
            randomWord = tm[randomI];
            n--;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String words = "this is a sentence it is a good one and it is also bad";
        int n = 5;
        String ans = new ConstructNewWords().getNewWords(words,n);
        System.out.println(ans);
    }
}
