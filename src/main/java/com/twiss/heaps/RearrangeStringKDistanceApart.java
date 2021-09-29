package com.twiss.heaps;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/9/27 11:04 下午
 */
public class RearrangeStringKDistanceApart {

    public String rearrangeString(String str, int k){
        if(str==null){
            return "";
        }else if (k<=1){
            return str;
        }
        // 将所有的字母扔进map中。例如：{"a":2}
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<str.length();++i){
            char word = str.charAt(i);
            if (!map.containsKey(word)){
                map.put(word,1);
            }else {
                map.put(word,map.get(word)+1);
            }
        }
        // 设置优先队列按照顺序排队
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b)->a-b);

        for (Character c:map.keySet()){
            priorityQueue.offer(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int len = str.length();
        while (!priorityQueue.isEmpty()){
            // 每次循环完毕k与len对比那个小
            int cnt = Math.min(k,len);
            // 存储有重复的元素
            List<Character> temp = new ArrayList<>();
            // 按照长度遍历
            for (int i=0;i<cnt;++i){
                if (priorityQueue.isEmpty()){
                    return "";
                }
                // 取出当前的元素值
                char curr = priorityQueue.poll();
                // 将当前的元素值加入StringBuilder中
                stringBuilder.append(curr);
                // 将map中出现的字母数量减去1
                map.put(curr,map.get(curr)-1);
                // str的长度也减去1，因为后续可能k比len大
                len--;
                // 如果curr在map中的数量大于0，则加入存储重复元素的list中
                if (map.get(curr)>0){
                    temp.add(curr);
                }
            }
            // 将剩余重复元素继续加入优先队列中
            for (Character c:temp){
                priorityQueue.offer(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "aabbcc";
        int k = 3;
        String res = new RearrangeStringKDistanceApart().rearrangeString(s,k);
        System.out.println(JSONObject.toJSONString(res));
    }
}
