package com.twiss.huawei;

import java.util.Scanner;

/**
 * 电信号
 *
 * @Author: Twiss
 * @Date: 2022/6/24 5:39 下午
 */
public class ElectricalSignal {

    private int maxLen = Integer.MIN_VALUE;
    private String res;
    public String getMaxContinueSignal(String signal) {
        if (signal == null || signal.length() == 0) {
            return null;
        }
        if (signal.contains("00")) {//包含2各及以上的信号波
            String[] signals = signal.split("00");
            for (int i=0;i<signals.length;i++){
                String sign = signals[i];
                // 表示是第一个分组，只需要在结尾加0
                if (i==0){
                    isValid(sign+"0");
                }else if (i==signals.length-1){// 只需要在头部加0
                    isValid("0"+sign);
                }else {
                    isValid("0"+sign+"0");
                }
            }
        }else {// 单波
            isValid(signal);
        }
        if (maxLen==Integer.MIN_VALUE){
            return "-1";
        }else {
            return res;
        }
    }

    private void isValid(String signal) {
        boolean start = false;
        int startIndex = 0, endIndex = -1;
        char[] chars = signal.toCharArray();
        char pre = '1';
        for (int i=0;i<chars.length;i++){
            // 寻找连续波起始位置
            if (!start&&i+1<signal.length()&&chars[i]=='0'&&chars[i+1]=='1'){
                start = true;
                startIndex = i;
                pre = '0';
                continue;
            }
            // 如果是连续波，则将前一个标识保存
            if (pre!=chars[i]){
                pre = chars[i];
            }else if (pre=='1'&&chars[i]=='1'){// 如果非连续波则直接退出
                return;
            }else {
                endIndex = i;
                break;
            }
        }
        // 对max进行计算
        if (endIndex==-1){
            if (signal.length()-startIndex>maxLen){
                maxLen = signal.length()-startIndex;
                res = signal.substring(startIndex);
            }
        }else {
            if (endIndex-startIndex>maxLen){
                maxLen = endIndex-startIndex;
                res = signal.substring(startIndex,endIndex);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String sig = sc.nextLine();
            String ans = new ElectricalSignal().getMaxContinueSignal(sig);
            System.out.println(ans);
        }
    }
}
