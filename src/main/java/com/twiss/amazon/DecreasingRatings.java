package com.twiss.amazon;

import java.util.List;

/**
 * https://leetcode.cn/circle/discuss/07HfuL/
 * @Author: Twiss
 * @Date: 2022/8/20 10:37 下午
 */
public class DecreasingRatings {
    //第二题 计算每次下降一个单位的排序(r,r-1,r-2...)的个数,例如[5,4,3,2]
// 5  4  3  2  5,4  4,3  3,2  5,4,3  4,3,2  5,4,3,2
// 返回10
    public static long countDecreasingRatings(List<Integer> ratings) {
        // Write your code here
        long result = 0;
        result += ratings.size();//长度为1的都需要统计
        for (int i = 2; i <= ratings.size(); i++) {//i为长度，从2开始
            for (int j = 0; j < ratings.size() + 1 - i; j++) {
                boolean flag = true;
                for (int k = j + 1; k < j + i; k++) {
                    if (ratings.get(k - 1).compareTo(ratings.get(k) + 1) != 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    result++;
                }
            }
        }
        return result;
    }

}
