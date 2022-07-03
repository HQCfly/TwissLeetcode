package com.twiss.huawei;

import java.util.Scanner;

/**
 * 转骰子
 * 作者：XiaJun
 * 链接：https://www.nowcoder.com/discuss/914921?type=0&order=0&pos=10&page=1&ncTraceId=&channel=-1&source_id=discuss_tag_nctrack
 * 来源：牛客网
 *
 * 根据图片我们得到：每一个指令，变化的都只有4个面
 * 那么我们将初始状态用一个数组表示int[] status = new int[]{1,2,3,4,5,6},每个下标分别代表左、右、前、后、上、下这几个面的数字。
 * 当指令为L时，根据图中规律：前、后两面不动，即：status[1],status[3]这两个数不变。
 * 当指令为L时，根据图中规律：左、上、右、下依次向右移一位，即相对于status[0]，
 * status[4]，status[2]，status[5]这四个数来说，把这四个当成一个子数组，子数组中的数依次向后移一次。
 *       [左，上，右，下]
 * 移动前：[1，5，2，6]
 * 移动后：[6, 1, 5, 2]
 * 其余指令类似，根据图中规律，进行类似操作
 * @Author: Twiss
 * @Date: 2022/7/3 9:35 下午
 */
public class TurnDice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String operation = sc.nextLine();
            int n = operation.length();
            //             左，右，前，后，上，下
            int[] status = {1, 2,  3, 4, 5,  6};
            for (int i=0;i<n;i++){
                switch (operation.charAt(i)){
                    case 'L':
                        int t = status[0];
                        status[0] = status[4];
                        status[4] = status[1];
                        status[1] = status[5];
                        status[5] = t;
                        break;
                    case 'R':
                        int tm = status[5];
                        status[5] = status[1];
                        status[1] = status[4];
                        status[4] = status[0];
                        status[0] = tm;
                        break;
                    case 'F':
                        int m = status[2];
                        status[2] = status[4];
                        status[4] = status[3];
                        status[3] = status[5];
                        status[5] = m;
                        break;
                    case 'B':
                        int mt = status[5];
                        status[5] = status[3];
                        status[3] = status[4];
                        status[4] = status[2];
                        status[2] = mt;
                        break;
                    case 'A':
                        int a = status[0];
                        status[0] = status[3];
                        status[3] = status[1];
                        status[1] = status[2];
                        status[2] = a;
                        break;
                    case 'C':
                        int c = status[2];
                        status[2] = status[1];
                        status[1] = status[3];
                        status[3] = status[0];
                        status[0] = c;
                        break;
                }
            }
            for (int statu:status){
                System.out.println(statu);
            }
        }
    }
}
