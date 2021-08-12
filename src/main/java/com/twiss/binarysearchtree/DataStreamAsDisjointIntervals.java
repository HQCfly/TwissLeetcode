package com.twiss.binarysearchtree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/8/12 12:35 下午
 */
public class DataStreamAsDisjointIntervals {

    private Set<Integer> set;

    public DataStreamAsDisjointIntervals(){
        set = new TreeSet<>();
    }

    public void addNum(int val){
        set.add(val);
    }

    public int[][] getIntervals(){
        List<int[]> res = new ArrayList<>();
        Iterator<Integer> integerIterator =set.iterator();
        // 逐个检查集合中相邻的两个元素
        int begin = integerIterator.next(), end = begin;
        while (integerIterator.hasNext()){
            int t = integerIterator.next();
            // 通过比较下一个元素和当前end之差是不是1，看是否需要开始新的区间
            if (t!=end+1){
                // 如果需要更新的话，就先把当前的区间放到返回值中，
                // 然后在重新开始新的区间
                res.add(new int[]{begin,end});
                begin = t;
                end = begin;
            }else {
                // 否则更新当前区间的end
                end = t;
            }
        }
        res.add(new int[]{begin,end});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals num = new DataStreamAsDisjointIntervals();
        num.addNum(1);
        num.addNum(3);
        num.addNum(7);
        num.addNum(2);
        num.addNum(6);
        int[][] res = num.getIntervals();
        System.out.println(JSONObject.toJSONString(res));
    }
}
