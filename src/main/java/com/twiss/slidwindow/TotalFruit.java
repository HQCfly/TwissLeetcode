package com.twiss.slidwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 水果成蓝
 *
 * @Author: Twiss
 * @Date: 2022/5/28 3:31 下午
 */
public class TotalFruit {

    public int getMaxTree(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int n = fruits.length;
        for (int start = 0, end = 0; end < fruits.length; end++) {
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while (map.size()>2){
                map.put(fruits[start],map.get(fruits[start])-1);
                if (map.get(fruits[start])<0){
                    map.remove(fruits[start]);
                }
                start++;
            }
            res = Math.max(res,end-start+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        int ans = new TotalFruit().getMaxTree(fruits);
        System.out.println(ans);
    }
}
