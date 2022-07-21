package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 对手最长顺子
 *
 * @Author: Twiss
 * @Date: 2022/7/20 6:58 下午
 */
public class TheLongestChainPoker {

    public String getLongestChain(String[] poker, String[] outputPoker) {
        StringBuilder ans = new StringBuilder();
        if (poker == null || poker.length == 0) {
            return new String(ans.append("NO-CHAIN"));
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 4);
        map.put(4, 4);
        map.put(5, 4);
        map.put(6, 4);
        map.put(7, 4);
        map.put(8, 4);
        map.put(9, 4);
        map.put(10, 4);
        map.put(11, 4);
        map.put(12, 4);
        map.put(13, 4);
        map.put(14, 4);
        for (int i = 0; i < poker.length; i++) {
            int num = getStringReflect(poker[i]);
            int times = map.get(num) - 1;
            if (times > 0) {
                map.put(num, times);
            } else {
                map.remove(num);
            }
        }
        for (int i = 0; i < outputPoker.length; i++) {
            int num = getStringReflect(outputPoker[i]);
            int times = map.get(num) - 1;
            if (times > 0) {
                map.put(num, times);
            } else {
                map.remove(num);
            }
        }
        int preStart = 0, preEnd = 0, preMax = 0, max = 1;
        List<Integer> keyList = new ArrayList<>(map.keySet());
        for (int start = 0, end = 1; end < keyList.size(); end++) {
            int dis = keyList.get(end) - keyList.get(end - 1);
            if (dis == 1) {
                max++;
                if (end == keyList.size() - 1) {
                    if (max >= preMax) {
                        preMax = max;
                        preStart = start;
                        preEnd = end;
                    }
                }
            } else {
                if (max >= preMax) {
                    preMax = max;
                    preStart = start;
                    preEnd = end - 1;
                }
                start = end;
                max = 1;
            }
        }
        if (preMax >= 5) {
            for (int i = preStart; i <= preEnd; i++) {
                String ele = getIntReflect(keyList.get(i));
                ans.append(ele);
                if (i != preEnd) {
                    ans.append("-");
                }
            }
        } else {
            ans.append("NO-CHAIN");
        }
        return new String(ans);
    }

    private static int getStringReflect(String poker) {
        switch (poker) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(poker);
        }
    }

    private static String getIntReflect(int poker) {

        switch (poker) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return String.valueOf(poker);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] poker = sc.nextLine().split("-");
        String[] outputPoker = sc.nextLine().split("-");
        String ans = new TheLongestChainPoker().getLongestChain(poker, outputPoker);
        System.out.println(ans);
    }
}
