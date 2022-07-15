package com.twiss.huawei;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/7/15 2:15 下午
 */
public class Poker {

    public List<PokerStruct> getContinuePoker(int[] arr){
        List<PokerStruct> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int num: arr){
            queue.offer(num);
        }
        int lastValue = 0;
        while (!queue.isEmpty()){
            int currentValue = queue.pollFirst();
            if (lastValue == 0) {
                PokerStruct pokerStruct = new PokerStruct();
                pokerStruct.currentValue = currentValue;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(currentValue);
                pokerStruct.allData = tmp;
                ans.add(pokerStruct);
            }else {
                if (currentValue-lastValue==0){
                    boolean isAdded = false;
                    for (PokerStruct p:ans){
                        if (currentValue- p.currentValue==1){
                            p.currentValue = currentValue;
                            p.allData.add(currentValue);
                            isAdded = true;
                            break;
                        }
                    }
                    if (!isAdded){
                        PokerStruct p = new PokerStruct();
                        p.currentValue = currentValue;
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(currentValue);
                        p.allData = tmp;
                        ans.add(p);
                    }
                }else if (currentValue-lastValue==1){
                    for (PokerStruct p:ans){
                        if (lastValue==p.currentValue){
                            p.currentValue = currentValue;
                            p.allData.add(currentValue);
                            break;
                        }
                    }
                }else {
                    PokerStruct p = new PokerStruct();
                    p.currentValue = currentValue;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(currentValue);
                    p.allData= tmp;
                    ans.add(p);
                }
            }
            lastValue = currentValue;
        }
        return ans;
    }


    private static int getStringReflect(String poker){
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

    private static String getIntReflect(int poker){

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
        String[] input = sc.nextLine().split(" ");
        List<Integer> arrs = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals("2")){
                arrs.add(getStringReflect(input[i]));
            }
        }
        int[] arr = new int[arrs.size()];
        for (int i=0;i<arrs.size();i++){
            arr[i] = arrs.get(i);
        }
        Arrays.sort(arr);
        Poker poker = new Poker();
        List<PokerStruct> ans = poker.getContinuePoker(arr);
        int count = 0;
        for (PokerStruct p:ans){
            StringBuilder res = new StringBuilder();
            if (p.allData.size()>=5){
                for (int i=0;i<p.allData.size();i++){
                    String num = getIntReflect(p.allData.get(i));
                    res.append(num);
                    if (i!=p.allData.size()-1){
                        res.append(" ");
                    }
                }
                count++;
            }
            String result = new String(res);
            if (!"".equals(result)){
                System.out.println(result);
            }
        }
        if (count==0){
            System.out.println("NO");
        }
    }
}

class PokerStruct{
    int currentValue;
    List<Integer> allData;
    public PokerStruct(){

    }

    public PokerStruct(int currentValue,List<Integer> allData){
        this.currentValue = currentValue;
        this.allData = allData;
    }
}