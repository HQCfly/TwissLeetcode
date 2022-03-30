package com.twiss.zijie;

/**
 * 完成工作的时间
 * 工作量为N，效率从1开始累加，最大效率为M
 * 最大效率持续T分钟，持续T分钟会被强制休息10分钟，然后从1开始
 * 每分钟以后可以主动休息5分钟，效率变成休息前的一半（向下取整）
 * 最快多久可以完成工作
 *
 * 26 5 3
 *
 * 20 5 2
 * @Author: Twiss
 * @Date: 2022/3/30 10:04 下午
 */
public class TheTimeOfFinishWork {

    /**
     *
     * @param n 工作量
     * @param m 最大工作效率
     * @param t 最大持续T分钟
     * @return
     */
    public int getTime(int n,int m,int t){
        int nowWorkEfficiency = 1;
        int durableMaxWorkEfficiency = 1;
        int ans = 0;
        while (n>0){
            n-=nowWorkEfficiency;
            ans++;
            // 当前工作效率未达到最大效率，直接进行效率++
            if (nowWorkEfficiency<m){
                nowWorkEfficiency++;
            }else {
                // 达到了最大效率
                // 持续最大效率时间
                if (durableMaxWorkEfficiency<=t-2){
                    durableMaxWorkEfficiency++;
                }else {

                    // 此时如果n工作量已经小于当前的工作效率，则直接返回
                    if (n<=nowWorkEfficiency){
                        ans++;
                        break;
                    }else {
                        // 当前已经是t-1，下一阶段会进入休眠阶段，选择休息5分钟，效率减半
                        nowWorkEfficiency/=2;
                        ans+=5;
                        durableMaxWorkEfficiency=1;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=26, m=5,t=3;
        int ans = new TheTimeOfFinishWork().getTime(n,m,t);
        System.out.println(ans);
    }
}
