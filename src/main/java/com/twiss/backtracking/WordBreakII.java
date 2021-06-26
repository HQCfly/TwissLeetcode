package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/6/23 9:57 下午
 */
public class WordBreakII {

    private List<String> getResult(String words,List<String> wordDict) {


        return new ArrayList<>();
    }


    public static void main(String[] args) {
        String words = "";
        List<String> wordDict = new ArrayList<String>();
        List<String> res = new WordBreakII().getResult(words,wordDict);
        System.out.println(JSONObject.toJSONString(res));
    }

}
