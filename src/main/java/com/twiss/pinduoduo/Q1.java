package com.twiss.pinduoduo;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/4/10 7:11 下午
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int nums = scanner.nextInt();
            int[] colorsList = new int[nums];
            for (int j=0;j<nums;++j){
                colorsList[j] = scanner.nextInt();
            }
            // key是颜色，value是同样颜色的下标
            HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
            for (int i=0;i<nums;++i){
                Integer tmp = colorsList[i];
                if (!hashMap.containsKey(tmp)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    hashMap.put(tmp,list);
                }else {
                    List<Integer> list = hashMap.get(tmp);
                    list.add(i);
                    hashMap.put(tmp,list);
                }
            }
            // 判断是否是等差数列
            HashMap<Integer, Integer> ans = new HashMap<>();
            for (Integer color:hashMap.keySet()){
                List<Integer> list = hashMap.get(color);
                int preElement = 0;
                int preDis = 0;
                boolean isValid = true;
                for (int i=0;i<list.size();++i){
                    if (i==0){
                        preElement = list.get(i);
                    }else {
                        int index = list.get(i);
                        int newDis = index-preElement;
                        if (preDis!=0&&newDis!=preDis){
                            isValid = false;
                        }
                        preDis = newDis;
                        preElement = index;
                    }
                }
                // 如果是等差数列，加入结果集当中
                if (isValid){
                    ans.put(color,preDis);
                }
            }

            System.out.println(hashMap.keySet().size());
            for (Integer color:ans.keySet()){
                System.out.println(color+" "+ans.get(color));
            }
        }
    }

}
