package com.twiss.greed;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割字符
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/5/6 3:54 下午
 */
public class PartitionLabels {

    public List<Integer> getPartition(String words){
        List<Integer> ans = new ArrayList<>();
        if (words==null||words.length()==0){
            return null;
        }
        int[] edge = new int[26];
        char[] chars = words.toCharArray();
        for (int i=0;i<chars.length;i++){
            edge[chars[i]-'a'] = i;
        }
        int idx = 0;
        int last = -1;

        for (int i=0;i<chars.length;i++){
            idx = Math.max(idx,edge[chars[i]-'a']);
            if (idx==i){
                ans.add(i-last);
                last = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String words = "ababcbacadefegdehijhklij";
        List<Integer> ans = new PartitionLabels().getPartition(words);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
