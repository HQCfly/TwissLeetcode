package com.twiss.shence;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/8/19 3:57 下午
 */
public class CalculateTImeIntervals {

    public String getStartTime(String[] dateTimeString,String format) {
        if (dateTimeString==null||dateTimeString.length==0){
            return "";
        }
        SimpleDateFormat sd = new SimpleDateFormat(format);
        Arrays.sort(dateTimeString);
        long max = Integer.MIN_VALUE;
        int len = dateTimeString.length;
        String ans = "";
        for (int i=0;i<len-1;i++){
            try {
                long diff = sd.parse(dateTimeString[i+1]).getTime()-sd.parse(dateTimeString[i]).getTime();
                if (diff>max){
                    max = diff;
                    ans = dateTimeString[i];
                }
            }catch (Exception e){
                return ans;
            }
        }
        try {
            long firstTime = sd.parse(dateTimeString[0]).getTime();
            long lastTime = sd.parse(dateTimeString[len-1]).getTime();
            long lastDiff = 24*1000*60*60-lastTime+firstTime;
            if (lastDiff>max){
                ans = dateTimeString[len-1];
            }
        }catch (Exception e){
            return ans;
        }

        return ans;
    }

    public static void main(String[] args) {
//        String format = "HH:MM:SS";
//        String[] dateTimeString = {"01:00:00","17:00:00","09:00:00"};
//        String ans = new com.twiss.shence.CalculateTImeIntervals().getStartTime(dateTimeString,format);
//        System.out.println(ans);
//        01:00:00 17:00:00 09:00:00
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dateTimeString = new String[n];
        sc.nextLine();
        String[] scTime = sc.nextLine().split(" ");
        for (int i=0;i<n;i++){
            dateTimeString[i] = scTime[i];
        }
        String ans = new CalculateTImeIntervals().getStartTime(dateTimeString,"HH:MM:SS");
        System.out.println(ans);
    }
}
