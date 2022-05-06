package com.twiss.greed;

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/5 11:29 下午
 */
public class FindMinArrowShots {

    public int getMinArrows(int[][] points){
        if (points==null||points.length==0){
            return 0;
        }
        Arrays.sort(points,(o1,o2)->Integer.compare(o1[0],o2[0]));
        int count = 1;
        for (int i=1;i<points.length;i++){
            if (points[i][0]>points[i-1][1]){
                count++;
            }else {
                // 选最小的长度，作为后续的剪枝
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        int ans = new FindMinArrowShots().getMinArrows(points);
        System.out.println(ans);
    }
}
