package com.twiss.greed;

/**
 * 跳跃到最后一个位置，最小步数
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/1 11:22 下午
 */
public class CanJumpII {

    public int getMinSteps(int[] arrays){
        if (arrays==null||arrays.length==0||arrays.length==1){
            return 0;
        }
        int n = arrays.length-1;
        int currDistance = 0;
        int maxDistance = 0;
        int steps = 0;
        for (int i=0;i<n;++i){
            maxDistance = Math.max(maxDistance,i+arrays[i]);
            if (maxDistance>=n){
                steps++;
                break;
            }
            if (i==currDistance){
                currDistance = maxDistance;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arrays = {2,3,1,1,4};
        int ans = new CanJumpII().getMinSteps(arrays);
        System.out.println(ans);
    }
}
