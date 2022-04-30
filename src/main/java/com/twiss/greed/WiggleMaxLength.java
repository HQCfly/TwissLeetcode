package com.twiss.greed;

/**
 * 摆动数组最长序列长度
 * 波峰波谷
 * 贪心算法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/30 9:08 下午
 */
public class WiggleMaxLength {

    public int getWiggleMaxLength(int[] arrays){
        if (arrays==null||arrays.length==0){
            return 0;
        }
        int curr = 0,pre = 0;
        int count = 1;
        for (int i=1;i<arrays.length;i++){
            curr = arrays[i]-arrays[i-1];
            if (curr>0&&pre<=0||curr<0&&pre>=0){
                count++;
                pre = curr;
            }
        }
        return count;
    }

    public int getWiggleMaxLengthByDp(int[] arrays){
        if (arrays==null||arrays.length==0){
            return 0;
        }
        int[][] dp = new int[arrays.length][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i=1;i<arrays.length;++i){
            for (int j=0;j<i;j++){
                if (arrays[j]>arrays[i]){
                    dp[i][0] = Math.max(dp[i][0],dp[j][0]+1);
                }
                if (arrays[j]<arrays[i]){
                    dp[i][1] = Math.max(dp[i][1],dp[j][1]+1);
                }
            }
        }
        return Math.max(dp[arrays.length-1][0],dp[arrays.length-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int max = new WiggleMaxLength().getWiggleMaxLength(nums);
        System.out.println(max);
    }
}
