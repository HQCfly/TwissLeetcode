package com.twiss.flexport;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2022/8/21 10:04 下午
 */
public class LetterCombinationsII {

    public LetterCombinationsII(){
    }

    public List<String> getCombinations(String digits){
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<String,String> reflectMap = new HashMap<>();
        reflectMap.put("0","ab");
        reflectMap.put("1","c");
        reflectMap.put("01","z");
        System.out.println(JSONObject.toJSONString(reflectMap));
        backtrack(combinations,reflectMap,digits,0,new StringBuilder());
        return combinations;
    }

    private void backtrack(List<String> combinations,
                           Map<String,String> reflectMap,
                           String digits,
                           int index,
                           StringBuilder path){
        if (index>=digits.length()){
            combinations.add(new String(path));
        }else {
            for (int idx = 1;idx<digits.length()-index+1;idx++){
                String digit = digits.substring(index,index+idx);
                String reflect = reflectMap.getOrDefault(digit,"");
                int count = reflect.length();
                for (int i=0;i<count;i++){
                    path.append(reflect.charAt(i));
                    backtrack(combinations,reflectMap,digits,index+idx,
                            path);
                    path.deleteCharAt(index);
                }
            }
        }
    }

    public static void main(String[] args) {
        String digits = "001";
        List<String> ans = new LetterCombinationsII().getCombinations(digits);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
