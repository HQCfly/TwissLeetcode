package com.twiss.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2022/6/3 5:58 下午
 */
public class FourSumCount {

    public int getCount(int[] array1, int[] array2, int[] array3, int[] array4){
        Map<Integer,Integer> map = new HashMap<>();
        int tmp;
        int ans = 0;
        for (int i:array1){
            for (int j:array2){
                tmp = i+j;
                if (map.containsKey(tmp)){
                    map.put(tmp,map.get(tmp)+1);
                }else {
                    map.put(tmp,1);
                }
            }
        }

        for (int i:array3){
            for (int j:array4){
                tmp = i+j;
                if (map.containsKey(-tmp)){
                    ans+=map.get(-tmp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {-2, -1};
        int[] array3 = {-1, 2};
        int[] array4 = {0, 2};
        int ans = new FourSumCount().getCount(array1,array2,array3,array4);
        System.out.println(ans);
    }
}
