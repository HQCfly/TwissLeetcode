package com.twiss.dynamic;

/**
 * 01背包问题
 * @Author: Twiss
 * @Date: 2022/5/13 6:10 下午
 */
public class WeightBag {

    /**
     *      0    1      2       3       4
     *   0  0    0      0       0       0
     *   1  0    15     15      15      15
     *   2  0    15     15      20      35
     *   3  0    15     15      20      35
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public int getMaxValue(int[] weights, int[] values, int bag){
        int wlen = weights.length;
        int vlen = values.length;
        int[][] dp = new int[wlen+1][bag+1];
        for (int i=0;i<=wlen;i++){
            dp[i][0] = 0;
        }
        // 先遍历物品、在遍历背包容量
        for (int i=1;i<=wlen;i++){
            for (int j=0;j<=bag;j++){
                // 此处使用i-1是因为数组从0开始遍历
                if (j<weights[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[wlen][bag];
    }

    public static void main(String[] args) {
        int[] w={1,3,4};
        int[] v={15, 20, 30};
        int bag = 4;
        int maxValue = new WeightBag().getMaxValue(w,v,bag);
        System.out.println(maxValue);
    }

}
