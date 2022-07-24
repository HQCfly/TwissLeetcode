package com.twiss.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 最大社交距离
 * @Author: Twiss
 * @Date: 2022/7/24 6:16 下午
 */
public class MaxSocialDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int seatNum = in.nextInt();
        in.nextLine();
        String seat = in.nextLine();
        String[] c = seat.substring(1, seat.length() - 1).split(",");
        int[] seatOrLeave = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            seatOrLeave[i] = Integer.parseInt(c[i]);
        }
        int ans = seatDistance(seatNum, seatOrLeave);
        System.out.print(ans);
    }
    public static int seatDistance(int seatNum, int[] seatOrLeave) {
        TreeSet<Integer> seatedNums = new TreeSet<>();  // 使用TreeSet有序集合记录被坐过的座位
        for (int i = 0; i < seatOrLeave.length; i++) {
            int op = seatOrLeave[i];
            if (op > 0) {
                if (seatedNums.size() == 0) {  // 如果是第一个坐
                    if (i == seatOrLeave.length - 1) {  // 如果只有一个位置
                        return 0;
                    }
                    seatedNums.add(0);
                } else if (seatedNums.size() == 1) {  // 第二个人进来，坐在最右边
                    seatedNums.add(seatNum - 1);
                    if (i == seatOrLeave.length - 1) {  // 如果只有两个位置
                        return seatNum - 1;
                    }
                } else if (seatedNums.size() > 1 && seatedNums.size() < seatNum) { // 坐到中间的位置
                    int[] ints = new int[seatedNums.size()];
                    int count = 0;
                    for (Integer seatedNum : seatedNums) {  // 将已经坐过的位置存入到数组中
                        ints[count++] = seatedNum;
                    }
                    int maxLen = 0;
                    int start = 0;
                    for (int j = 0; j < ints.length - 1; j++) {  // 计算最远距离
                        int len = ints[j + 1] - ints[j];
                        if (len / 2 > maxLen) {
                            maxLen = len / 2;
                            start = ints[j];
                        }
                    }
                    seatedNums.add(start + maxLen);  // 将对应的起始位置加上最远距离加入seatedNums
                    if (i == seatOrLeave.length - 1) {
                        return start + maxLen;
                    }
                } else {  // 位置坐满
                    return -1;
                }
            } else {  // 如果是负数，则将该座位移出
                seatedNums.remove(-op);
            }
        }
        return 0;
    }
}
