package com.twiss.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 信道分配
 * @Author: Twiss
 * @Date: 2022/6/30 10:22 下午
 */
public class SignalDistribute {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = Integer.parseInt(scanner.nextLine()); // 最大阶数
        // 信道容量
        String[] NiStrs = scanner.nextLine().split(" ");
        int[][] Nis = new int[R + 1][2]; // 每种信道的数量Ni。按照阶的值从小到大排列
        // [
        //  [1,10],
        //  [2,5],
        //  [4,0],
        //  [8,1],
        //  [16,3],
        //  [32,2]
        // ]
        for (int i = 0; i < Nis.length; i++) {
            Nis[i][0] = (int) Math.pow(2, i);
            Nis[i][1] = Integer.parseInt(NiStrs[i]);
        }

        int D = Integer.parseInt(scanner.nextLine()); // 单个用户需要传输的数据量

        int count = 0;
        // {Ni, NiLeftCount}
        Map<Integer, Integer> NiLeft = new HashMap<>();
        for (int[] ni : Nis) {
            // 信道容量
            int Ni = ni[0];
            // 信道个数
            int NiCount = ni[1];
            // 表示信道个数为0则不需要传送
            if (NiCount == 0) {
                continue;
            }
            // Ni信道容量大于D表示能够直接传送
            if (Ni >= D) {
                count += NiCount;
                continue;
            }
            // 信道容量小于D的情况
            // 余数，比如30%16 = 14
            int mo = D % Ni;
            // 商数，比如30/ 16 = 1
            int quotient = D / Ni;
            // 需要该Ni的数量
            int needCount = mo == 0 ? quotient : quotient + 1;
            // 计算NiCount能满足多少个用户
            count += NiCount / needCount;

            // 剩余个数
            int NiCountLeft = NiCount - (NiCount / needCount) * needCount;

            if (NiLeft.size() != 0) {
                int temp = 0;
                for (Map.Entry<Integer, Integer> en : NiLeft.entrySet()) {
                    temp += en.getKey() * en.getValue();
                }

                // 单个用户还剩多少数据量
                int DLft = D - temp;
                int moLeft = DLft % Ni;
                int quotientLeft = DLft / Ni;
                int needCountLeft = moLeft == 0 ? quotientLeft : quotientLeft + 1;

                if (NiCountLeft >= needCountLeft) {
                    NiLeft.clear();
                    count++;
                    NiCountLeft -= needCountLeft;
                }

            }

            if (NiCountLeft > 0) {
                NiLeft.put(Ni, NiCountLeft);
            }
        }

        System.out.println(count);
    }
}
