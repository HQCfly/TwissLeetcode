package com.twiss.greed;

/**
 * Dota2 参议院
 * @Author: Twiss
 * @Date: 2022/5/8 3:43 下午
 */
public class PredictPartyVictory {

    public String getWin(String sentaStr){
        boolean R = true, D = true;
        // flag<0表示D在前，可以消灭R
        int flag = 0;
        byte[] senta = sentaStr.getBytes();
        while (R&&D){
            R = false;
            D = false;
            for (int i=0;i<senta.length;i++){
                if (senta[i]=='R'){
                    if (flag<0){
                        senta[i] = 0;
                    }else {
                        R  = true;
                    }
                    flag++;
                }
                if (senta[i] == 'D') {
                    if (flag>0){
                        senta[i] = 0;
                    }else {
                        D = true;
                    }
                    flag--;
                }
            }
        }
        return R==true?"Radiant":"Dire";
    }

    public static void main(String[] args) {
        String s= "RRDDD";
        String ans = new PredictPartyVictory().getWin(s);
        System.out.println(ans);
    }
}
