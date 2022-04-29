package com.twiss.zijie;

/**
 * 小于n的最大数
 * 输入：23121, [2,4,9]
 * @Author: Twiss
 * @Date: 2022/4/29 10:16 上午
 */
public class TheMaxNumber {

    public static void main(String[] args) {
        String n = "23121";

        int[] list = {2,4,9};
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        for (int i=0;i<n.length();++i){
            int nextNum = 0;
            int minDiff = Integer.MAX_VALUE;
            int maxDiff = Integer.MIN_VALUE;
            for (int j=0;j<list.length;j++){
                int tmp = Integer.parseInt(String.valueOf(n.charAt(i)));
                int diff = Math.abs(list[j]-tmp);
                if (flag==i&&diff==0){
                    flag++;
                    nextNum = j;
                    break;
                }
                // 针对小于的
                if (diff<=minDiff){
                    minDiff = diff;
                    if (flag==i&&list[j]<tmp){
                        nextNum = j;
                    }
                }
                // 针对后续的最大位数
                if (i>flag&&diff>maxDiff&&list[j]>tmp){
                    maxDiff = diff;
                    nextNum = j;
                }
                System.out.println("j:" +j);
            }
            System.out.println("i:"+i);
            stringBuilder.append(list[nextNum]);
            System.out.println(stringBuilder.toString());
        }
    }
}
